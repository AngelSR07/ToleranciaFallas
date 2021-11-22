<%-- 
    Document   : index
    Created on : 21/11/2021, 12:39:00 PM
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
            
            <h1>Registrar datos</h1>
            
        </header>
        
        <form action="ControlUser" method="post">
            
            <div class="container">
                    <input type="text" placeholder="Nombre de usuario" name="nameU" required> <br><br>
                    <input type="password" placeholder="Password" name="passU" required><br><br>
                    
            </div>
                
                
            <div class="botones">
                    <button type="submit" name="accion" value="Register">Registrar</button>
           </div>
            
        </form>
    </body>
</html>
