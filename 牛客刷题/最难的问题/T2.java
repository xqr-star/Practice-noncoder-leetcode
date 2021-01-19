package code;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String [] arr = sc.nextLine().split(" ");
            for(int i = 0 ;i < arr.length;i++){
                //拿到数据进行解析
                String str= transfer(arr[i]);
                System.out.print(i != arr.length-1? str+" ": str);
            }
            System.out.println();
        }



    }

    private static String transfer(String s) {

        char[] arr = s.toCharArray();
        for(int i = 0 ;i < arr.length;i++){
            //把char转换成int
            int temp = arr[i]-5 ;
            if(temp < 65){
                int submit = 65-temp;
                temp = 91-submit;
            }
            arr[i] = (char) temp;
        }

        //返回字符串
        String str = new String(arr);
        return str;

    }
}
