package day32;

import java.util.Scanner;
//在霍格沃茨找零钱

public class T1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] price = sc.next().split("\\."); //注意转义字符
        String[] pay = sc.next().split("\\.");
        calculator(price,pay);
    }
    public static void calculator(String[] price, String[] pay){
        //把所有的钱全部转换位纳特
        Long priceKnut = (Long.parseLong(price[0]) *17*29 + Long.parseLong(price[1]) * 29+Long.parseLong(price[2])) ;
        Long payKnut = (Long.parseLong(pay[0])*17 *29+Long.parseLong(pay[1]) * 29+Long.parseLong(pay[2] ));
        Long res = payKnut- priceKnut;//所有的纳特数字
        Long r1 = res/(17* 29);//加隆数字
        Long r2 = (res- r1*17*29)/ 29;//银可数
        Long r3 = (res - (r1*17*29)-(r2*29));//纳特数字
        if(res >= 0){//说明钱够了
            System.out.println(r1+"."+r2+"."+r3);
        }else {//说明钱不够
            System.out.println("-"+Math.abs(r1)+"."+Math.abs((r2))+"."+Math.abs((r3)));
        }
    }



}
