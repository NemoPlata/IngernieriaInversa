<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ing Inversa</title>
    <link rel="stylesheet" type="text/css" href="css/estilosRegistro.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script type="text/javascript">
        function validarDatos(){
    
            var form = document.signup;
            var isChecked = document.getElementById("aceptar_politicas").checked;

            if(form.usuario.value==0){
                alert("El campo Nombre está vacío.");
                form.usuario.value="";
                form.usuario.focus;
                return false;
                
            }else if(form.usuario.value < 3 || form.usuario.value > 30){
                alert("El campo Nombre no tiene la longitud requerida.");
                form.usuario.value="";
                form.usuario.focus;
                return false;
            }
            
            if(form.apellidoPat.value==0){
                alert("El campo Apellido paterno está vacío.");
                form.apellidoPat.value="";
                form.apellidoPat.focus;
                return false;
                
            }else if(form.apellidoPat.value < 3 || form.apellidoPat.value > 30){
                alert("El campo Apellido paterno no tiene la longitud requerida.");
                form.apellidoPat.value="";
                form.apellidoPat.focus;
                return false;                
            }
            
            if(form.apellidoMat.value==0){
                alert("El campo Apellido materno está vacío.");
                form.apellidoMat.value="";
                form.apellidoMat.focus;
                return false;
                
            }else if(form.apellidoMat.value < 3 || form.apellidoMat.value > 30){
                alert("El campo Apellido materno no tiene la longitud requerida.");
                form.apellidoMat.value="";
                form.apellidoMat.focus;
                return false;
            }
            
            if(form.contrasena.value==0){
                alert("El campo Contraseña está vacío.");
                form.contrasena.value="";
                form.contrasena.focus;
                return false;
                
            }else if(form.contrasena.value < 3 || form.contrasena.value > 30){
                alert("El campo Contraseña no tiene la longitud requerida.");
                form.contrasena.value="";
                form.contrasena.focus;
                return false;
            }
            
            if(form.confirmar_contrasena.value==0){
                alert("El campo Confirmar contraseña está vacío.");
                form.confirmar_contrasena.value="";
                form.confirmar_contrasena.focus;
                return false;
                
            }else if(form.confirmar_contrasena.value < 3 || form.confirmar_contrasena.value > 30){
                alert("El campo Confirmar contraseña no tiene la longitud requerida.");
                form.confirmar_contrasena.value="";
                form.confirmar_contrasena.focus;
                return false;                
            }
            
            if(!isChecked){
                alert("Debe aceptar las políticas.");                
                return false;
            }
        }
    </script>
</head>
<body>
    <div id="sup">            
        </div>
        <div id="menu">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <a class="navbar-brand" href="#">Bienvenido</a>                
                <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="inicio.jsp">Inicio</a>
                        </li>                        
                        <li class="nav-item">
                        <a class="nav-link" href="inicioSesion.jsp">Iniciar sesión</a>
                        </li>                       
                        <li class="nav-item">
                        <a class="nav-link" href="comandas.jsp">Comandas</a>
                        </li>                        
                        <li class="nav-item">
                            <a class="nav-link" href="almacen.jsp">Almacen</a>
                        </li>                        
                        <li class="nav-item">
                        <a class="nav-link" href="buscarOrden.jsp">Buscar Orden</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="cierreCaja.jsp">Cierre de Caja</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="usuarios.jsp">Usuarios</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="graficas.jsp">Gráficas</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="contacto.jsp">Contacto</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ServletSesion?accion=logout">Cerrar Sesión</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    <div id="contenido">
    <center>

    <form id="registroUsuario" name="signup" action="ServletSesion" method="post" onsubmit="return validarDatos();">    
        <div class="contenedor-inputs">
            <input type="hidden" name="accion" value="signup_first_usr">            
            <h1>Registrar Usuario</h1>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nombre" id="inputDefault" name="usuario" minlength="3" maxlength="30" required>
            </div>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Apellido Paterno" id="inputDefault" name="apellidoPat" minlength="3" maxlength="30" required>
            </div>
            <br>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Apellido Materno" id="inputDefault" name="apellidoMat" minlength="3" maxlength="30" required>
            </div>
            <br>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Contraseña" id="inputDefault" name="contrasena" minlength="8" maxlength="16" required>
            </div>
            <br>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Confirmar contraseña" id="inputDefault" name="confirmar_contrasena" minlength="8" maxlength="16" required>
            </div>          
            <br>
            <br>
            <a href="politicas.jsp" target="_blank">Politicas de Privacidad</a>
            <br>
            <br>
            <input type="checkbox" id="aceptar_politicas" name="politicas" value="yes" > <label for="aceptar_politicas">He leído y acepto las politicas de privacidad.</label>            
            <br>
            <br>
            <button type="submit" onclick="validarDatos();" class="btn btn-success">Registrar</button>
        </div>
    </form>
    <br>
    <h4 align="center">
        Mensaje
    </h4>
    </center>
    </div>
    <br>
    <!-- <footer></footer> -->
</body>
</html>
