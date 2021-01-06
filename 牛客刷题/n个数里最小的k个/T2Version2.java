package CodeReview;

import java.util.Arrays;
import java.util.Scanner;

public class T2Version2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //先放到一个字符串数组里面
        String str[] = sc.nextLine().split(" ");
        //再将字符串数组转换成int 类型
        int arr[] = new int[str.length-1];

        int k = Integer.parseInt(str[str.length-1]);

        //除了最后一个数组都被放入到了数组里面
        for(int i = 0; i < str.length-1;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr,start,end);
        //只要没有找到index 和相等就一直part
        while (index != k){
            if(index > k){
                end = index-1;
                index = partition(arr,start,end);
            }else {
                start= index +1;
               index =  partition(arr,start,end);
            }
        }
        //对数组排序可以带index排序
        Arrays.sort(arr,0,k); // 不包含k 就表示对前k个排序
        for(int j = 0; j < k ;j++){
            System.out.print(j == k-1? arr[j]:arr[j]+" ");
        }



    }

    //3 9 6 8 -10 7 -11 19 30 12 23 5

   /* //告诉我从哪里排序到那里
    private static void quickSort(int[] arr,int start,int end) {
        if(start-end <= 0) {
            //表示已经有顺序了
            return;
        }
        //然后以k 为基准进行partition
        //返回的是基准的下标
        int index = partition(arr,start,end);
        //之后在对下标的左右两边分别进行排序
        quickSort(arr,start,index-1);
        quickSort(arr,index+1,end);

    }*/

    private static int partition(int arr[],int start,int end) {
        int k = arr[start];
        int left = start; // 从前往后走
        int right = end;//从后往前走
        while (left < right){
            while (k <= arr[right] && left < right) {
                right--;
            }
            while (k >= arr[left] && left <right) {
                left++;
            }
            //交换
            int temp = arr[left];
            arr[left] =  arr[right];
            arr[right] = temp;
        }
        int temp = arr[left];
        arr[left] = k;
        arr[start] = temp;


        return left;
    }
}
