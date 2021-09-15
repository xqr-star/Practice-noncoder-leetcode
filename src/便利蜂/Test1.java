package 便利蜂;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sum = scanner.nextInt();
        String [] array = str.split(",");
        int[] arr = new int[array.length] ;
        for (int i = 0 ;i < arr.length;i++){
            arr[i] = Integer.parseInt(array[i]);
        }

        int[][] dp = new int[arr.length+1][sum+1];

        //所有设置为最大 表示不可达
        for(int j = 1; j <= sum;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }



        for (int i = 1; i <= arr.length;i++){
            for(int j = 0;j <= sum;j++){
                if(j - arr[i-1]  >= 0 && dp[i][j-arr[i-1]] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j- arr[i-1]]+1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int min = 0;
        for(int i = 1; i< arr.length;i++){
            min = Math.min(min,dp[i][sum]);
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        System.out.println(dp[arr.length][sum]);
    }
}
