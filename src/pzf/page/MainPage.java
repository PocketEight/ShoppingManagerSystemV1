package pzf.page;

import pzf.tools.ScannerJudge;


public class MainPage {
    /*
     * 入口函数
     */
    public static void main(String[] args) {
        mainPage();
    }

    /*
     *主界面
     */
    public static void mainPage() {
        System.out.println("*************************\n");
        System.out.println("\t1.商品维护\n");
        System.out.println("\t2.前台收银\n");
        System.out.println("\t3.商品管理\n");
        System.out.println("*************************\n");
        System.out.println("输入数字选择，按0退出");
        do {
            int info = ScannerJudge.scannerJudge();
            if (info >= 0 && info <= 3) {
                switch (info) {
                    case (0): {
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(1);
                        break;
                    }
                    case (1): {
                        maintensePage();
                        break;
                    }
                    case (2): {
                        mainLoginPage();
                        break;
                    }
                    case (3): {
                        goodsManagePage();
                        break;
                    }
                }
            } else {
                System.err.println("!输入有误!");
                System.out.println("重新选择或者按0退出.");
            }
        }
        while (true);
    }

    public static void maintensePage() {
        /**
         * 商品维护界面
         */
        System.out.println("商品维护菜单");
        System.out.println("管理系统>>商品维护");
        System.out.println("*************************\n");
        System.out.println("\t1.添加商品\n");
        System.out.println("\t2.更改商品\n");
        System.out.println("\t3.删除商品\n");
        System.out.println("\t4.显示所有商品\n");
        System.out.println("\t5.查找商品\n");
        System.out.println("*************************\n");
        System.out.println("输入数字或者按0返回上级菜单");
        do {
            int info = ScannerJudge.scannerJudge();
            if (info >= 0 && info <= 5) {
                switch (info) {
                    case (0): {
                        mainPage();
                        break;
                    }
                    case (1): {
                        GoodsPage.addGoodsPage();
                        break;
                    }
                    case (2): {
                        GoodsPage.updateGoods();
                        break;
                    }
                    case (3):
                        GoodsPage.deleteGoods();
                        break;
                    case (4):
                        GoodsPage.selectAll();
                        break;
                    case (5):
                        GoodsPage.selectSort();
                        break;
                }
            } else {
                System.err.println("!输入有误!");
                System.out.println("重新选择或者按0退出.");
            }
        }
        while (true);
    }

    public static void mainLoginPage() {
        /**
         * 前台登录收银
         */
        System.out.println("\t欢迎使用\n");
        System.out.println("\t1.登录系统\n");
        System.out.println("\t2.退出\n");
        System.out.println("*************************\n");
        do {
            int info = ScannerJudge.scannerJudge();
            if (info >= 0 && info <= 2) {
                switch (info) {
                    case (0):
                    case (2): {
                        mainPage();
                        break;
                    }
                    case (1):SalesPage.loginPage();
                }
            } else {
                System.err.println("!输入有误!");
                System.out.println("重新选择或者按0退出.");
            }
        }
        while (true);
    }

    public static void goodsManagePage() {
        /**
         * 商品管理页面
         */
        System.out.println("管理系统>>商品管理");
        System.out.println("*************************\n");
        System.out.println("\t1.列出当日卖出商品列表\n");
        System.out.println("\t2.售货员管理\n");
        System.out.println("*************************\n");
        System.out.println("输入数字或者按0返回上级菜单");
        do {
            int info = ScannerJudge.scannerJudge();
            if (info >= 0 && info <= 2) {
                switch (info) {
                    case (0): {
                        mainPage();
                        break;
                    }
                    case (1): {

                    }
                    case (2): {
                        salemansManagePage();
                        break;
                    }
                }
            } else {
                System.err.println("!输入有误!");
                System.out.println("重新选择或者按0退出.");
            }
        }
        while (true);
    }

    public static void salemansManagePage() {
        /**
         * 售货员管理页面
         */
        System.out.println("管理系统>>商品管理>>售货员管理");
        System.out.println("*************************\n");
        System.out.println("\t1.添加售货员\n");
        System.out.println("\t2.更改售货员\n");
        System.out.println("\t3.删除售货员\n");
        System.out.println("\t4.显示所有售货员\n");
        System.out.println("\t5.查询售货员\n");
        System.out.println("*************************\n");
        System.out.println("输入数字或者按0返回上级菜单");
        do {
            int info = ScannerJudge.scannerJudge();
            if (info >= 0 && info <= 5) {
                switch (info) {
                    case (0): {
                        goodsManagePage();
                        break;
                    }

                }
            } else {
                System.err.println("!输入有误!");
                System.out.println("重新选择或者按0退出.");
            }
        }
        while (true);
    }

}
