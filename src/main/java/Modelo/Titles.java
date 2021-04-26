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
public class Titles {
    
    @Id
    @Column(name="emp_no")
    private int emp_no;
    
    @Column(name="title")
    private String title;
    
    @Column(name="from_date")
    private Date from_date;
    
    @Column(name="to_date")
    private Date to_date;

    public Titles(int emp_no, String title, Date from_date, Date to_date) {
        this.emp_no = emp_no;
        this.title = title;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public Titles() {
    
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Titles[" + "emp_no=" + emp_no + ", title=" + title + ", from_date=" + from_date + ", to_date=" + to_date + "]";
    }
    
    public static boolean registrarTitulos(){
        boolean registro = false;
        
        return registro;
    }
       
    public static ArrayList<Titles> obtenerTitulos(){
        ArrayList<Titles> titulos_ls = new ArrayList<>();
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            CallableStatement cl = cn.prepareCall("SELECT * FROM titles");                  
            ResultSet rs = cl.executeQuery();
            
            while(rs.next()){
                Titles titles = new Titles(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
                titulos_ls.add(titles);
            }
            
            if(titulos_ls.isEmpty()) titulos_ls = null;
                                                        
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN TITULOS");
        }
        
        return titulos_ls;
    }
    
    public static boolean registrarTitulo(int emp_no, String title, Date from_date, Date to_date){
        boolean confirmar_registro = false;    
        
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("INSERT INTO titles VALUES(?,?,?,?)");
            ps.setInt(1,emp_no);
            ps.setString(2, title);
            ps.setDate(3, from_date);
            ps.setDate(4, to_date);            
            int rs = ps.executeUpdate();                                    
                                    
            if(rs > 0) confirmar_registro = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN REGISTRAR TITULO DE EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_registro;
    }
    
    public static boolean eliminarTitulo(int emp_no){
        boolean confirmar_delete = false;    
    
        try{
        
            Connection cn = ConexionBD.getConexion();
            PreparedStatement ps = cn.prepareCall("DELETE FROM titles WHERE emp_no = ?");
            ps.setInt(1,emp_no);
            int rs = ps.executeUpdate();                                    
                            
            if(rs > 0) confirmar_delete = true;
            
            ConexionBD.closeConexion();
            
        }catch(SQLException e){
            System.out.println("ERROR EN ELIMINAR TITULO EMPLEADO");
            System.out.println(e);
        }
        
        return confirmar_delete;
    }
}
