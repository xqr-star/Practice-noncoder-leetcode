package bilibili;

import java.util.Arrays;
import java.util.Scanner;
//乘积差最大值寻找 100%
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String str = string.substring(1,string.length()-1);
        if(str.length() == 0){
            System.out.println("0");
            return;
        }
        String[] split = str.split(",");
        if(split.length == 0) {
            System.out.println("0");
            return;
        }
        int[] arr = new int[split.length];

        for(int i = 0; i < arr.length;i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int lastIndex = arr.length-1;
        if(arr.length >= 4){
            int temp = arr[lastIndex] * arr[lastIndex-1];
            int temp2 = arr[1] * arr[0];
            int res = temp-temp2;
            System.out.println(res);
        }else {
            System.out.println("0");
        }
   }
}
