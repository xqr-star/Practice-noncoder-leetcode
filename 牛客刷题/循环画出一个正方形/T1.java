package code;

import java.util.Scanner;

public class T1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String ch = sc.next();
        //输出第一行
        for (int i = 0; i < num; i++) {
            System.out.print(ch);
        }
        System.out.println();
        double temp = num/2.0;
        int line = (int)Math.round(temp);
        //输出其他行
        for (int j = 0; j < line - 2; j++) {
            for (int i = 0; i < num; i++) {
                //首位打印字符
                if (i == 0) {
                    System.out.print(ch);
                } else if (i == (num - 1)) {
                    System.out.print(ch);
                } else {
                    System.out.print(" ");
                }
            }
            // 每一行打印完换行
            System.out.println();
        }

        //输出最后一行
        for (int i = 0; i < num; i++) {
            System.out.print(ch);
        }


    }
}