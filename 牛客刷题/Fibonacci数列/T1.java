package code;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        int a = 0;
        int b = 1;
        int c = a+b;
        //0 1 1 2  3
        //因为题上说了num 的范围所以这个if else 可以去掉
        // 1 < num < 1000
        /*if(num == 0 || num == 1){
            System.out.println(count);
        }else {*/
            while(c < num){
                a = b;
                b = c;
                c = a+b;
            }
            //跳出循环的时候，说明c >=num
            count = Math.min((num-b),(c-num));
            System.out.println(count);
        //}

    }
}
