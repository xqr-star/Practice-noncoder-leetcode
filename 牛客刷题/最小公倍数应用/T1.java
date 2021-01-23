package code;

import java.util.Scanner;

public class T1 {
    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int a = sc.nextInt();
            int [] arr = new int[num];
            for(int i = 0; i < arr.length;i++){
                arr[i] = sc.nextInt();

                if(arr[i] <= a){
                    a += arr[i];
                }else{
                    //求最大公约数
                    //求最大公约数
                    int temp = a;
                    int b = arr[i];
                    int c = temp % b;
                    while( c !=0) {
                        temp = b;
                        b = c;
                        c =  temp % b;
                    }
                    a += b;
                }
            }
            System.out.println(a);
        }
    }
}
