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
     */
    @WebMethod(operationName = "login")
    public Boolean login(@WebParam(name = "name") User usuario) {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.login(usuario);
    }
    
    
    @WebMethod(operationName = "insert")
    public Boolean insert(@WebParam(name = "name") User usuario) {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.insert(usuario);
    }
    
    
    
    @WebMethod(operationName = "update")
    public Boolean update(@WebParam(name = "name") User usuario) {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.update(usuario);
    }
    
    
    @WebMethod(operationName = "selectAll")
    public List<User> selectAll() {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.selectAll();
    }
    
    
    
    @WebMethod(operationName = "delete")
    public Boolean delete(@WebParam(name = "name") int id) {
        
        UserDAO sqlSentencias = new UserDAO();
        
        return sqlSentencias.delete(id);
    }
}
