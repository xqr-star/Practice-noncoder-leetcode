package DP;


public class maxProfit {


    /**
     * 买卖股票的最好时机III
     * @param prices
     * @return
     */
    public int maxProfitIII (int[] prices) {

        if(prices.length == 0) return 0;
        int[][] dp=new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i =1;i<prices.length;i++){
            //当天不持有股票 可能是前一天不持有 或者是当天卖掉了
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]+prices[i]);

            //当天持有股票可能是 前一天持有 或者是当天是第一次买入
            //一定只有0-prices[i] 才能体现出是只可以交易一次
            //如果写dp[i-1][0] 就无法确定交易了几次
            //因为上一个 dp[i-1][0]  不持有股票的状态可能是已经交易过的

            //当天持有股票 选择是当天支付的少还是 之前买入支付的少
            dp[i][1] = Math.max(dp[i-1][1],0-prices[i]);
        }

        return dp[prices.length-1][0];

    }

    /**
     * 买卖股票的最好时机II
     * @param prices
     * @return
     */

    public int maxProfitII (int[] prices) {
        if(prices.length == 0) return 0;
        int[][] dp=new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i=1;i<prices.length;i++){
            dp[i][0]=dp[i-1][0];
            //之前就持有 和 第i天买入
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            //之前就卖出了 和 当天卖出
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            //之前就已经进行第二次交易了  和 第i天进行第二次交易买入
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            //之前就已经进行第二次交易了  和 第i天进行第二次交易卖出
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }

        //关于这里为什么可以直接返回的是交易两次不持有股票的状态
        //而不是在交易一次和交易两次后不持有股票中选择最大的收益
        //暂时还不太明白
        return dp[prices.length-1][4];
    }

    /**
     * 股票交易问题一
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfitI2 (int[] prices) {
        // write code here
        if(prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i< prices.length;i++){

            //第i天未持有股票，两个可能：
            //1.在前面i-1天都持有，第i天卖掉了，卖掉价值增加。dp[1][i - 1] + prices[i - 1]
            //2.到当前为止都为未持有，维持第i-1天的结果。dp[0][i - 1]
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);


            //第i天持有股票，两个可能：
            //1.在前面i-1天都未持有，第i天买入了，总价值减少。dp[0][i - 1] - prices[i - 1]
            //2.到当前为止都为持有，维持第i-1天的结果。dp[1][i - 1]
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }

        //返回最后一天不持有股票的可以获得的最大价值
        return dp[prices.length-1][0];

    }

    /**
     * 股票交易问题一
     * 投机取巧法
     * @param prices
     * @return
     */
    public int maxProfitI (int[] prices) {
        // write code here

        int profit = 0;
        for(int i= 1;i < prices.length;i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
