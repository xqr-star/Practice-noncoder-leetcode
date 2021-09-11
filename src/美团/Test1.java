package 美团;

import java.util.Scanner;
/*
小美最近迷上了22这个数字，
一天，她发现他的一本书中有一个神秘的大数字。
于是她想知道这个数字中有多少子串代表的数字能被22整除。


输入描述
一行一个只由数字组成的不含前导零的字符串，字符串长度为 n(1≤n≤10^5)。

输出描述
一行一个整数代表有多少这个字符串的子串代表的数字能被 22 整除。
 */
//整除 -- 27
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        for(int i = 0; i < str.length();i++){
            for(int j = 2; j < str.length()-i;j++) {
                String temp = str.substring(i, i+j);
                int num = Integer.parseInt(temp);
                if (num % 22 == 0) count++;
            }
        }
        System.out.println(count);
    }
}
