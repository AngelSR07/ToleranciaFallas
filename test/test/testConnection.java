package test;

import Connection.ConnectionDB;
import DAO.UserDAO;
import Entities.User;

public class testConnection {

    public static void main(String[] args) {

//        ConnectionDB.getInstance();
//        ConnectionDB con = new ConnectionDB();

//        con.close();
//
        UserDAO sentenciaSQL = new UserDAO();
        
        User prueba = new User();
        prueba.setNom("Prueba 40");
        prueba.setPass("hola04");
        
        if(sentenciaSQL.insert(prueba)){
            System.out.println("Se registro usuario exitosamente.");
        }
    }

}
