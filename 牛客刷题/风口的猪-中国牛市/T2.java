package day35;

public class T2 {
    //风口的猪 -- 中国牛市
    //动态算法--设置状态转移方程 //dp

    //但是下面写的这一种不知道算不算，把区间分成两个部分

    //把区间划分为两部分，然后分别求最大收益
    //[3,8,5,1,7,8]
    //3 买入 8 卖出 1买入8卖出 挣12
    //但是这个的时间复杂度真的是很堪忧！
    public int calculateMax(int[] prices) {
        if(prices == null || prices.length <2) return 0;
        int sum = 0;
        for(int i =1;i< prices.length;i++){
            int temp = getMax(prices,0,i)+getMax(prices,i+1,prices.length-1);
            if(temp > sum) sum = temp;
        }
        return sum;
    }


    //[left,right]
    //[3,8] [5,1,7,8]
    private int getMax(int[] prices, int left, int right) {
        //处理数组越界的情况
        //因为i遍历的是数组里面的每一个，但是i+1 当i是最后一个的时候，就会越界
        if(left >= prices.length) return  0;
        int min = prices[left];
        int res = 0;
        for(int i = left+1;i <= right;i++){
            min = Math.min(prices[i],min);
            res = Math.max(res,prices[i]-min);
        }
        return res;
    }
}
