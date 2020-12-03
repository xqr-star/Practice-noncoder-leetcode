package code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找出数组里里面前k 大的数字
 * 主要是处理的很多细节
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] str2 = str.split(" "); //将字符串按照空格拆分
        //提取出n str2[str.length()-1];
        int length = str2.length;
        int k = Integer.parseInt(str2[ length- 1]); // 取到最后一个数组元素
        int[] arr = new int[length -1];

        //全部转换为整型数组 最后一个不用参与
        for (int i = 0; i < length-1; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }

        //找到最后一个元素
        //对整型数组进行排序
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}