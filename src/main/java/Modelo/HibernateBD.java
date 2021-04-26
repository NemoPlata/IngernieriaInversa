package Modelo;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBD {        

    //Método para registrar un empleado a partir de un Arraylist de tipo empleado
    public static boolean registrarEmpleado(ArrayList Employees){                        
        
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{            
            ArrayList<Employees> emp = Employees;
            
            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(HibernateException e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
    
    //Método para registrar el salario para un empleado a partir de un Arraylist de tipo salario
    public static boolean registrarSalario(ArrayList Salaries){                        
        
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{            
            ArrayList<Salaries> emp = Salaries;
            
            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(HibernateException e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
    
    //Método para registrar un titulo para un empleado a partir de un Arraylist de tipo titulo
    public static boolean registrarTitulo(ArrayList Titles){                        
        
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{            
            ArrayList<Titles> emp = Titles;
            
            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(HibernateException e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
    
    //Método para registrar un empleado en un departamento predefinido a partir de un Arraylist de tipo departamento empleado
    public static boolean registrarDeptEmp(ArrayList DepartmentEmp){                        
        
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{            
            ArrayList<DepartmentEmp> emp = DepartmentEmp;
            
            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(HibernateException e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
    
    //Método para registrar un empleado en un departamento predefinido a partir de un Arraylist de tipo departamento manager
    public static boolean registrarDeptMan(ArrayList DepartmentMan){                        
        
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();

        Session sesion = factory.openSession();
        
        boolean registro = false;
        
        try{            
            ArrayList<DepartmentMan> emp = DepartmentMan;
            
            sesion.beginTransaction();

            sesion.save(emp);

            sesion.getTransaction().commit();

            System.out.println("Registro Insertado correctamente en BD");

            sesion.close();

            factory.close();
            
            registro = true;

        }catch(HibernateException e){
            
            System.out.println("ERROR");
            factory.close();

        }
        
        return registro;
    }
    
}
