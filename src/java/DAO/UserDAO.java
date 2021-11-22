package DAO;

import java.sql.PreparedStatement;
import Connection.ConnectionDB;
import Entities.User;
import Interface.InterfaceUser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceUser{
    
    //Atributos
    private static PreparedStatement pstm = null;
    private static ConnectionDB conexion;
    private static ResultSet res;
    
    
    
    //Constructor
    public UserDAO(){
        conexion = ConnectionDB.getInstance();
    }

    
    
    
    @Override
    public boolean login(User usuario) {
        
        User u = null;
        boolean checkLogin = false; 
        
        final String SQL_LOGIN = "SELECT * from  USUARIOS \n" +
                                 "WHERE NOMBRE=? AND CONTRASEÑA=?;";
        
        try {
            pstm = conexion.getConnection().prepareStatement(SQL_LOGIN);
            
            pstm.setString(1, usuario.getNom());
            pstm.setString(2, usuario.getPass());
            
            res = pstm.executeQuery();
            
            while (res.next()) {
                u = new User();
                
                u.setId(res.getInt(1));
                u.setNom(res.getString(2));
                u.setPass(res.getString(3));
            }
            
            if(u != null){
                checkLogin = true;
            }
            
            
        } catch (Exception ex){
            System.out.println("Error al intentar loguear un usuario: " + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            close();
        }
        
        return checkLogin;
        
    }

    @Override
    public boolean insert(User s) {
        
        boolean checkInsert = false;
        
        System.out.println(s.getNom() + " " + s.getPass());
        
        final String SQL_INSERT = "INSERT INTO USUARIOS VALUES(?,?)";
        
        try {
            
            pstm = conexion.getConnection().prepareStatement(SQL_INSERT);
            
            pstm.setString(1, s.getNom());
            pstm.setString(2, s.getPass());
            
            
            if(pstm.executeUpdate()>0){
                checkInsert = true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al insertar un nuevo usuario en la base de datos: " + e.getMessage());
            e.printStackTrace();
            
        } finally{
            close();
        }
        
        return checkInsert;
        
    }

    @Override
    public boolean update(User s) {
        
        boolean checkUpdate = false;
        
        final String SQL_UPDATE = "UPDATE USUARIOS \n" +
                                  "SET NOMBRE= ? ,CONTRASEÑA=?\n" +
                                  "WHERE ID=?;";
        
        try{
        
            pstm = conexion.getConnection().prepareStatement(SQL_UPDATE);
            
            pstm.setString(1, s.getNom());
            pstm.setString(2, s.getPass());
            pstm.setInt(3, s.getId());
            
            if(pstm.executeUpdate() > 0){
                checkUpdate = true;
            }
            
        }catch(Exception ex){
            System.out.println("Error al modificar los datos de un usuario: " + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            close();
        }
        
        return checkUpdate;
        
    }

    @Override
    public List<User> selectAll() {
        
        ArrayList<User> listaUser = new ArrayList<>();
        User u;
        
        final String SQL_SELECT_ALL_CLIENT ="SELECT * FROM  USUARIOS";
        
        try {
                
            pstm = conexion.getConnection().prepareStatement(SQL_SELECT_ALL_CLIENT);
                
            res = pstm.executeQuery();
            
            while (res.next()) {
                u = new User();
                
                u.setId(res.getInt(1));
                u.setNom(res.getString(2));
                u.setPass(res.getString(3));
                
                listaUser.add(u);
            }

        } catch (Exception ex) {
            System.out.println("Error al seleccionar todos los usuarios registrados: " + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            close();
        }
        
        return listaUser;
        
    }

    @Override
    public boolean delete(Object id) {
        
        boolean checkDelete = false;
        
        final String SQL_DELETE = "DELETE FROM USUARIOS WHERE ID = ?;";
        
        try{
        
            pstm = conexion.getConnection().prepareStatement(SQL_DELETE);
            
            pstm.setInt(1, (int) id);
            
            if(pstm.executeUpdate() > 0){
                checkDelete = true;
            }
            
        }catch(Exception ex){
            System.out.println("Error al insertar un nuevo usuario en la base de datos: " + ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            close();
        }
        
        return checkDelete;
        
    }

    private void close() {
        
        try {
            
            if(pstm!=null){
                pstm.close();
            }
            
            if(res != null){
                res.close();
            }
            
            if(conexion != null){
                conexion.close();
            }
            
        } catch (Exception ex) {
            System.out.println("Error al cerrar la base de datos: " + ex.getMessage());
        }
        
    }
    
}
