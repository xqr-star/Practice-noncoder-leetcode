package array;

import java.util.HashMap;

//560. 和为K的子数组
public class subarraySum {

    /**
     * 方法二： 前缀和+哈希表优化
     *
     * 方法一效率不高的地方在于 对于每一个i 都要枚举出来所有的j来判断是否符合条件
     * 这样性能不加  可以优化
     *
     * 什么叫做前缀和  也就是用一个hash表来保存当前遍历到的下标之前所有元素的和
     * pre[i] 表示的是 以i结尾的子数组的和
     * 这个hashmap里面就放的是一个个的前缀和
     *
     *
     * 那么要找i结尾的  不确定是j  [i,j]的和为k
     * 就是要找 pre[j-1] == pre[i] - k
     *
     * 那么要找
     * [j .. i] 这个子数组的和为k 条件可以转换成
     * 当前遍历到的这个元素 它的前缀里面有没有出现值是 pre[i] - k
     * 以及它的出现次数
     *
     */

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int pre = 0;  //表示遍历到的当前数组之前的所有子数组的和
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1); //这里不懂为什么一定要put （0，1）-- 因为有pre - k = 0的情况
        for(int i = 0;i < nums.length;i++){  // 还是相当于是以i作为一个定点进行处理
            pre += nums[i];
            if(hashMap.containsKey(pre-k)){
                count += hashMap.get(pre-k);
            }
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);
        }
        return count;
    }





    /**
     * 方法一 ： 枚举
     * 由于两边的数组都是变动的 如果让两边的数组同时变动的话 不好考虑这个问题
     * 所以采用先定一 再 动 一的做法、
     * 然后整体的外层循环时 动那个确定的一
     * 这里用的方法 主要是后缀和的方法
     *
     *
     *
     * 拿到这个题 左右两个下标都要进行变动 不太好做
     * 当你确定一个下标不动 另一个下标去变动的时候就会比较好做一点
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //外层循环保证了定一
        //也就是说查找所有的以i结尾的，但是开头不确定的子数组是否能满足和为k

        for(int i = 0;i < nums.length;i++){
            int sum = 0;
            for(int j = i;j >= 0;j--){ // 这里是移动的 倒着进行查找
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
