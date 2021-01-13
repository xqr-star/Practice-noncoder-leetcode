package code;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int a1 = num*num-num+1;
            for(int i =0 ;i <num;i++){
                if(i == num-1){
                    System.out.print(a1);
                } else {
                    System.out.print(a1 + "+");
                    a1 += 2;
                }
            }
            System.out.println();
        }
    }
}
