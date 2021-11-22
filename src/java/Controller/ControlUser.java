package Controller;

import DAO.UserDAO;
import Entities.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControlUser", urlPatterns = {"/ControlUser"})
public class ControlUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        //Variables Generales
        User usuario = new User();
        UserDAO sentenciaSQL = new UserDAO();
        
        String ruta = "";
        String accion = request.getParameter("accion");
        RequestDispatcher rd;
        
        
        String nomU, passU;
        int id;
        
        
        switch(accion){
            
            case "Login":
                
                nomU = request.getParameter("nameU");
                passU = request.getParameter("passU");
                
                usuario.setNom(nomU);
                usuario.setPass(passU);
                
                if(sentenciaSQL.login(usuario)){
                    ruta = "ViewUsers.jsp";
                } else {
                    System.out.println("No pudo iniciar sesión");
                    ruta = "Login.jsp";
                }
                
                break;
        
            case "Register":
                
                nomU = request.getParameter("nameU");
                passU = request.getParameter("passU");
                
                usuario.setNom(nomU);
                usuario.setPass(passU);
                
                if(sentenciaSQL.insert(usuario)){
                    ruta = "ViewUsers.jsp";
                } else {
                    System.out.println("No registro usuario");
                    ruta = "Register.jsp";
                }
                
                break;
            
                
            case "goUpdate":
                
                nomU = request.getParameter("nomU");
                passU = request.getParameter("pass");
                id = Integer.parseInt(request.getParameter("id"));
                
                usuario.setId(id);
                usuario.setNom(nomU);
                usuario.setPass(passU);
                
                request.setAttribute("userUpdate", usuario);
                
                ruta = "UpdateUser.jsp";
                
                break;
            
            case "Update":
                
                User u = new User();
                
                nomU = request.getParameter("nameU");
                passU = request.getParameter("passU");
                id = Integer.parseInt(request.getParameter("id"));
                
                u.setId(id);
                u.setNom(nomU);
                u.setPass(passU);
                
                if(sentenciaSQL.update(u)){
                    ruta = "ViewUsers.jsp";
                } else {
                    System.out.println("No se pudo modificar los datos del usuario");
                    ruta = "UpdateUser.jsp";
                }
                
                break;
            
                
            case "delete":
                
                id = Integer.parseInt(request.getParameter("id"));
                
                if(sentenciaSQL.delete(id)){
                    ruta = "ViewUsers.jsp";
                } else {
                    System.out.println("No se pudo eliminar al usuario");
                    ruta = "ViewUsers.jsp";
                }
                
                break;
            
        }
        
        rd = request.getRequestDispatcher(ruta);
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
