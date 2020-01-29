package pzf.tools;

import java.util.Scanner;

/**
 * 1.操作完成后 选择下一步
 * 2.界面选择操作
 * @author pzf
 */
public class ScannerChoice {
    public static String ScannerInfoString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        return scanner.next();
    }
}
