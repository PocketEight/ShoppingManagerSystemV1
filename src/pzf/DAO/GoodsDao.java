package pzf.DAO;

import pzf.entity.Goods;
import pzf.mysql.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author pzf
 * @version 1.0
 */
public class GoodsDao {
    /**
     *
     * @param goods
     *
     */
    public static void add(Goods goods){
        Connection connection=Conn.getConnection();

        String sql="insert into goods values(null,?,?,?)";
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,goods.getGoodsName());
            ps.setFloat(2,goods.getGoodsPrice());
            ps.setInt(3,goods.getGoodsNum());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
