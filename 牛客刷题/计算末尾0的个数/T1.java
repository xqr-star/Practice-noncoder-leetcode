package code;

import java.util.Scanner;

public class T1 {

    // 对于n的阶乘n！，其因式分解中，如果存在一个因子“5”，
    // 那么它必然对应着n！末尾的一个“0”。

    //这里面因该算的是每一个i能被分解成几个5  -- 同时好药考虑不断的可分性
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = n;i > 4;i--){
            //因为i还需要涉及到下一次循环，所以不能把i改动
            int temp = i;
            while (temp % 5 == 0 ) {
                count ++;
                temp= temp /5; // 还得看我分解出来的因数有没有能被5整除的
            }
        }
        System.out.println(count);
    }

    /**
     * 这个解法的问题是在，计算机的容量有限，计算阶乘的时候会出现数据存储不下的问题。
     * @param args
     */

    /*public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //第一步求阶乘
        int ret = 1;
        for(int i =num;i>0;i--){
            ret *= i;
        }
        System.out.println(ret);
        //第二步求0的个数
        int count = 0;
        int temp = 10;
        while(ret % temp == 0){
            count++;
            temp *= 10;
        }
        System.out.println(count);
    }*/
}
