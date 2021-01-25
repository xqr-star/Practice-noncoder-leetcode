package day2;

/**
 * 删除有序数组中的重复项
 * 注意这个有序啊
 * 所以每次只需要和slow 数组里面的最后一个比较就好
 */
public class removeDuplicated {
    public int removeDuplicates(int[] nums) {

        /**
         * 所有处于区间【0-slow】的元素一定是不重复的
         * fast 如果和slow 最后一个元素相等 那么fast继续往后检索
         * fast 如果和slow 最后一个元素不相等 那么说明这个数组需要增加元素了
         * 那么slow+1 把fast的值赋给slow 所处的位置就好了
         */
        int slow = 0; // 所有0-slow 之间的数组元素都是不重复的

        for(int fast =0;fast < nums.length;fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;

    }


    /**
     * 优化版
     * 如果数组有序
     * 0 1 2 3 4 5 还是会把fast 的值再赋值一遍 完全没有必要
     * 所以加入一个判断
     */

    public int removeDuplicates2(int[] nums) {

        int slow = 0; // 所有0-slow 之间的数组元素都是不重复的

        for(int fast =0;fast < nums.length;fast++){
            if(nums[fast] != nums[slow]){
                if(fast - slow > 1){
                    //如fast 和 slow的间隔大于1 的话再执行赋值操作
                    //否则就是原地赋值--没有意义
                    slow++;
                    nums[slow] = nums[fast];
                }

            }
        }
        return slow+1;

    }

}
