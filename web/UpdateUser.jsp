<%-- 
    Document   : UpdateUser
    Created on : 21/11/2021, 04:16:41 PM
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
            
            <h1>Actualizar datos datos</h1>
            
        </header>
        
        <form action="ControlUser" method="post">
            
            <div class="container">
                <input type="hidden" name="id" value="${userUpdate.getId()}">
                <input type="text" placeholder="Nombre de usuario" name="nameU" value="${userUpdate.getNom()}" required> <br><br>
                <input type="password" placeholder="Password" name="passU" value="${userUpdate.getPass()}" required><br><br>
                    
            </div>
                
                
            <div class="botones">
                    <button type="submit" name="accion" value="Update">Registrar</button>
           </div>
            
        </form>
        
    </body>
</html>
