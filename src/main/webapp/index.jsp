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
        <center><img src="img/miembro.png" style="height: 200px; width: 200px;">            
        <br><br><br>
        <a href="empleados.jsp"><button class="btn btn-success" style="width: 130px;">Empleados</button></a>  
        <br><br>
        <a href="departamentos.jsp"><button class="btn btn-success" style="width: 130px;">Departamentos</button></a>
        <br><br>
        <a href="salarios.jsp"><button class="btn btn-success" style="width: 130px;">Salarios</button></a>    
        <br><br>
        <a href="titulos.jsp"><button class="btn btn-success" style="width: 130px;">Titulos</button></a>    
        </center>    
        <div id="footer"></div>
    </div>
</body>
</html>