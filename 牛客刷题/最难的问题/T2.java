package code;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String [] arr = sc.nextLine().split(" "); // 按照空格分放到数组里面
            for(int i = 0 ;i < arr.length;i++){ //
                //拿到数据进行解析
                String str= transfer(arr[i]);
                System.out.print(i != arr.length-1? str+" ": str);
            }
            System.out.println();
        }
    }




    private static String transfer(String s) {
        //如果不转换成字符数组怎么做？
        StringBuilder sb  = new StringBuilder();
        for(int i =0 ;i < s.length();i++){
            char ch = s.charAt(i);
            if (ch > 'E') {
                sb.append( (char)(ch-5));
            }else {
                sb.append( (char) (ch+21));
            }
        }
       return sb.toString();
    }

    private static String transfer2(String s) {
        char [] arr = s.toCharArray();
        //拿到里面的一个个的字符
        for(int i = 0; i<arr.length;i++){
            if( arr[i] >= 'A' && arr[i] <= 'E') {
                arr[i] = (char) (arr[i] +21);
            }else {
                arr[i] =(char) (arr[i]- 5);
            }
        }
        String string = new String(arr);
        return string;
    }



    private static String transfer1(String s) {

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
        String str = new String(arr);//可以用一个字符数组来new 一个String 然后形成一个str
        return str;

    }
}
