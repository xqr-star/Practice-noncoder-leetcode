package lc2;

import java.util.Arrays;

//322. 零钱兑换
public class coinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 6));
    }



    public static int coinChange3(int[] coins, int amount) {
        // dp[i][j] 表示前 i 种***，恰价值为 j，所需要的最小数目
        int N = coins.length;
        int[][] dp = new int[2][amount + 1];

        // initialize dp[i][0] = 0,  dp[0][j] = amount + 1(j >= 1); 设为 amount + 1 表示该值不可能
        for (int j = 1; j <= amount; j++) dp[0][j] = amount + 1;
        // dp[i][j] = min{dp[i - 1][j], dp[i][j - coins[i - 1]] + 1}

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i & 1][j] = Math.min(dp[(i - 1) & 1][j], dp[i & 1][j - coins[i - 1]] + 1);
                } else {
                    dp[i & 1][j] = dp[(i - 1) & 1][j];
                }
            }
        }
        // dp[coins.length][amount]
        return dp[N & 1][amount] == amount + 1 ? -1 : dp[N & 1][amount];
    }



    public static int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int n = amount;
        int[][] dp = new int[length+1][n+1];
        //全部设置为 最大值表示状态不可达

        //状态初始化设置的有问题
        //因为是从前到后的转移
        //所以i = 0 的 j ！= 0 所有的状态都是不合理状态设置为最大值即可表示不可达
        for(int j =1;j <= amount;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        //dp[i][j]  表示的是由前i个硬币组成体积是j所需要的硬币个数
        for(int i = 1; i <= length;i++){
            //必须从0 开始写
            for(int j = 0; j <= amount;j++){
                //当前的硬币不用  -- 这里如果做到了当前的用几个的问题
                if (j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[(i - 1) ][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[(i - 1)][j];
                }
            }
        }
        if(dp[length][amount] == Integer.MAX_VALUE){
            dp[length][amount] = -1;
        }
        return dp[length][amount];
    }

    public static int coinChange4(int[] coins, int amount) {
        int length = coins.length;
        int n = amount;
        int[][] dp = new int[length+1][n+1];
        //全部设置为 最大值表示状态不可达

        //状态初始化设置的有问题
        //因为是从前到后的转移
        //所以i = 0 的 j ！= 0 所有的状态都是不合理状态设置为最大值即可表示不可达
        for(int j=1; j<= amount;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }

        //dp[i][j]  表示的是由前i个硬币组成体积是j所需要的硬币个数



        for(int i = 1; i <= length;i++){
            //必须从0 开始写
            for(int j = 0; j <= amount;j++){
                //当前的硬币不用  -- 这里如果做到了当前的用几个的问题
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[(i - 1) ][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[(i - 1)][j];
                }


                //好像问题出在了我枚举数量的问题上！....

//                //状态转移 当前的这个不用 和当前的这个用1个 ..用好几个
//                for(int k = 1; k*coins[i-1] <= j; k++){
//                    if(dp[i-1][j-k*coins[i-1]] != Integer.MAX_VALUE) {
//                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - k * coins[i - 1]] + k);
//                    }
//                }
            }
        }
        if(dp[length][amount] == Integer.MAX_VALUE){
            dp[length][amount] = -1;
        }
        return dp[length][amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        int length = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int arr : coins){
            for(int j = arr;j <= n;j++){
                if(dp[j-arr] != Integer.MAX_VALUE) {
                    //必须上一个状态是可以转移的 否则不能子啊上一个状态上进行转移操作
                    dp[j] = Math.min(dp[j], dp[j - arr] + 1);
                }
            }
        }
        //记得处理无法组成的情况
        if(dp[n] == Integer.MAX_VALUE){
            dp[n] = -1;
        }
        return dp[n];
    }

}
