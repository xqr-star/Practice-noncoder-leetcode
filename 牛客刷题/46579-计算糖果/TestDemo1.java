package code;
import java.util.Scanner;
public class TestDemo1 {


    public static void main(String[] args) {
        /**
         * 分糖果
         */
        Scanner sc = new Scanner(System.in);
        int [] arr = new int [4];
        for(int i = 0;i < 4 ;i++){
            arr[i] = sc.nextInt();
        }
        int a = (arr[0] +arr[2])/2;
        int b = (arr[1] +arr[3])/2;
        int c = arr[3]-b;
        if(a >= 0&& b >= 0 && c>= 0){
            System.out.println(a+" "+b+" "+c);
        }else{
            System.out.println("No");
        }

    }

}
