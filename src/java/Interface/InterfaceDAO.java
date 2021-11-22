package Interface;

import java.util.List;

public interface InterfaceDAO <S> {
    
    boolean insert(S s);
    
    boolean update(S s);
    
    List<S> selectAll();
    
    boolean delete(Object id);
    
}
