package pzf.tools;

import java.util.Scanner;

/**
 * 对输入数字进行各种判断。
 * 只有仅输入一个有效数字时返回可操作数
 *
 * @author pzf
 */
public class ScannerJudge {
    public static int scannerJudge(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        String choice=scanner.next();
        char a[]=choice.toCharArray();
        int info=-1;
        if(Character.isDigit(a[0])&&a.length==1)
            info = Integer.parseInt(choice);
        return info;
    }
}
