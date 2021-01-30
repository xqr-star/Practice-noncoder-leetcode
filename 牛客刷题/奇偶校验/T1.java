package day30;

import java.util.Scanner;
/*
前置知识是 首先什么是奇偶校验 以及再什么地方进行补1的操作 是末尾还是开始
ascii 码中 0 -- 48
a 97
A 65
 */

public class T1 {
    //奇偶校验
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            //转换成字符 然后依次对每一个字符进行校验
            char[] arr = str.toCharArray();
            for(char ch : arr){
                //执行奇校验返回字符串
                String s = execute(ch);
                System.out.println(s);
            }

        }
    }

    private static String execute(char ch) {
        //转换成二进制位
        int binary = (int)ch;//转换成对应的ascii编码
        String temp = Integer.toBinaryString(binary);
        //统计二进制字符串里面的一的个数
        //如果是偶数就设置第一位位1--注意要补全8位
        //如果是奇数就不用变了
        StringBuilder sb = new StringBuilder();
        char[] arr = temp.toCharArray();
        int count = 0;
        int total = 0;
        for(char e : arr){
            if(e == '1') count++;
            total++;
        }

        //对1的个数进行判定
        if(count % 2==0){
            //如果是偶数个
            sb.append('1');
            while (total < 7){
                sb.append('0');
                total++;
            }
            sb.append(arr);
        }else {
            //奇数的话直接补全8位
            while (total < 8){
                sb.append('0');
                total++;
            }
            sb.append(arr);
        }
        return sb.toString();
    }
}
