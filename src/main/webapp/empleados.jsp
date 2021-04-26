<%@page import="Modelo.Employees"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ing Inversa</title>
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
                                
                <h3>EMPLEADOS</h3>
                
                <br>
                
                <table class="table table-hover">
                    <tr>
                        <th scope="row">ID</th>
                        <th scope="row">Fecha Nacimiento</th>
                        <th scope="row">Nombre</th>
                        <th scope="row">Apellido</th>
                        <th scope="row">Género</th>
                        <th scope="row">Fecha Contratación</th>
                        <th scope="row">Opciones</th>
                    </tr>
                    <%
                    ArrayList<Employees> empleados_ls = Employees.obtenerEmpleados();
                    if(empleados_ls!=null){
                        int saltofila = 0;
                        for(Employees emp : empleados_ls){
                    %>
                    <tr class="table-secondary">                        
                        <div class="contenedor-inputs">
                            <td scope="row">
                                <%= emp.getEmp_no()%>
                            </td>
                            <td scope="row">
                                <%= emp.getBirth_date()%>
                            </td>
                            <td scope="row">
                                <%= emp.getFirst_name()%>
                            </td>                                
                            <td scope="row">
                                <%= emp.getLast_name()%>
                            </td>
                            <td scope="row">
                                <%= emp.getGender()%>
                            </td>
                            <td scope="row">
                                <%= emp.getHire_date()%>
                            </td>
                            <td>
                                <form id="eliminarUsuario" name="delete" action="ServletSesion" method="post">
                                    <input type="hidden" name="accion" value="delete_emp">
                                    <input type="hidden" name="emp_no" value="<%= emp.getEmp_no()%>">   
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                            </td>
                        </div>                        
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

                <form id="registroUsuario" name="signup" action="ServletSesion" method="post">    
                    <div class="contenedor-inputs">

                        <input type="hidden" name="accion" value="signup_usr">            
                        <h3>REGISTRAR USUARIO</h3>

                        <br><br>
                        Fecha Nacimiento
                        <div class="form-group">
                            <input type="date" class="form-control" style="width: 160px;" placeholder="2021-05-01" id="inputDefault" name="birth_date" max="2021-04-01" min="2022-01-01" required>
                        </div>

                        <br>
                        Nombre
                        <div class="form-group">
                            <input type="text" class="form-control" style="width: 160px;" placeholder="Nombre" id="inputDefault" name="first_name" minlength="3" maxlength="30" required>
                        </div>

                        <br>
                        Apellido
                        <div class="form-group">
                            <input type="text" class="form-control" style="width: 160px;" placeholder="Apellido" id="inputDefault" name="last_name"  minlength="3" maxlength="30" required>
                        </div>

                        <br>
                        Género
                        <div class="form-group">
                            <select class="custom-select" style="width: 160px;" name="gender">
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                            </select>
                        </div>

                        <br>
                        Fecha Contratación
                        <div class="form-group">
                            <input type="date" class="form-control" style="width: 160px;" placeholder="2021-05-01" id="inputDefault" name="hire_date" max="2021-04-01" min="2022-01-01" required>
                        </div>          

                        <br>                        

                        <button type="submit" class="btn btn-success">Registrar</button>
                    </div>
                </form>                               
            </center>
        </div>
    </div>
    <br>    
</body>
</html>
