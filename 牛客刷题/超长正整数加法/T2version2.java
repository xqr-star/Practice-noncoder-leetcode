package code;

import java.util.Arrays;
import java.util.Scanner;

public class T2version2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //分别将两个输入的数字放到数组中去
        char[] arr1 = sc.next().toCharArray();
        char[] arr2 = sc.next().toCharArray();

        int temp = Math.max(arr1.length,arr2.length);
        //开辟一个新的数组，比最大的数组的长度大一
        int[] arr3 = new int[temp+1];

        //从后面开始加然后放到第一位，最后逆置输出就可以啦

        for (int i = 0; i < temp-1; i++) {

            //分别取出两个数组的那个位数
            // % 10 的结果放到对应的i位置上
            //10 的结果放到新数组中i+1 上表示进位

            int a1 = arr1[arr1.length-1-i]-'0';
            int a2 = arr2[arr2.length-1-i]-'0';
            int sum = a1 + a2 + arr3[i]; // 注意要把进位加上
            arr3[i] = sum%10;
            arr3[i+1] = sum/10; //
        }


      /*  //处理最后一位
        arr3[arr3.length-1] += arr2[arr2.length-1];*/

        int theLast = (arr2[0]-'0')+ (arr3[arr3.length-2]); // 数组2的最后一位+ 数组三的进位倒数第二位

        if(theLast /10 == 0){
            arr3[arr3.length-2] = theLast;
        }else {
            arr3[arr3.length-2]  = theLast%10;
            arr3[arr3.length-1] = theLast/10;
        }

        System.out.println(Arrays.toString(arr3));

    }
}
