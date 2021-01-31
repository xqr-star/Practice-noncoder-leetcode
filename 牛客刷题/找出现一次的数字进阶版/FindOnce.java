package day09;

import java.util.Arrays;
import java.util.Scanner;

public class FindOnce {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int [] arr = new int[num];
            for(int i =0 ;i <arr.length;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);//要先排序
            findOnce(arr);
        }
    }
    //找数字
    public static void findOnce(int [] arr){
        int[] res = new int[]{-1,-1};
        int left = 0;//左右指针
        int right = 1;
        int index  = 0;
        while(right <= arr.length-1){ //走到最后一个的时候
            int temp = arr[left] ^ arr[right];
            if(temp == 0){
                left = right+1;
                right = left+1;
            }else{
                res[index++]= arr[left];
                left = right;
                right = left+1;
            }
        }
        if(res[1] == -1 ){
            res[1] = arr[left];
        }
        Arrays.sort(res);
        for(int i =0 ;i <2 ;i++){
            System.out.print(i == 1? res[i]:res[i]+" ");
        }
        System.out.println();
    }
}
