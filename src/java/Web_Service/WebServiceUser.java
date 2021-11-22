package Web_Service;

import DAO.UserDAO;
import Entities.User;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceUser")
public class WebServiceUser {

    /**
     * This is a sample web service operation
     * @param nomU
     * @param passU
     * @return 
     */
    @WebMethod(operationName = "login")
    public Boolean login(@WebParam(name = "nameU") String nomU, @WebParam(name = "passU") String passU) {
        
        User usuario = new User();
        
        usuario.setNom(nomU);
        usuario.setPass(passU);
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.login(usuario);
    }
    
    
    @WebMethod(operationName = "insert")
    public Boolean insert(@WebParam(name = "nameU") String nomU, @WebParam(name = "passU") String passU) {
        
        User usuario = new User();
        
        usuario.setNom(nomU);
        usuario.setPass(passU);
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.insert(usuario);
    }
    
    
    
    @WebMethod(operationName = "update")
    public Boolean update(@WebParam(name = "idU") int id, @WebParam(name = "nameU") String nomU, @WebParam(name = "passU") String passU) {
        
        User usuario = new User();
        
        usuario.setId(id);
        usuario.setNom(nomU);
        usuario.setPass(passU);
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.update(usuario);
    }
    
    
    @WebMethod(operationName = "selectAll")
    public List<User> selectAll() {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.selectAll();
    }
    
    
    
    @WebMethod(operationName = "delete")
    public Boolean delete(@WebParam(name = "idU") int id) {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.delete(id);
    }
}
