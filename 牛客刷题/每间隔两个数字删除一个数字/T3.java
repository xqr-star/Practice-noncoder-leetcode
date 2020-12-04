package code;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //这个表示的是匹配了之后返回true !true 之后 为false就结束数日
        //不匹配为false  ！false  true
        //
        while (!sc.hasNext("0")) {
            System.out.println(sc.next());
        }
    }
}

