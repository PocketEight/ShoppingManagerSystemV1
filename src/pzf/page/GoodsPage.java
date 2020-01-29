package pzf.page;

import pzf.DAO.GoodsDao;
import pzf.entity.Goods;
import pzf.tools.ScannerChoice;
import pzf.tools.ScannerNum;

import java.util.Scanner;

public class GoodsPage {
    public static void addGoodsPage(){
        System.out.println("*************************\n");
        System.out.println("执行添加商品操作\n");

        System.out.println("添加商品名称：");
        String goodsName= ScannerChoice.ScannerInfoString();

        System.out.println("添加商品价格：");
        float goodsPrice= ScannerNum.ScannerInfoFloat();

        System.out.println("添加商品数量：");
        int goodsNum=ScannerNum.ScannerInfoInt();

        if(goodsPrice==-1) {
            System.out.println("价格有误");
            addGoodsPage();
        }
        Goods goods=new Goods(goodsName,goodsPrice,goodsNum);
        GoodsDao.add(goods);
        //待添加
        //判断是否成功添加
        System.out.println("输入任意字符继续，N 返回");
        String is_Countinue=ScannerChoice.ScannerInfoString();
        if(is_Countinue.equals("N")) MainPage.maintensePage();
        else addGoodsPage();

    }
}
