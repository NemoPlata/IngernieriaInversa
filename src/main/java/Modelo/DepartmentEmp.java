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
@Table(name="dept_emp")
public class DepartmentEmp {
    
    @Id
    @Column(name="emp_no")
    private int emp_no;
        
    @Column(name="dept_no")
    private String dept_no;
    
    @Column(name="from_date")
    private Date from_date;
    
    @Column(name="to_date")
    private Date to_date;

    public DepartmentEmp(int emp_no, String dept_no, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.dept_no = dept_no;
        this.from_date = from_date;
        this.to_date = to_date;
    }
    
    public DepartmentEmp(){
    
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
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
        return "Departments[" + "emp_no=" + emp_no + ", dept_no=" + dept_no + ", from_date=" + from_date + ", to_date=" + to_date + "]";
    }
            
    public static ArrayList<DepartmentEmp> obtenerDeptEmp(){
        ArrayList<DepartmentEmp> dept_emp_ls = new ArrayList<>();
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            CallableStatement cl = cn.prepareCall("SELECT emp_no, dept_name, from_date, to_date FROM departments deptos INNER JOIN dept_emp dep ON deptos.dept_no = dep.dept_no");                  
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                DepartmentEmp dept_emp = new DepartmentEmp(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
                dept_emp_ls.add(dept_emp);
            }
            
            if(dept_emp_ls.isEmpty()) dept_emp_ls = null;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN DEPARTAMENTOS EMPLEADOS");
        }
        
        return dept_emp_ls;
    }
    
    public static boolean registrarEmpDep(int emp_no, String dept_no, Date from_date, Date to_date){
        boolean confirmar_registro = false;
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("INSERT INTO dept_emp VALUES(?,?,?,?)");
            ps.setInt(1,emp_no);
            ps.setString(2, dept_no);
            ps.setDate(3, from_date);
            ps.setDate(4, to_date);            
            int rs = ps.executeUpdate();                                    
                      
            if(rs > 0) confirmar_registro = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN REGISTRAR EMPLEADO EN DEPARTAMENTO");
            System.out.println(e);
        }
        
        return confirmar_registro;
    }
    
    public static boolean eliminarDepartamento(int emp_no){
        boolean confirmar_delete = false;    
    
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("DELETE FROM dept_emp WHERE emp_no = ?");
            ps.setInt(1,emp_no);
            int rs = ps.executeUpdate();                                    
                     
            if(rs > 0) confirmar_delete = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN ELIMINAR EMPLEADO DEPARTAMENTO");
            System.out.println(e);
        }
        
        return confirmar_delete;
    }
}
