package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    
    //Atributos
    private static ConnectionDB instance = null;
    private static Connection conn = null;
    private static final String URL = "jdbc:sqlserver://servertf1.database.windows.net:1433;database=db_tf;user=admintf@servertf1;password=1030507090abcd-;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "admintf";
    private static final String PASS = "1030507090abcd-";
    
    
     //Contructor
    private ConnectionDB(){
        try{
        
            Class.forName(this.DRIVER).newInstance();
            this.conn = DriverManager.getConnection(this.URL,USER, PASS);
            System.out.println("Conectado correctamente a la base de datos.");
            System.out.println(this.conn.toString());
            
        } catch (Exception ex){
            
            System.out.println("Error al intentar conectarse con la base de datos.");
            
        }
    }
    
    
    //Metodo que nos permite gestionar las conexiones, generando una cola
    public synchronized static ConnectionDB getInstance(){
    
        if(instance==null){
            instance = new ConnectionDB();
        }
        
        return instance;
    }
    
    
    //Metodo que permite retornar el estado de la conexión (Abierto | Cerrado)
    public Connection getConnection(){
        return this.conn;
    }
    
    
    //Metodo que nos permite cerrar una conexión
    public void close(){
        this.instance = null;
        System.out.println("Conección cerrada exitosamente.");
    }
    
}
