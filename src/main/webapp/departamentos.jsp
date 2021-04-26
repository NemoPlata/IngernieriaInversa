<%@page import="Modelo.DepartmentMan"%>
<%@page import="Modelo.DepartmentEmp"%>
<%@page import="Modelo.Employees"%>
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
                
                <h3>DEPARTAMENTOS</h3>            
            
                <br><br>
                        
                <table class="table table-hover">                
                    <tr>
                        <th scope="row">ID</th>
                        <th scope="row">Departamento</th>
                        <th scope="row">Fecha Inicial</th>
                        <th scope="row">Fecha Final</th>   
                        <th scope="row">Opciones</th>   
                    </tr>
                    <%                    
                    ArrayList<DepartmentEmp> dept_emp_ls = DepartmentEmp.obtenerDeptEmp();                    
                    
                    if(dept_emp_ls != null){
                        int saltofila = 0;
                        for(DepartmentEmp dept_emp : dept_emp_ls){
                    %>
                    <tr class="table-secondary">
                        <td scope="row">
                            <p name="id">
                                <%= dept_emp.getEmp_no()%>
                            </p>
                        </td>                    
                        <td scope="row">
                            <p name="nombre">
                                <%= dept_emp.getDept_no()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoPat">
                                <%= dept_emp.getFrom_date()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoMat">
                                <%= dept_emp.getTo_date()%> 
                            </p>
                        </td>  
                        <td scope="row">
                            <center>
                                <form id="eliminarUsuario" method="post" action="ServletSesion">
                                    <input type="hidden" name="accion" value="delete_usr">
                                    <input type="hidden" name="privilegio" value="<%= dept_emp.getEmp_no()%>">                                    
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
                    <!-- COMIENZA EL MANAGER -->
                    <%                                        
                    ArrayList<DepartmentMan> dept_man_ls = DepartmentMan.obtenerDeptMan();
                    
                    if(dept_man_ls != null){
                        int saltofila = 0;
                        for(DepartmentMan dept_man : dept_man_ls){
                    %>
                    <tr class="table-secondary">
                        <td scope="row">
                            <p name="id">
                                <%= dept_man.getEmp_no()%>
                            </p>
                        </td>                    
                        <td scope="row">
                            <p name="nombre">
                                <%= dept_man.getDept_no()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoPat">
                                <%= dept_man.getFrom_date()%> 
                            </p>
                        </td>
                        <td scope="row">
                            <p name="apellidoMat">
                                <%= dept_man.getTo_date()%> 
                            </p>
                        </td>  
                        <td scope="row">
                            <center>
                                <form id="eliminarUsuario" method="post" action="ServletSesion">
                                    <input type="hidden" name="accion" value="delete_dep">
                                    <input type="hidden" name="emp_no" value="<%= dept_man.getEmp_no()%>">   
                                    <input type="hidden" name="dept_no" value="<%= dept_man.getDept_no()%>">   
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
                <h3>ASIGNAR DEPARTAMENTO</h3>
            </center>  
            
            <br><br>
            
            <center>
                <form id="registroUsuario" name="assign_dept" action="ServletSesion" method="post">
                    <input type="hidden" name="accion" value="assign_dept">
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
                    <select class="custom-select" style="width: 160px;" name="dept_no">
                        <option value="A">Administración</option>
                        <option value="D">Dirección</option>
                        <option value="F">Financiero</option>
                        <option value="L">Logística</option>
                        <option value="M">Marketing</option>
                        <option value="RH">Recursos Humanos</option>
                    </select>     

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