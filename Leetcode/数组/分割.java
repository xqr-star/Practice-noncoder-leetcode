package 随便什么练习;

import java.util.Arrays;

public class 分割 {
    /**
     * 分割奇偶数
     * 奇数放左边
     * 偶数放右边
     */
    public static void main(String[] args) {
        int[] arr= new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        arr= 分割(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 采用挖坑法
     * @param arr
     */
    public static int[] 分割(int[] arr){
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        //刚开始坑的位置一定要保留
        int key = arr[leftIndex];
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && arr[rightIndex] %2 == 0){
                rightIndex--;
            }
            arr[leftIndex] = arr[rightIndex];
            while (leftIndex < rightIndex && arr[leftIndex] %2 != 0){
                leftIndex++;
            }
            arr[rightIndex] = arr[leftIndex];
        }

        //把坑填回去
        arr[leftIndex] = key;
        return arr;
    }
}
