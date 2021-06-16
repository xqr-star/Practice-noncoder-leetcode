package lc2;

//518. 零钱兑换 II
public class change {
    //DFS  但是每一个硬币又无限个 所以说这里可能用不来了
    // 但是我又觉得可以 只要是一个整数的倍数就可以了

    //DP

    /**
     * 状态表示
     * 完全背包问题 一般的背包问题用两维表示
     * 状态表示
     * f[i][j]  所有由前i种硬币凑出的总钱数等于j的凑发
     * 属性 ：凑发的数量
     *
     * 状态计算
     * 根据第i个物品选1个 选2个 ....
     * 但是是有上限的 再多选的话体积就会超出
     * f[i][j]  = f[i-1][j](不选第i个物品)
     *            f[i-1][j-t*nums[i]] (选t个第i个物品)
     *
     * @param amount
     * @param coins
     * @return
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5};
        System.out.println(change(5, arr));
    }

    public static int change3(int amount, int[] coins) {
        int N = coins.length;
        int V = amount;
        int[][] dp = new int[2][V + 1];

        dp[0][0] = 1;
        //三重循环枚举
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                //表示当前的这个硬币最多可以用多少个
                //多重背包 和一维的区别就在这里 需要考虑当前这个i选不同个数对应的情况
                dp[i % 2][j] = dp[i - 1 & 1][j];
                int num = j / coins[i - 1];
                for (int k = 1; k <= num; k++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[i % 2][j] += dp[i - 1 & 1][j - k * coins[i - 1]];
                    }
                }

            }
        }
        return dp[N % 2][V];
    }

    /**
     * 朴素
     * @param amount
     * @param coins
     * @return
     */
    public static int change2(int amount, int[] coins) {
        int N = coins.length;
        int V = amount;
        int[] [] dp = new int[N+1][V+1];

        dp[0][0] = 1;
        //三重循环枚举
        for(int i = 1;i <= N;i++){
            for(int j = 0;j <= V;j++){

                //表示当前的这个硬币最多可以用多少个
                //多重背包 和一维的区别就在这里 需要考虑当前这个i选不同个数对应的情况
                dp[i][j] = dp[i-1][j];
                int num = j / coins[i-1];
                for(int k = 1; k <= num;k++){
                    if(j - coins[i-1] >= 0) {
                        dp[i][j] += dp[i - 1][j - k*coins[i - 1]];
                    }
                }

                //这是错的
//                int num = j / coins[i-1];
//                for(int k = 0; k <= num;k++){
//                    if(j - coins[i-1] >= 0) {
//                        dp[i][j] += dp[i - 1][j - k*coins[i - 1]];
//                    }
//                }
                return dp[N][V];

            }
        }

        //最后的方案数字怎么找
        return dp[N][V];
    }

    /**
     * 一维优化
     */

    public  static int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        //定义数组的维度是 体积数 还有考虑体积是0
        int[]f = new int[m+1];
        //凑出0元 只有一种方案 就是一个硬币都不选
        f[0] = 1;
        //从前往后枚举每一个硬币 再从小到大枚举所有的体积
        for(int c : coins){
            for(int j = c ;j <=m ;j++){
                f[j] += f[j-c];
            }
        }
        return f[m];
    }

    /**
     * 终极优化版本
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        //定义数组的维度是 体积数 还有考虑体积是0
        int[]f = new int[m+1];
        //凑出0元 只有一种方案 就是一个硬币都不选
        f[0] = 1;
        //从前往后枚举每一个硬币 再从小到大枚举所有的体积
        for(int c : coins){
            for(int j = c ;j <=m ;j++){
                f[j] += f[j-c];
            }
        }
        return f[m];
    }
}
