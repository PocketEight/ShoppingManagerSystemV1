package pzf.page;

import pzf.DAO.SalesmanDao;
import pzf.tools.ScannerChoice;
import pzf.tools.ScannerJudge;

/**
 * 主页 2
 * 收银页面
 * 1.登录
 * 2.收银
 * @author pzf
 * @version 1.0
 */


public class SalesPage {
    /**
     * 登录
     */
    public static void loginPage(){
        System.out.println("请输入用户名：");
        String salesmanName = ScannerChoice.ScannerInfoString();
        System.out.println("\n请输入密码：");
        String salesmanPassword =ScannerChoice.ScannerInfoString();
        boolean flag= SalesmanDao.login(salesmanName,salesmanPassword);
        int count=2;
        do{
            if(flag){
                //购物结算页面
                break;
            }
            else {
                System.out.println("\n用户名和密码不匹配！\n你还有"+count+"次机会，请重新输入：");
                count--;
                System.out.println("请输入用户名：");
                salesmanName = ScannerChoice.ScannerInfoString();
                System.out.println("\n请输入密码：");
                salesmanPassword =ScannerChoice.ScannerInfoString();
                flag= SalesmanDao.login(salesmanName,salesmanPassword);
            }

        }while (count>0);
        System.out.println("错误三次 退出系统");
        MainPage.mainPage();
    }
}
