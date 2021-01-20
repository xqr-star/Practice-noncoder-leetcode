package code;

import java.util.Scanner;

/**
 * 斐波那契数列的求解
 *
 * 1                   小兔子
 * 2                   大兔子
 * 3          大兔子            小兔子
 * 4 大兔子 +        小兔字                 大兔子
 * 5 大兔子 +小兔字     大兔子                大兔子 +小兔字
 *
 * 规律
 * 1. 上一个月的小兔子这一个月就会变成大兔子 只是不生兔子 到下一个月才会生
 * 2.本月的兔子数量 = 大兔子+       小兔子    f(n)
 *                  本月的大兔子是上月的所有兔子(因为上月的小兔字这个月变成大兔子) f(n-1)
 *                  本月的小兔子是上个月的大兔子生的 （而上个月的大兔子又是上上个月所有兔子和） f(n-2)
 *
 */

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int month = sc.nextInt();
            System.out.println(getTotalCount(month));

        }
    }
    public static int getTotalCount (int monthCount){
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
       return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);

    }
}
