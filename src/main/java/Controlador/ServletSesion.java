package Controlador;

import Modelo.DepartmentEmp;
import Modelo.DepartmentMan;
import Modelo.Employees;
import Modelo.Salaries;
import Modelo.Titles;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletSesion")
//@WebServlet(name = "ServletSesion", urlPatterns = {"/ServletSesion"})
public class ServletSesion extends HttpServlet {
    
    private String accion = "";        

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        response.setContentType("text/html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        try{
            
            //Obtenemos el parametro de la acción a realizar
            accion = request.getParameter("accion");
            
        }catch(Exception e) {
            //Si se produce una excepción por cambiar los parámetros de la acción
            request.setAttribute("msg", "Ha ocurrido un error.\n"+e.getMessage()+"\n"+e.getStackTrace());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            System.out.println("ServletSesion: Solicitud desconocida");
            System.out.println(e.getMessage());
        }
        
        if (accion.equals("logout")) {           

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        try{
            
            //Obtenemos el parametro de la acción a realizar
            accion = request.getParameter("accion");                 
            
        }catch(Exception e){
            //Si se produce una excepción por cambiar los parámetros de la acción
            request.setAttribute("msg", "Ha ocurrido un error.\n"+e.getMessage()+"\n"+e.getStackTrace());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            System.out.println("ServletControlador: Solicitud desconocida");
            System.out.println(e.getMessage());             
        }

        
        //Si se solicita registrar un nuevo usuario
        if(accion.equals("signup_usr")){
            
            String birth_date_str = request.getParameter("birth_date");
            String hire_date_str = request.getParameter("hire_date");
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            
            try{
                
                Date birth_date = format.parse(birth_date_str);      
                Date hire_date = format.parse(hire_date_str);
                
                java.sql.Date birth_sql = new java.sql.Date(birth_date.getTime());
                java.sql.Date hire_sql = new java.sql.Date(hire_date.getTime());
                
                String first_name = request.getParameter("first_name");
            
                String last_name = request.getParameter("last_name");

                String gender = request.getParameter("gender");

                boolean registrado = Employees.registrarEmpleado(birth_sql, first_name, last_name, gender, hire_sql);
                
                if(registrado) if(registrado) response.sendRedirect("empleados.jsp");
                
            }catch (ParseException ex){
                System.out.println("OMG OCURRIÓ UN ERROR");
            }
                       
        
        //Si se solicita registrar un empleado a un departamento   
        }else if(accion.equals("assign_dept")){                               
            
            String from_date_str = request.getParameter("from_date");
            String to_date_str = request.getParameter("to_date");
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            try{
            
                Date from_date = format.parse(from_date_str);
                Date to_date = format.parse(to_date_str);
                
                java.sql.Date from_sql = new java.sql.Date(from_date.getTime());
                java.sql.Date to_sql = new java.sql.Date(to_date.getTime());
                
                int emp_no = Integer.parseInt(request.getParameter("emp_no"));            
                String dept_no = request.getParameter("dept_no");                                
                
                boolean registrado;
                        
                if(dept_no.equals("A") || dept_no.equals("D")) registrado = DepartmentMan.registrarManDep(emp_no, dept_no, from_sql, to_sql);                    
                else registrado = DepartmentEmp.registrarEmpDep(emp_no, dept_no, from_sql, to_sql);
                                       
                if(registrado) response.sendRedirect("departamentos.jsp");
                    
            }catch (ParseException ex){
                System.out.println("OMG OCURRIÓ UN ERROR");
            }                        
            
        //Si se solicita registrar el salario de un empleado                                                                                                                
        }else if(accion.equals("assign_salary")){                                                
            
            String from_date_str = request.getParameter("from_date");
            String to_date_str = request.getParameter("to_date");
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            try{
            
                Date from_date = format.parse(from_date_str);
                Date to_date = format.parse(to_date_str);
                
                java.sql.Date from_sql = new java.sql.Date(from_date.getTime());
                java.sql.Date to_sql = new java.sql.Date(to_date.getTime());
                
                int emp_no = Integer.parseInt(request.getParameter("emp_no"));            
                int salary = Integer.parseInt(request.getParameter("salary"));                            
                
                boolean registrado;
                        
                registrado = Salaries.registrarSalEmp(emp_no, salary, from_sql, to_sql);
                                       
                if(registrado) response.sendRedirect("departamentos.jsp");
                    
            }catch (ParseException ex){
                System.out.println("OMG OCURRIÓ UN ERROR");
            } 
            
        //Si se solicita modificar un usuario este es el primer paso    
        }else if(accion.equals("assign_title")){            
            
            String from_date_str = request.getParameter("from_date");
            String to_date_str = request.getParameter("to_date");
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            try{
            
                Date from_date = format.parse(from_date_str);
                Date to_date = format.parse(to_date_str);
                
                java.sql.Date from_sql = new java.sql.Date(from_date.getTime());
                java.sql.Date to_sql = new java.sql.Date(to_date.getTime());
                
                int emp_no = Integer.parseInt(request.getParameter("emp_no"));            
                String title = request.getParameter("title");                                                            
                        
                boolean registrado = Titles.registrarTitulo(emp_no, title, from_sql, to_sql);
                                       
                if(registrado) response.sendRedirect("titulos.jsp");
                    
            }catch (ParseException ex){
                System.out.println("OMG OCURRIÓ UN ERROR");
            } 
            
        //Si se solicita eliminar un empleado
        }else if(accion.equals("delete_emp")){            
                        
            int emp_no = Integer.parseInt(request.getParameter("emp_no"));
            
            boolean registrado = Employees.eliminarEmpleado(emp_no);
            
            if(registrado) response.sendRedirect("empleados.jsp");
            
        //Si se solicita eliminar un empleado de un departamento                
        }else if(accion.equals("delete_dep")){ 
            
            int emp_no = Integer.parseInt(request.getParameter("emp_no"));
            
            String dept_no = request.getParameter("dept_no");
            
            boolean registrado;
            
            if(dept_no.equals("Direccion")) dept_no = "D";
            if(dept_no.equals("Administracion")) dept_no = "A";
            if(dept_no.equals("Financiero")) dept_no = "F";
            if(dept_no.equals("Logistica")) dept_no = "L";
            if(dept_no.equals("Marketing")) dept_no = "M";
            if(dept_no.equals("Recursos Humanos")) dept_no = "RH";                        
            
            if(dept_no.equals("A") || dept_no.equals("D")) registrado = DepartmentMan.eliminarDepartamento(emp_no);
            else registrado = DepartmentEmp.eliminarDepartamento(emp_no);
            
            if(registrado) response.sendRedirect("departamento.jsp");
        
        //Si se solicita eliminar el salario de un empleado       
        }else if(accion.equals("delete_sal")){ 
                        
            int emp_no = Integer.parseInt(request.getParameter("emp_no"));
            
            boolean registrado = Salaries.eliminarSalario(emp_no);
            
            if(registrado) response.sendRedirect("salarios.jsp");
            
        //Si se solicita eliminar un titulo de un empleado      
        }else if(accion.equals("delete_title")){ 
                        
            int emp_no = Integer.parseInt(request.getParameter("emp_no"));
            
            boolean registrado = Titles.eliminarTitulo(emp_no);
            
            if(registrado) response.sendRedirect("titulos.jsp");            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}