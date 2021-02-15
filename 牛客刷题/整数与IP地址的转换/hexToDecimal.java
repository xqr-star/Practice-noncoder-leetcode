package PriorityQueue;

import java.util.Scanner;

/**
 * 十六进制和十进制的转换
 */
public class hexToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String hexString = sc.nextLine();
            System.out.println(hexToDecimal1(hexString));
            System.out.println(hexToDecimal2(hexString));
        }
    }

    //把一个十六进制的字符型转换成一个十进制的数字

    //这个思路是把每一个字符的对应的十六进制求出来然后加和
    //但是还可以有其他的思路

    /*
    f - 15
    cf -  (12*16)+15
    3cf - ((3*16)+12)*16 +15
    93cf -  (((9*16)+3)*16+12)*16 +15
    */
    private static long hexToDecimal1(String hexString) {
        long sum = 0;
        for(int i = 0;i < hexString.length();i++){
            char ch = hexString.charAt(i);
            if(Character.isDigit(ch)){ //如果是数字
                sum += (ch -'0')*Math.pow(16,hexString.length()-1-i);
            }else{ //如果是字母
                sum += ((ch-'A')+10)*Math.pow(16,hexString.length()-1-i);
            }
        }
        return sum;
    }
    private static long hexToDecimal2(String hexString) {
        long sum = 0;
        for(int i = 0;i < hexString.length();i++) {
            char ch = hexString.charAt(i);
            int digit = 0;
            if(Character.isDigit(ch)){
                digit = ch-'0';
            }else {
                digit = (ch-'A')+10;
            }
            if(i == hexString.length()-1){
                sum = (sum +digit);
            }else {
                sum = (sum + digit) * 16;
            }
        }
        return sum;
    }
}
