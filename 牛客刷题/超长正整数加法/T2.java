package code;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 超长正整数相加
 *
 *  请设计一个算法完成两个超长正整数的加法。
 *  输入参数：
 *  String addend：加数
 *  String augend：被加数
 *  返回值：加法结果
 *
 */

//而Java中有一个类是专门用来处理很大数据的类，为 BigInteger，它支持任意精度的整数，
//也就是说在运算中 BigInteger 类型可以准确地表示任何大小的整数值而不会丢失任何信息
//我们可通过它的 add() 方法进行两个超长正整数相加的问题。
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            BigInteger a = new BigInteger(str1);
            BigInteger b = new BigInteger(str2);
            BigInteger res = a.add(b);
            System.out.println(res);
        }

    }




}

