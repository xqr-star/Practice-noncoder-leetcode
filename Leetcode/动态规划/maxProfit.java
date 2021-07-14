package 数组;

//121. 买卖股票的最佳时机
public class maxProfit {
//    public static void main(String[] args) {
//        int[] arr = new int[]{2,4,1};
//        maxProfit(arr);
//
//        int max = 0;
//        for(int i = 0; i< prices.length;i++){
//            for(int j = i+1; j < prices.length;j++){
//                int sub = prices[j]-prices[i];
//                if(sub > max){
//                    max = sub;
//                }
//            }
//        }
//        return max;
//
//
//
//    }


    /**
     * 一维数组优化
     *
     * 空间优化 降低维度 只看状态转移方程
     *
     * 下标为 i 行的并且状态是 0 的只参考上一行的 状态0 和1 的行
     * 下标为 i 行的并且状态是 1 的只参考了上一行状态为1 的行
     */


    public static int maxProfit3(int[] prices) {

        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        //只表示两种状态  0 不持股  1 持股
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = -prices[0];

        for(int i = 1 ;i < len;i++){
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[1],-prices[i]);
        }

        return dp[0];

    }
    /**
     * 空间优化 滚动数组
     * 由于只依赖上一天的状态 所以使用滚动数组 优化
     */


    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[2][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];


        for(int i =1 ;i < len;i++){
            dp[i%2][0] = Math.max(dp[i-1&1][0],dp[i-1&1][1]+prices[i]);

            //这里不可以写dp[0][0]因为滚动的原因一直在变化
            //dp[i%2][1] = Math.max(dp[(i-1)&1][1],dp[0][0]-prices[i]);
            dp[i%2][1] = Math.max(dp[i-1&1][1],dp[0][0]-prices[i]);
        }

        return dp[len-1&1][0];

    }

    /**
     * dp[i][j]  下标为i的这一天，手上的持股状态j 我们的拥有的现金数量
     *
     * j = 0 不持股
     * j = 1 持股
     *
     * 时间和空间复杂度 都是 o(n）
     *
     * @param prices
     * @return
     */

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        maxProfit(arr);
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        //因为这里负数的设置就可以保证  卖出的价格一定比买入的大  而不会出现只找差值最大的情况
        dp[0][1] = -prices[0];

        for(int i = 1 ; i < len;i++){

            //第i不持股 -- 如何做到只买一次 - 做到只卖一次就可以啦！
            // 这里dp[i - 1][1] + prices[i]为什么能保证卖了一次，
            // 因为下面一行代码买的时候已经保证了只买一次，所以这里自然就保证了只卖一次，
            // 不管是只允许交易一次还是允许交易多次，这行代码都不用变，
            // 因为只要保证只买一次（保证了只卖一次）或者买多次（保证了可以卖多次）即可。
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            //为什么不是这么写的呢？
            //第i天持股
            //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，
            //  这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，
            //  所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            //
            // 如果题目允许交易多次，就说明可以从直接从昨天的未持股状态变为今天的持股状态，
            // 因为昨天未持股状态可以代表之前买过又卖过后的状态，也就是之前交易过多次后的状态。也就是下面的代码。
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
        }

        //返回最后一天 不持股的状态
        return dp[len-1][0];



    }

    /**
     * 状态定义 dp[i] 表示第i天卖出股票可以获得的最大利益
     * 状态转移
     * dp[i] =
     *    num[i] <num[i-1]
     *    dp[i-1] + num[i-1] - num[i]
     *
     *    num[i] >= num[i-1]
     *    dp[i] = dp[i-1]
     * @param prices
     * @return
     */


    public static int maxProfit1(int[] prices) {
        //获取最大利润无非就是要找到那一天的数字最大 那一天的数字最小
        //暴力遍历法
        //获取最大利润无非就是要找到那一天的数字最大 那一天的数字最小
        //暴力遍历法
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 0; i< prices.length; i++){
            if(prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
            if(prices[i] < prices[minIndex]){
                minIndex = i;
            }
            //这里比较的是下标的关系
            if( maxIndex < minIndex){
                maxIndex = i;
            }
        }
        return prices[maxIndex] - prices[minIndex];
    }

    /**
     * 想用动规 但是没有写出来！
     * @param prices
     * @return
     */

}


