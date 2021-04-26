package Modelo;

import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Prueba {        

    public static boolean probandoMetodo(){
        
        Date fecha = new Date(2021,04,23);               
        
        SessionFactory factory = new Configuration().configure("../hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{

            Employees emp = new Employees(1,fecha,"Nehemias","Benitez","M",fecha);

            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(Exception e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
}
