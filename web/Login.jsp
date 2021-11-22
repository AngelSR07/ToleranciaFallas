<%-- 
    Document   : Login
    Created on : 21/11/2021, 04:14:25 PM
    Author     : ANGEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <header class="cabecera">
            
            <h1>Inciar Sesión</h1>
            
        </header>
        
        <form action="ControlUser" method="post">
            
            <div class="container">
                    <input type="text" placeholder="Nombre de usuario" name="nameU" required> <br><br>
                    <input type="password" placeholder="Password" name="passU" required><br><br>
                    
            </div>
                
                
            <div class="botones">
                    <button type="submit" name="accion" value="Login">Iniciar Sesión</button>
           </div>
            
        </form>
        
    </body>
</html>
