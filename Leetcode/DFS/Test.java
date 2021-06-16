package 背包;

import java.util.Scanner;

// 0-1 背包问题

/**
 * 此种背包问题 并没有强调说要恰好放满背包
 * 因此 最后遍历二维数组的时候需要做的是i个物品的所有体积都要去遍历一遍
 */
public class Test {


    static int[] v; // 存放体积
    static int[] w; //存放价值
    static int[] f;

    /**
     *
     * f[i] 表示的是 体积是i的时候获取的最大价值
     * 一维数组优化
     *
     * 最后的不需要枚举 所有体积
     * 原因是和我们最初的初始化有关系的
     * 如果想求解 体积恰好是m的时候的最大价值
     * 初始化的需要做的就是
     * f[0] = 0
     * 其他初始化为负无穷即可
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();

        v = new int[N+1];
        w = new int[N+1];
        f = new int[V+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for(int i = 1 ;i <= N;i++){
            //枚举每一个体积

            //error
//            for(int j =0 ;j <= V;j++){
//                if(j-v[i] >= 0 ){
//                    f[j] =  Math.max(f[j] , f[j-v[i]] + w[i]);
//                }
//            }
            for(int j= V;j>=0 ;j--){
                if(j-v[i] >= 0 ){
                    f[j] =  Math.max(f[j] , f[j-v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[V]);
    }

    static int [][] dp ;

    /**
     * 滚动数组优化
     * 可以发现的规律是
     * 滚动起来 只需要让横坐标就是 %2
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        dp = new int[2][V+1];
        v = new int[N+1];
        w = new int[N+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        dp[0][0] = 0;
        //枚举每一个物品
        for(int i = 1; i<= N;i++){
            //枚举对应的体积
            for (int j = 0; j<= V;j++){
                dp[i%2][j] = dp[i-1 & 1][j];
                if(j >= v[i]) {
                    dp[i%2][j] = Math.max(dp[i%2][j], dp[i - 1 & 1][j - v[i]] + w[i]);
                }
            }
        }

        //然后遍历一遍 dp[i][j] 里面j等于V找到最大的　
        int res = 0;
        //最后枚举的是使用了i个物品  各个体积下的最大值
        for(int i = 0; i <=V ;i++){
            res = Math.max(res,dp[N %2][i]);
        }
        System.out.println(res);
    }

    /**
     * 状态表示
     * f[i][j] 考虑前i个物品使用的总体积是j的情况下，对应的总价值
     * result = max{ f[n][0-v] }
     *
     * 状态转移 如果不选第i个物品 f[i][j] = f[i-1][j]
     *         如果选第i个物品  f[i][j] = f[i-1][j-v(i)]
     *
     * 最终的答案 遍历一遍选择最大值
     *
     * 状态初始化
     * f[0][0] = 0
     * @param args
     */

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        dp = new int[N+1][V+1];
        v = new int[N+1];
        w = new int[N+1];
        //存放数据 这样存放可以避免越界
        for (int i = 1;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }


        dp[0][0] = 0;
        //枚举每一个物品
        for(int i = 1; i<= N;i++){
            //枚举对应的体积
            for (int j = 0; j<= V;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        //然后遍历一遍 dp[i][j] 里面j等于V找到最大的　
        int res = 0;
        //最后枚举的是使用了i个物品  各个体积下的最大值
        for(int i = 0; i <=V ;i++){
            res = Math.max(res,dp[N][i]);
        }
        System.out.println(res);

    }
}
