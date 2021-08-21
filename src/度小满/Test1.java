package 度小满;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 小王在参加一个字符串的游戏。
 *
 * 小王会获得一个初始的字符串T，然后小王可能会碰到这几种操作：
 *
 *
 *
 * 操作1：将字符串尾部的k个字符删除
 *
 * 操作2：将字符串反转
 *
 * 操作3：给小王一个字符串s，要求小王在目前这个串后面拼接上串s
 *
 *
 *
 * 你的任务是协助小王求得最终的字符串。
 *
 * 注意：字符串中仅包括大小写字母
 *
 *
 *
 * 输入描述
 * 第一行一个正整数n和一个初始字符串T。n描述小王接下来需要做多少个操作。T描述初始的字符串。
 *
 * 接下来n行，每行一个操作。操作可能是下列三种格式之一：
 *
 * 1 k : 将尾部k个字符删除
 *
 * 2 : 反转字符串
 *
 * 3 s : 在原来的字符串基础上拼接字符串s
 *
 * 64
 */
public class Test1 {


    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "delete");
        map.put(2, "reverse");
        map.put(3, "append");


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String string = scanner.nextLine();

        while (n > 0) {
            int opt = scanner.nextInt();
            if (opt == 1) {
                int k = scanner.nextInt();
                string = delete(string, k);
            }
            if (opt == 2) {
                string = reverse(string);
            }
            if (opt == 3) {
                String app = scanner.next();
                string = appendStr(string, app);
            }
            scanner.nextLine();
            n--;
        }
        System.out.println(string.trim());
    }

    private static String appendStr(String string, String app) {
        StringBuilder sb = new StringBuilder(string);
        return sb.append(app).toString();
    }

    private static String reverse(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    private static String delete(String string, int k) {
        string = string.trim();
        int length = string.length();
        return string.substring(0,length-k);
    }
}
