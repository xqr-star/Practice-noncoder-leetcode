package code;

import java.util.Scanner;

/**
 * 字符串中找出连续最长的数字串
 */
public class T1 {

    //【字符串中找出连续最长的数字串】读入一个字符串str，
    // 输出字符串str中的连续最长的数字串
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(theLongString(str));
    }

    //abcd12345ed125ss123456789
    //123456789 -- 在一行内输出str中里连续最长的数字串。
    private static String theLongString(String str) {
        //本来想的是创建一个什么都不指向的字符串
        //然后如果遇到了长的字符串就更改指向

        int max = 0; // 最长的个数
        int count = 0; // 表示记录临时的数字个数
        int end = 0; // 这是用来记录最长字符串的最后一个下标的
        //先把字符串转换成字符  //然后判断每一个字符是否是数字
        char[] arr = str.toCharArray();

        for(int i = 0; i < arr.length ; i++) {
            if(arr[i] >='0'&& arr[i] <= '9'){
                //如果是数字的话就放大字符串里面
               count ++;
               if(max < count) {
                   max = count;
                   end = i ;
               }

            }else {
                //一旦有一个不是的话
                count = 0 ; // count 就要重置为0

            }
        }
        //最后对字符串进行截取
        return str.substring( end+1-max,end+1); // 为什么是end + 1 因为它是[3 8)

    }

}
