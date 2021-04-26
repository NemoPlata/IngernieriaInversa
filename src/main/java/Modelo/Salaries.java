package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salaries")
public class Salaries {
    
    @Id
    @Column(name="emp_no")
    private int emp_no;
    
    @Column(name="salary")
    private int salary;
    
    @Column(name="from_date")
    private Date from_date;
    
    @Column(name="to_date")
    private Date to_date;

    public Salaries(int emp_no, int salary, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.salary = salary;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public Salaries() {
    
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        return "Salaries[" + "emp_no=" + emp_no + ", salary=" + salary + ", from_date=" + from_date + ", to_date=" + to_date + "]";
    }
    
    public static ArrayList<Salaries> obtenerSalarios(){
        ArrayList<Salaries> sal_ls = new ArrayList<>();
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            CallableStatement cl = cn.prepareCall("SELECT * FROM salaries");                  
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                Salaries salario = new Salaries(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4));
                sal_ls.add(salario);
            }
            
            if(sal_ls.isEmpty()) sal_ls = null;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN SALARIOS");
        }
        
        return sal_ls;
    }
    
    public static boolean registrarSalEmp(int emp_no, int salary, Date from_date, Date to_date){
        boolean confirmar_registro = false;    
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("INSERT INTO salaries VALUES(?,?,?,?)");
            ps.setInt(1,emp_no);
            ps.setInt(2, salary);
            ps.setDate(3, from_date);
            ps.setDate(4, to_date);            
            int rs = ps.executeUpdate();                                    
                                       
            if(rs > 0) confirmar_registro = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN REGISTRAR SALARIO DE EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_registro;
    }
    
    public static boolean eliminarSalario(int emp_no){
        boolean confirmar_delete = false;    
    
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("DELETE FROM salaries WHERE emp_no = ?");
            ps.setInt(1,emp_no);
            int rs = ps.executeUpdate();                                    
                        
            if(rs > 0) confirmar_delete = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN ELIMINAR SALARIO EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_delete;
    }
    
}
