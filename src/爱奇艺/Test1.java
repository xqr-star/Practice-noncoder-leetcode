package 爱奇艺;

import java.util.Scanner;

//求滑动窗口平均数最大增幅
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(":");
        String[] split2 = split[0].split(",");

        int k = Integer.parseInt(split[1]);
        int[] arr = new int[split2.length];
        int i =0;
        for(String str: split2){
            arr[i++] = Integer.parseInt(str);
        }

        //采用了开区间 [)
        int left = 0;
        int right = k-1;
        int sum = 0;
        double leftpinJun = 0;
        double pinJun = 0;
        double maxP = 0;
        double p = 0;

        for (i = 0 ; i <= right;i++){
            sum += arr[i];
        }
        pinJun = sum * 1.0/(k);
        leftpinJun = pinJun;
        right++;
        while (right < arr.length){
            sum -= arr[left];
            sum += arr[right];
            pinJun = sum * 1.0/(k);
            p = (pinJun - leftpinJun)/(leftpinJun * 1.0);
            if(p > maxP) maxP = p;
            leftpinJun = pinJun;
            left ++;
            right ++;
        }

        double res = maxP *100;

        System.out.println(String.format("%.2f",res)+"%");
    }
}
