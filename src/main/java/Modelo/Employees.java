package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees {
    
    @Id
    @Column(name="emp_no")
    private int emp_no;
    
    @Column(name="birth_date")
    private Date birth_date;
    
    @Column(name="first_name")
    private String first_name;
    
    @Column(name="last_name")
    private String last_name;
    
    @Column(name="gender")
    private String gender;
    
    @Column(name="hire_date")
    private Date hire_date;

    public Employees(int emp_no, Date birth_date, String first_name, String last_name, String gender, Date hire_date) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.hire_date = hire_date;
    }

    public Employees(int emp_no, String first_name) {
        this.emp_no = emp_no;
        this.first_name = first_name;
    }        
    
    public Employees(int emp_no){
        this.emp_no = emp_no;
    }
    
    public Employees(){
    
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public String toString() {
        return "Employees[emp_no=" + emp_no + ", birth_date=" + birth_date + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", hire_date=" + hire_date + "]";
    }
        
    public static ArrayList<Employees> obtenerEmpleados(){
        ArrayList<Employees> emp_ls = new ArrayList<>();        
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            CallableStatement cl = cn.prepareCall("SELECT * FROM employees");                  
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                Employees emp = new Employees(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                emp_ls.add(emp);
            }
            
            for (int i = 0; i < emp_ls.size(); i++) {
                System.out.println("HOLA");
                System.out.println(emp_ls.get(i).getEmp_no());
                System.out.println(emp_ls.get(i).getBirth_date());
                System.out.println(emp_ls.get(i).getFirst_name());
                System.out.println(emp_ls.get(i).getLast_name());
                System.out.println(emp_ls.get(i).getGender());
                System.out.println(emp_ls.get(i).getHire_date());
            }
            
            if(emp_ls.isEmpty()) emp_ls = null;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN EMPLEADOS");
        }
        
        return emp_ls;
    }
    
    public static ArrayList<Employees> obtenerIdEmpleados(){
        ArrayList<Employees> emp_ls = new ArrayList<>();
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            CallableStatement cl = cn.prepareCall("SELECT * FROM employees");                  
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                Employees emp = new Employees(rs.getInt(1));
                emp_ls.add(emp);
            }
            
            if(emp_ls.isEmpty()) emp_ls = null;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN EMPLEADOS");
        }
        
        return emp_ls;
    }       
    
    public static boolean registrarEmpleado(Date birth_date, String first_name, String last_name, String gender, Date hire_date){
        boolean confirmar_registro = false;
        
        int emp_no = (int) Math.floor(Math.random()*100+1);
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("INSERT INTO employees VALUES(?,?,?,?,?,?)");
            ps.setInt(1,emp_no);
            ps.setDate(2, birth_date);
            ps.setString(3, first_name);
            ps.setString(4, last_name);
            ps.setString(5, gender);
            ps.setDate(6, hire_date);
            int rs = ps.executeUpdate();  
            
            if(rs > 0) confirmar_registro = true;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN REGISTRAR EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_registro;
    }
    
    public static boolean eliminarEmpleado(int emp_no){
        boolean confirmar_delete = false;                
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("DELETE FROM employees WHERE emp_no = ?");
            ps.setInt(1,emp_no);
            int rs = ps.executeUpdate();                                    
                    
            if(rs > 0) confirmar_delete = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN ELIMINAR EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_delete;
    }
    
}
