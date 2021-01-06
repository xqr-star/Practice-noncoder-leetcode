package CodeReview;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    /**
     * 采用Arrays.sort 的方法
     * @param args
     */
    public static void main(String []args){
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
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for(int j = 0; j< k;j++) {
            System.out.print(arr[j]);
            if(j != k-1) {
                System.out.print(" ");
            }
        }

    }
}
