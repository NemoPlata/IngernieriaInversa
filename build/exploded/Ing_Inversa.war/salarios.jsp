<%@page import="Modelo.Employees"%>
<%@page import="Modelo.Salaries"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="img/icon.png">
    <link rel="stylesheet" type="text/css" href="css/estilosIndex.css">    
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">    
</head>
<body>
    <div id="sup">
        <a href="index.jsp">
            <table class="table table-hover" id="titulo">
                <tbody>
                    <tr class="table-primary">
                        <th scope="row"><center><h1>GESTOR DE EMPLEADOS</h1></center></th>
                    </tr>
                </tbody>
            </table>
        </a>
    </div>      
    <div id="contenido">    
        
        <div id="izquierda">
            
            <center>
                
                <h3>TITULOS</h3>            
            
                <br><br>
                        
                <table class="table table-hover">                
                    <tr>
                        <th scope="row">ID</th>
                        <th scope="row">Salario</th>
                        <th scope="row">Fecha Inicial</th>
                        <th scope="row">Fecha Final</th>
                        <th scope="row">Opciones</th>
                        
                    </tr>
                    <%
                    ArrayList<Salaries> salaries_ls = Salaries.obtenerSalarios();
                    if(salaries_ls!=null){
                        int saltofila = 0;
                        for(Salaries sal : salaries_ls){
                    %>
                    <tr class="table-secondary">
                        <td scope="row">
                            <p name="id">
                                <%= sal.getEmp_no()%>
                            </p>
                        </td>
                        <td scope="row">
                            <p name="nombre">
                                $<%= sal.getSalary()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoPat">
                                <%= sal.getFrom_date()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoMat">
                                <%= sal.getTo_date()%> 
                            </p>
                        </td>  
                        <td scope="row">
                            <center>
                                <form id="eliminarUsuario" method="post" action="ServletSesion">
                                    <input type="hidden" name="accion" value="delete_sal">
                                    <input type="hidden" name="emp_no" value="<%= sal.getEmp_no()%>">                                    
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                            </center>
                        </td>
                    </tr>
                    <%
                        }                                                                 
                        saltofila++;
                        if(saltofila==1){
                    %>
                    <th scope="row">
                    <%
                            saltofila=0;
                        }
                    }                         
                    %>                    
                </table>
            </center>
                
        </div>
                
        <div id="derecha">
            <center>
                <h3>ASIGNAR TITULO</h3>
            </center>  
            
            <br><br>
            
            <center>
                <form id="registroUsuario" name="assign_salary" action="ServletSesion" method="post">
                    <input type="hidden" name="accion" value="assign_salary">
                    Id Empleado
                    <br>
                    <select class="custom-select" style="width: 160px;" name="emp_no">
                    <%
                    ArrayList<Employees> empleados_ls = Employees.obtenerIdEmpleados();
                    if(empleados_ls!=null){                    
                        for(Employees empleados : empleados_ls){
                    %>                                        
                        <option value="<%= empleados.getEmp_no()%>"><%= empleados.getEmp_no()%></option>                       
                    <%
                        }
                    }
                    %>
                    </select>  
                    
                    <br><br><br>
                    
                    Salario
                    <input type="number" class="form-control" style="width: 160px;" name="salary" placeholder="Salario" required> 

                    <br><br>
                    Fecha Inicial
                    <input type="date" class="form-control" style="width: 160px;" name="from_date" max="2021-04-01" min="2022-01-01" placeholder="2021-05-01" required>

                    <br><br>
                    Fecha Final
                    <input type="date" class="form-control" style="width: 160px;" name="to_date" max="2021-04-01" min="2022-01-01" placeholder="2021-05-01" required>
                    
                    <br>
                    
                    <button type="submit" class="btn btn-success">Registrar</button>
                </form>
            </center>            
        </div>               
    </div>
</body>
</html>