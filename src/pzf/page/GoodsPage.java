package pzf.page;

import pzf.DAO.GoodsDao;
import pzf.entity.Goods;
import pzf.tools.ScannerChoice;
import pzf.tools.ScannerJudge;
import pzf.tools.ScannerNum;

import java.util.ArrayList;
import java.util.List;

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
                        System.out.println("更改成功，返回上一页");
                        MainPage.maintensePage();
                        break;
                    case (2):
                        System.out.println("请输出更改后价格：");
                        Float goodsPrice = ScannerNum.ScannerInfoFloat();
                        goods.setGoodsPrice(goodsPrice);
                        GoodsDao.update(info, goods);
                        System.out.println("更改成功，返回上一页");
                        MainPage.maintensePage();
                        break;
                    case (3):
                        System.out.println("请输出更改后数量：");
                        int goodsNum = ScannerNum.ScannerInfoInt();
                        goods.setGoodsNum(goodsNum);
                        GoodsDao.update(info, goods);
                        System.out.println("更改成功，返回上一页");
                        MainPage.maintensePage();
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

    /**
     * 删除页面
     */
    public static void deleteGoods() {
        System.out.println("输入删除商品名称");
        String goodsName = ScannerChoice.ScannerInfoString();
        Goods goods = GoodsDao.get(goodsName);
        System.out.println("是否确定删除 y/n");
        String check = ScannerChoice.ScannerInfoString();
        if (check.equals("y")) {
            GoodsDao.delete(goods.getId());
            System.out.println("删除成功，返回上一页\n");
        }
        MainPage.maintensePage();
    }

    /**
     * 查询所有
     */
    public static void selectAll() {

        List<Goods> list = GoodsDao.selectAll();
        String check = "";
        System.out.println("商品名称\t\t商品价格\t\t商品数量\t\t备注");
        for (Goods goods : list
        ) {
            if (goods.getGoodsNum() <= 10) check = "*该商品不足10";
            System.out.println(goods.getGoodsName() + "\t\t" + goods.getGoodsPrice() + "\t\t" + goods.getGoodsNum() + "\t\t" + check + "\n");
            check = "";
        }
        System.out.println("0返回");
        int back = ScannerJudge.scannerJudge();
        if (back == 0) MainPage.maintensePage();
    }

    public static void selectSort(){
        System.out.println("执行查询商品操作\n\n");
        System.out.println("1.按商品数量升序查询\n2.按商品价格升序查询\n3.输入关键字查询商品\n输入数字或按0返回上一级菜单");
        int key=ScannerJudge.scannerJudge();
        if(key>=0&&key<=3){
            ArrayList<Goods> list=GoodsDao.selectSort(key);
            String check = "";
            System.out.println("商品名称\t\t商品价格\t\t商品数量\t\t备注");
            for (Goods goods : list
            ) {
                if (goods.getGoodsNum() <= 10) check = "*该商品不足10";
                System.out.println(goods.getGoodsName() + "\t\t" + goods.getGoodsPrice() + "\t\t" + goods.getGoodsNum() + "\t\t" + check + "\n");
                check = "";
            }
            System.out.println("按0返回");
            int backKey=ScannerJudge.scannerJudge();
            if(backKey==0) GoodsPage.selectSort();
        }else{
            System.out.println("请重新输入");
            selectSort();
        }
    }
}

