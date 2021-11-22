package Interface;

import Entities.User;

public interface InterfaceUser extends InterfaceDAO<User>{
    
    boolean login(User usuario);
    
}
