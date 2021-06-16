package 背包;

import java.util.Scanner;

/**
 * 完全背包问题
 * f[i] 表示 总体积是i的情况下 最大价值是多少
 *
 * 状态转移
 * 从前到后 考虑每一个物品
 * f[j] = Math.max(f[j] , )
 *
 * 最终的结果 需要在 f[0] ....f[V]  依次枚举一下 然后找到最大值
 */
public class Test2 {

    /**
     * 状态表示： dp[i][j] 考虑前i个物品使用的总体积是j的情况下，对应的总价值
     * 状态转移
     * dp[i][j] = Math.max( 不选第i个物品f[i-1][j] ， 选一个第i个物品f[i-1][j-v[i]] + w[i] ,
     *                                             选两个第i个物品f[i-1][j- 2*v[i]] + 2*w[i],
     *                                             ...........
     *          这里的k是有限制的 是由当前的j来决定的      选k个第i个物品f[i-1][j- k*v[i]] + k*w[i])
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int[][] dp = new int[2][V+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1 ;i <= N;i++){
            //如果还是按照从大到小来枚举
            //可以保证的是上一个状态 一定是没有选择过第i个物品的
            for(int j = V; j>=0 ;j--){
                dp[i &2][j] = dp[i-1&1][j];
                int num = j / v[i];
                for (int k = 1; k <= num; k++) {
                    if(j-k*v[i] >= 0){   // 由于是倒着计算的 所以所有比 f[j]小的都没有计算过包含第i个物品的情况 所以可以进行* k的操作
                        dp[i%2][j] = Math.max(dp[i%2][j],dp[i-1&1][j-k*v[i]]+ k*w[i]);
                    }
                }
            }
        }

        System.out.println(dp[N%2][V]);
    }
    /**
     * 二维数组
     * @param args
     */
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int[][] dp = new int[N+1][V+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1 ;i <= N;i++){
            //如果还是按照从大到小来枚举
            //可以保证的是上一个状态 一定是没有选择过第i个物品的
            for(int j = V; j>=0 ;j--){
                dp[i][j] = dp[i-1][j];
                int num = j / v[i];
                for (int k = 1; k <= num; k++) {
                    if(j-k*v[i] >= 0){   // 由于是倒着计算的 所以所有比 f[j]小的都没有计算过包含第i个物品的情况 所以可以进行* k的操作
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i]]+ k*w[i]);
                    }
                }
            }


            //为什么下面这个改进的代码不可以呢？
//            for(int j = V; j >= v[i];j--){
//                dp[i][j] = dp[i-1][j];
//                int num = j / v[i];
//                for (int k = 1; k <= num; k++) {
//                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*v[i]]+ k*w[i]);
//                }
//            }
        }

        System.out.println(dp[N][V]);

    }
    /**
     * 从大到小枚举的
     * @param args
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int[] f = new int[V+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        //其实和0-1 背包的区别就是可以选择k个
        for (int i = 1 ;i <= N;i++){
            //如果还是按照从大到小来枚举
            //可以保证的是上一个状态 一定是没有选择过第i个物品的
            for(int j = V; j>=0 ;j--){
                f[j] = f[j];
                int num = j / v[i];
                for (int k = 1; k <= num; k++) {
                    if(j-k*v[i] >= 0){   // 由于是倒着计算的 所以所有比 f[j]小的都没有计算过包含第i个物品的情况 所以可以进行* k的操作
                        f[j] = Math.max(f[j],f[j-k*v[i]]+ w[i]);
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i<= V;i++){
            res = Math.max(f[i],res);
        }
        System.out.println(res);
    }

    /**
     * 从小到大枚举
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] v = new int[N+1];
        int[] w = new int[N+1];
        int[] f = new int[V+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        //其实和0-1 背包的区别就是可以选择k个
        for (int i = 1 ;i <= N;i++){
            //这样写 就不用判断 j - v[i]会不会越界了
            for(int j = v[i];j <= V;j++){
                //如果从小到大计算 那么 对于第i个物品来说
                //所有体积比j小的一定是计算过的
                //那么也就是可能包含第i个物品的
                 f[j] = Math.max(f[j],f[j-v[i]]+ w[i]);
            }
        }

        //最后的一定是表示的是所有小于等于V的情况下最大的价值
        System.out.println(f[V]);
    }

    /**
     * 如果要恰好V的体积下求最大的价值
     * 那么只需要初始化的时候 除了f[0]为0以外 其他的的初始化成 -1即可
     */



}
