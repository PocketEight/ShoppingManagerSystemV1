package pzf.DAO;

import pzf.entity.Goods;
import pzf.mysql.Conn;

import java.sql.*;

/**
 * @author pzf
 * @version 1.0
 */
public class GoodsDao {
    /**
     *
     * @param goods
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

    /**
     *
     * @param goodsName
     * @return
     */
    public static Goods get(String goodsName){

        Connection connection = Conn.getConnection();
        String sql="select * from goods where GNAME = '" +goodsName+ "'";
        Statement s=null;
        Goods goods=new Goods(goodsName);
        try {

            s=connection.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            resultSet.next();
            String gname = resultSet.getString(2);
            float gprice = resultSet.getFloat(3);
            int gnum = resultSet.getInt(4);
            goods.setId(resultSet.getInt(1));
            goods.setGoodsName(gname);
            goods.setGoodsPrice(gprice);
            goods.setGoodsNum(gnum);
            System.out.println("商品名称\t商品价格\t商品数量");
            System.out.println(gname+"\t"+gprice+"\t"+gnum+"\n");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            s.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    /**
     *
     * @param key
     * @param goods
     */
    public static void update(int key,Goods goods){
        Connection c = Conn.getConnection();



        switch (key){
            //修改名称
            case (1):
                String sql="update goods set GNAME='"+goods.getGoodsName()+"' where GID="+goods.getId();
                Statement s=null;
                try {
                    s=c.createStatement();
                    s.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        s.close();
                        c.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
