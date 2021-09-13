package bilibili;

import java.util.Scanner;
//没啥难度的一个题 ....
public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,8,10,12,13,14,15,17,18,19};

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > arr.length){
            System.out.println("-1");
            return;
        }
        if(num <= 0){
            System.out.println("-1");
            return;
        }

        System.out.println(arr[num-1]);

    }
}
