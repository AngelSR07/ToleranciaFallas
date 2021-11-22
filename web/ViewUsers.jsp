<%-- 
    Document   : ViewUsers
    Created on : 21/11/2021, 01:12:13 PM
    Author     : ANGEL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:useBean class="DAO.UserDAO" id="userDAO"></jsp:useBean>

        <table>
            
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>CONTRASEÑA</th>
                <th>CONFIGURACIÓN</th>
            </tr>

            <c:forEach var="listaUser" items="${userDAO.selectAll()}">

                <tr>
                    <td>${listaUser.getId()}</td>
                    <td>${listaUser.getNom()}</td>
                    <td>${listaUser.getPass()}</td>
                    <td>
                        <a href="ControlUser?accion=goUpdate&id=${listaUser.getId()}&nomU=${listaUser.getNom()}&pass=${listaUser.getPass()}"><button>Editar Usuario</button></a>
                    
                        <br>
                        
                        <a href="ControlUser?accion=delete&id=${listaUser.getId()}"><button>Eliminar Usuario</button></a>
                        
                        <br><br>
                    </td>
                </tr>

            </c:forEach>

        </table>
                        
    </body>
</html>
