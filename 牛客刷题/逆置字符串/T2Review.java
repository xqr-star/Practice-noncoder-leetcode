package code;

import java.util.Scanner;

public class T2Review {
    /**
     * 使用StringBuffer 逆置字符串
     * @param args
     */
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //转换成字符串
        String str = String.valueOf(num);
        //StringBuffer stringBuffer = new StringBuffer(num); 表示的是new的Stringbuffer的数组大小
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer.reverse());
    }



    //不断的取尾数然后舍弃尾数
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //12345

        while (num !=0 ){
            System.out.print(num % 10);
            num = num/10;
        }

    }
}
