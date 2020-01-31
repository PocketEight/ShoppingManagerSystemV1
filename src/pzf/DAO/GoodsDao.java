package pzf.DAO;

import pzf.entity.Goods;
import pzf.mysql.Conn;
import pzf.page.MainPage;
import pzf.tools.ScannerChoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pzf
 * @version 1.0
 */
public class GoodsDao {
    /**
     * @param goods
     */
    public static void add(Goods goods) {
        Connection connection = Conn.getConnection();

        String sql = "insert into goods values(null,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, goods.getGoodsName());
            ps.setFloat(2, goods.getGoodsPrice());
            ps.setInt(3, goods.getGoodsNum());
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
     * @param goodsName
     * @return
     */
    public static Goods get(String goodsName) {

        Connection connection = Conn.getConnection();
        String sql = "select * from goods where GNAME = '" + goodsName + "'";
        Statement s = null;
        Goods goods = new Goods(goodsName);
        try {

            s = connection.createStatement();
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
            System.out.println(gname + "\t" + gprice + "\t" + gnum + "\n");


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
     * @param key
     * @param goods
     */
    public static void update(int key, Goods goods) {
        Connection c = Conn.getConnection();


        switch (key) {
            //修改名称
            case (1):
                String sql = "update goods set GNAME='" + goods.getGoodsName() + "' where GID=" + goods.getId();
                Statement s = null;
                try {
                    s = c.createStatement();
                    s.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        s.close();
                        c.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                break;
            //修改价格
            case (2):
                String sql2 = "update goods set GPRICE=? where GID=?";
                try (PreparedStatement ps = c.prepareStatement(sql2);) {
                    ps.setInt(2, goods.getId());
                    ps.setFloat(1, goods.getGoodsPrice());
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            //修改数量
            case (3):
                String sql3 = "update goods set GNUM=? where GID=?";
                try (PreparedStatement ps = c.prepareStatement(sql3);) {
                    ps.setInt(2, goods.getId());
                    ps.setInt(1, goods.getGoodsNum());
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * @param id
     */
    public static void delete(int id) {
        String sql = "delete from goods where GID=?";

        try (Connection c = Conn.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     *
     * @return List<Goods>
     */
    public static List<Goods> selectAll() {
        String sql = "select * from goods";
        List<Goods> list = new ArrayList<Goods>();
        try (Connection c = Conn.getConnection();
             Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsName(rs.getString(2));
                goods.setGoodsPrice(rs.getFloat(3));
                goods.setGoodsNum(rs.getInt(4));
                list.add(goods);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 排序查询
     *
     * @param key
     * @return ArrayList<Goods>
     */
    public static ArrayList<Goods> selectSort(int key) {
        ArrayList<Goods> list = new ArrayList<Goods>();
        ResultSet rs2=null;
        String sql = "";
        try (Connection c = Conn.getConnection();
             Statement s = c.createStatement();
             ) {
            switch (key) {
                case (0):
                    MainPage.maintensePage();
                    break;
                case (1)://key=1 数量排序
                    sql = "select * from goods order by GNUM asc";
                    break;
                case (2)://key=2 价格排序
                    sql = "select * from goods order by GPRICE asc";
                    break;
                case(3)://key=3 关键字模糊查询
                    String keyW=ScannerChoice.ScannerInfoString();
                    String keyW2="%"+keyW+"%";
                    String sql2="select * from goods where GNAME like ?";
                    PreparedStatement ps=c.prepareStatement(sql2);
                    ps.setString(1,keyW2);
                    rs2=ps.executeQuery();
                    break;
            }if(key==1|key==2) {
                ResultSet rs = s.executeQuery(sql);
                while (rs.next()) {
                    Goods goods = new Goods();
                    goods.setGoodsName(rs.getString(2));
                    goods.setGoodsPrice(rs.getFloat(3));
                    goods.setGoodsNum(rs.getInt(4));
                    list.add(goods);
                }
                return list;
            }
            else if(key==3){

                while (rs2.next()) {
                    Goods goods = new Goods();
                    goods.setGoodsName(rs2.getString(2));
                    goods.setGoodsPrice(rs2.getFloat(3));
                    goods.setGoodsNum(rs2.getInt(4));
                    list.add(goods);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
