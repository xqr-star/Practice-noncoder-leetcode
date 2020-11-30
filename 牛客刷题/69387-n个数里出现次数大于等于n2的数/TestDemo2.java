package code;
import java.util.*;
public class TestDemo2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");//以，分割
            int[] arr = new int[strs.length];

            //字符串数组转换成int数组
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }

            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                } else if (count > 0) {
                    count--;
                } else {
                    num = arr[j];
                }
            }
            System.out.println(num);
        }
    }

}

/**import java.util.Scanner;
 public class Main{
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int [] arr = new int [];
 while(sc.hasNextInt()){
 for(int i = 0;i < 100 ;i++){
 arr[i] = sc.nextInt();
 }
 }
 int temp = arr.length /2;
 //统计数字的出现次数
 //需要用一个键值对map 一一对对应


 //对数组进行遍历，找出比数组长度大的元素
 }
 }*/
