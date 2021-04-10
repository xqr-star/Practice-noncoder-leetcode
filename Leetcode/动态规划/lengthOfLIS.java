package Leetcode;

//300. 最长递增子序列
public class lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    /**
     * 以f[i] 表示所有以i结尾的上升子序列
     * f[i]的属性是 max 也就是说 f[i] 中存储的值是表示所有以i结尾的最长的上升子序列
     *
     * f[i]中最后一个数是确定的 但是 倒数第二个数是不确定的
     * 倒数第二个数可能不存在 也可能是以第0个数结尾的最长子序列
     * 也有可能是以第1个数结尾的最长子序列
     * 也有可能是以第2个数结尾的最长子序列
     * 也有可能是以第3个数结尾的最长子序列
     * ..........................
     * 也有可能是以第i-1个数结尾的最长子序列
     *
     *所以f[i]的状态是由 i+1 个状态中的最大值决定的
     *
     * 在这之中 假定f[g]是这些状态中最长的
     * 并且nums[g] < nums[i]
     * 那么 f[i] = f[g] + 1
     *
     * @param nums
     * @return
     */
    public  static int lengthOfLIS(int[] nums) {
        if(nums == null ){
            return 0;
        }
        int length = nums.length;
        if(length <= 1){
            return length;
        }
        int [] dp = new int[length];

        for(int i =0 ;i < length;i++){


             dp[i] = 1;
            //初始化状态 每一个数最长的子序列都是他们自己 1
            for(int j = 0;j < i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            //上面的思想等价于下面的


            //遍历所有下标小于i的dp数组
            /*dp[i] = 1;
            int max = -1; // 用来记录f[i] 状态里面最长的那个子序列的长度
            for(int j = 0 ;j <= i-1;j++){
                if(dp[j] > max && nums[j] < nums[i]){
                    max = dp[j];
                    dp[i] = dp[j] +1;
                }
            }*/


        }

        //遍历一次数组 循环最大值

        int maxLength = 1;
        for(int i = 0;i < length;i++){
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
