package day30;

import java.util.Scanner;

/*前置知识就是str 本身的conpareTo方法是可以实现比较的
        String str = "1234";
        String str2 = "12345";
        int num = str.compareTo(str2);
        System.out.println(num); -1*/
public class T2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.valueOf(str);
        String[] arr = new String[num];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextLine();
        }

        //写一个排序的算法 冒泡排序
        bubble(arr);
    }

    private static void bubble(String[] arr) {
        //无序区间 [i ,arr.length]
        //有序区间[0,i)
        for(int i = 0; i < arr.length-1;i++){ //多少个数字需要比较
            for(int j =0 ;j< arr.length-1 - i;j++){
                //字符串比较大小的时候，默认比较的是第一个数字
                //第一个相同了才往后比叫
                if(compareBig(arr[j],arr[j+1]) > 0){
                    //表示前面的数字大
                    //执行交换的逻辑
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }




        //对数字进行输出
        for(String str: arr){
            System.out.println(str);
        }
    }

    private static int compareBig(String s1, String s2) {
        if(s1.length() > s2.length()){
            //长度问题
            return 1;
        }else if(s1.length() < s2.length()){
            return -1;

        }else {
            //如果长度相等就默认的比较
            return s1.compareTo(s2);
        }
    }
}
