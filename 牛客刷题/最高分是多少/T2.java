package code;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int count = sc.nextInt();
            int[] arr = new int[num];
            for(int i =0 ; i< arr.length;i++){
                arr[i] = sc.nextInt();
            }
            while(count != 0){
                String temp = sc.next();
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();


                if(temp.equals("Q")){
                    //询问最高的成绩
                    int a = temp1;
                    int b = temp2; //有可能存在 a> 的情况

                    int num2 = Math.abs(b- a)  + 1;
                    int[] arr2 =  new int[num2];
                    int temp3 = 0;
                    if(b>a)
                        temp3 = a-1;
                    else temp3 = b-1;
                    for(int j =0 ;j < arr2.length;j++){
                        arr2[j] = arr[temp3++];
                    }
                    Arrays.sort(arr2);
                    System.out.println(arr2[num2-1]);
                }else {
                    //更新操作
                    int id = temp1 - 1;
                    arr[id] = temp2;
                }
                count --;
            }
        }
    }
}
