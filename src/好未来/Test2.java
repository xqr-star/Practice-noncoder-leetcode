package 好未来;

import java.util.Scanner;
import java.util.TreeSet;

public class Test2 {
    //找出最小偏移量

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        //arr 数组 用来放所有的整数 -- 需要统计出来相同的数字出现的次数
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }


        TreeSet <Integer> set = new TreeSet<>();
        int sub = Integer.MAX_VALUE;
        int length = arr.length;

        for(int i = 0; i< arr.length;i++){
            if(arr[i] % 2 != 0) {
                arr[i] *=2;
            }
            set.add(arr[i]);
        }


        while (set.last()%2 == 0){
            int max = set.last();//获取当前最大的元素
            set.remove(max);
            set.add(max/2);
            int maxNew = set.last();//新的最大的
            sub = Math.min(sub,maxNew-set.first());
        }
        System.out.println(sub);


    }

}
