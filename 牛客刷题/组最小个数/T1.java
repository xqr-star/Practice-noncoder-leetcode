package code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 组个最小数字
 */

public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //字符数组接受
            String[] str = sc.nextLine().split(" ");

            //转换成int 数组
            int[] array = new int[10];
            for(int i = 0 ; i< 10 ;i ++) {
                array[i] = Integer.parseInt(str[i]);
            }
            //已经拍过顺序的了
            Arrays.sort(array);
            //找到第一个非0 的数字
            int num = 0;
            int j = 0;
            for( ; j < array.length; j++) {
                if(array[j] !=0) {
                   num += array[j] * Math.pow(10,9);
                   break;
                }
            }
            // j 保存的是第一个非0  数字的下标
            int temp = 9; // 处理的是后面的幂
            for(int i = 0;i <array.length;i++) {
                if( i == j) {
                    continue;
                }
                num += array[i]*Math.pow(10,--temp);// temp--
            }
            System.out.println(num);
        }

    }

}
