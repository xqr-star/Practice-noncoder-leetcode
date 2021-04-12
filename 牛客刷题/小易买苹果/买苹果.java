package nowcoder;

import java.util.Scanner;

public class 买苹果 {

    // bug 没有调试出来
    //ctrl + alt + m 重构代码

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //多设置一个 避免下标越界的情况产生
        int[] dp = new int[num+1];
        //初始化设置
        for(int i = 0 ;i <= num;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        //初始化的边界设置
        if(num >= 6) dp[6] = 1;
        if(num >= 8) dp[8] = 1;

        for (int i = 12; i <= num; i++) {
            if (dp[i - 8] == Integer.MAX_VALUE && dp[i - 6] == Integer.MAX_VALUE) {
                //之后如果再有不可以购买的苹果数量，一律采用赋值为最大进行操作
                dp[i] = Integer.MAX_VALUE ;
            } else {
                dp[i] = Math.min(dp[i - 6], dp[i - 8]) + 1;
            }
        }
        if (dp[num] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[num]);
        }
    }

}
