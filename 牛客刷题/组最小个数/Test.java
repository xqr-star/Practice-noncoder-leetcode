package code;

import java.util.Scanner;

/**
 * 组个最小数字
 */

public class Test {
    public static void main(String args[]) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        //初始化数组
        for(int i = 0;i < 10;i++) {
            arr[i] = sc.nextInt();
        }
        //对数据进行输出

        //输出除了下标为0的第一个数组内元素不为0的下标并将其对应的元素-1
        for(int j = 1; j < arr.length;j++){
            if(arr[j] !=0 ){
                System.out.print(j);
                arr[j]--;
                break;
            }
        }
        //然后从数组的头开始依次输出
        for(int temp = 0; temp < arr.length;temp++) {
            while(arr[temp] !=0) {
                System.out.print(temp);
                arr[temp]--;
            }
        }

    }
}
