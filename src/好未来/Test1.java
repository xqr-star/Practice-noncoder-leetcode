package 好未来;

import java.util.Scanner;

public class Test1 {


    /**
     * 深搜
     * @param args
     */

    static  int count = 0;
    public static void main1(String[] args) {

        int amount = 5;
        int[] arr = new int[]{1,2,5};
        dfs(arr,0,5);


    }

    private static void dfs(int[] arr, int start, int target) {


//        for(int i = 0; i < arr.length;i++){
//            dfs(arr,target-arr[i]);
//        }

    }

    /**
     * 动态规划
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        int[] arr = new int[split.length];
        for(int i = 0; i < arr.length;i++){
            arr[i] = Integer.parseInt(split[i]);
        }

        int dp[][] = new int[arr.length+1][amount+1];
        //用dp[i] 表示凑出i的最都数量

        dp[0][0] = 1;

        for(int i =1 ;i <= arr.length;i++){
            for(int j = 0;j <= amount;j++){

                //前一个直接凑够了
                dp[i][j] = dp[i-1][j];
                //枚举物品的个数

                for(int k = 1;k*arr[i-1] <= j;k++){
                   dp[i][j] += dp[i-1][j-k*arr[i-1]];
                }
            }
        }

        System.out.println(dp[arr.length][amount]);


    }
}
