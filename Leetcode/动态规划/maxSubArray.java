package Leetcode;

//53. 最大子序和

/**
 * 求出所有子段的和的最大值
 *
 * 1.状态表示
 *
 *  集合 f[i]  表示所有以i结尾的字段
 *  属性 max min 数量
 *
 * 2.状态计算（状态转移）
 * f[i]  = max(f[i-1] ,0) + nums[i]
 *
 * 用 last表示 f[i-1]
 *
 *
 *
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE; //表示需要返回的值
        int last = 0; //记录上一次的last f[i-1] 初始肯定是0

        for (int i = 0; i< nums.length;i++){
            //为什么写的是last 和 0 又可能这个数字之前没有上一个
            int now = Math.max(last,0)+nums[i];
            //看看最大值是否需要变化
            res = Math.max(res,now);
            //更新一下上一次的数据
            last = now;
        }
        return res;
    }
}
