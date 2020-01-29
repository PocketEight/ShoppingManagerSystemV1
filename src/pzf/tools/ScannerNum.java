package pzf.tools;

import java.util.Scanner;

/**
 * @author pzf
 * 1.判断是否为数字
 * 2.保留小数2位
 * 3.若不是 返回-1
 */
public class ScannerNum {
    public static float ScannerInfoFloat() {
        float num = 0.00f;
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("保留小数点后两位,请输入：");
            String info = sc.next();

            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
            if (info.matches(regex))
            {
                num = Float.parseFloat(info);
            }else
            {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);

        return num;
    }

    /**
     * @return int 键盘获取商品数量
     */
    public static int ScannerInfoInt()
    {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";//商品数量
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入：");
            String nums = sc.next();

            if (nums.matches(regex))
            {
                num = Integer.parseInt(nums);
            }else
            {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);
        return num;
    }
}
