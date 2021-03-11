package day39;

import java.util.Scanner;

//case通过率不全
//测试用例
//原始的是回文串

//a -- aa
// cooc  -- coocc

//原始的不是回文串
//coco  -- cococ
// abb  -- abba
// 1234--- 12341


public class 回文串 {
    //解题思路
    /*如果一个字符串能通过添加一个字母变成回文串，那么它去掉一个字母也就可以变成会文串，
    于是我们就可以将字符串的每位都去掉一次去判断，
    如果一次回文串都没出现，说明添加一个字母也不能构成回文串。*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                String temp = str.substring(0, i) + str.substring(i + 1);
                if (isHuiWen(temp)) {
                    count++;
                }
            }
            if (count != 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    //case的通过率低
    //理解偏差就是不是在尾部添加一个字符串而是在任意的一个位置添加字符串
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str =sc.nextLine();
            //如果原始字符本身就是回文串的话，那么就不用添加了肯定不是

            if(str.length() == 1)  System.out.println("YES");//这和个情况必须放在前面 特例就是因为原始是回文串但是它的长度是1 那么添加后还是回文串
            if(isHuiWen(new StringBuilder(str))) System.out.println("NO");
            //添加的字符串肯定是原始字符串的第一个位置
            //对于添加后的字符串进行判断
            StringBuilder sb = new StringBuilder(str);
            sb.append(str.charAt(0));
            boolean b = isHuiWen(sb);
            if(b){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    //str的长度肯定是大于等于1的
    private static boolean isHuiWen(String sb) {
        if(sb.length() == 1) return true;
        int left = 0;
        int right = sb.length()-1;
        while (left < right){
            if(sb.charAt(left)!= (sb.charAt(right)) ){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private static boolean isHuiWen(StringBuilder sb) {
        if(sb.length() == 1) return true;
        int left = 0;
        int right = sb.length()-1;
        while (left < right){
            if(sb.charAt(left)!= (sb.charAt(right)) ){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }


}
