package day40;

import java.util.Scanner;

public class 句子逆序 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
    }

    /**
     * StringBuilder 没有split的方法
     * @param str
     * @return
     */
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        String[] strArray =  str.split(" ");
        for(int i = strArray.length-1;i >=0;i--){
            sb.append(strArray[i]+" ");
        }
        return sb.toString().trim();
    }

}
