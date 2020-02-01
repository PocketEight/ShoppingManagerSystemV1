package pzf.DAO;

import pzf.mysql.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesmanDao {
    /**
     *
     * @param name
     * @param password
     * @return boolean
     */
    public static boolean login(String name,String password){

        String sql="select * from saleman where SNAME=?";
        try(Connection c= Conn.getConnection();
            PreparedStatement ps=c.prepareStatement(sql); ){
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(password.equals(rs.getString(3))){
                    return true;
                }
                else return false;
            }
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
