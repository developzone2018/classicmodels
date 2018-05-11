
package dataconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {

    private static DataConnection dc;
    private Connection conn;

    private DataConnection() throws ClassNotFoundException, SQLException {
    
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels", "root", "root");
    
    
    }
    
    public static DataConnection createConnection() throws ClassNotFoundException, SQLException{
        
        if(dc == null)
            dc = new DataConnection();
        
        return dc;
        
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    

    
}
