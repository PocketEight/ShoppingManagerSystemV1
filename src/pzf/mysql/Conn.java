package pzf.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static void main(String[] args) {
        getConnection();

    }
     public static Connection getConnection(){
        Connection connection=null;
         try {
             String url="jdbc:mysql://127.0.0.1:3306/supermarket?characterEncoding=UTF-8";
             Class.forName("com.mysql.jdbc.Driver");
             connection= DriverManager.getConnection(url,"root","123");

         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return connection;
     }
}
