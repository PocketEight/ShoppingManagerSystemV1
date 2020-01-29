package pzf.page;

import pzf.DAO.GoodsDao;
import pzf.entity.Goods;
import pzf.tools.ScannerChoice;
import pzf.tools.ScannerJudge;
import pzf.tools.ScannerNum;

import java.util.Scanner;

/**
 * 货物管理页面
 */
public class GoodsPage {

    public static void addGoodsPage() {
        System.out.println("*************************\n");
        System.out.println("执行添加商品操作\n");

        System.out.println("添加商品名称：");
        String goodsName = ScannerChoice.ScannerInfoString();

        System.out.println("添加商品价格：");
        float goodsPrice = ScannerNum.ScannerInfoFloat();

        System.out.println("添加商品数量：");
        int goodsNum = ScannerNum.ScannerInfoInt();

        if (goodsPrice == -1) {
            System.out.println("价格有误");
            addGoodsPage();
        }
        Goods goods = new Goods(goodsName, goodsPrice, goodsNum);
        GoodsDao.add(goods);
        //待添加
        //判断是否成功添加
        System.out.println("输入任意字符继续，N 返回");
        String is_Countinue = ScannerChoice.ScannerInfoString();
        if (is_Countinue.equals("N")) MainPage.maintensePage();
        else addGoodsPage();

    }

    /**
     * 修改商品页面
     */
    public static void updateGoods() {
        System.out.println("输入更改商品名称");
        String gname = ScannerChoice.ScannerInfoString();
        Goods goods = GoodsDao.get(gname);
        System.out.println("选择您要更改的内容");
        System.out.println("1.更改商品名称");
        System.out.println("2.更改商品价格");
        System.out.println("3.更改商品数量");
        int info = ScannerJudge.scannerJudge();
        if (info >= 1 && info <= 3) {
            do {
                switch (info) {
                    case (1):
                        System.out.println("请输出更改后名称：");
                        String goodsName = ScannerChoice.ScannerInfoString();
                        goods.setGoodsName(goodsName);
                        GoodsDao.update(info, goods);
                        System.out.println("更改成功");
                        System.out.println("N");
                        break;
                    case (2):
                        break;
                    case (3):
                        break;
                }
                break;
            }
            while (true);
        } else {
            System.err.println("!输入有误!");
            System.out.println("请重新输入");
        }

    }
}
