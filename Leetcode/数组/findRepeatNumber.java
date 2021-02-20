package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//剑指 Offer 03. 数组中重复的数字
public class findRepeatNumber {

    /**
     * 原地置换的算法
     * @param nums
     * @return
     */
    //题目明确说明了数组长度为n，范围为 n-1
    // 也就是若无重复元素排序后下标0123对应的数字就应该是0123；
    //采用萝卜和坑的原地置换的方法
    //要注意交换用的是while，也就是0号坑只有拿到0号萝卜，1号坑才能开始找自己的萝卜。

    public int solution3(int[] nums) {
        //遍历数组
        int temp;
        for(int i =0;i < nums.length;i++){
            while (i != nums[i]) { // 说明拿到的不是自己的对应的元素
                //要一直去找这个坑应该有的萝卜
                int changeIndex = nums[i];
                if(nums[i] == nums[changeIndex]) return nums[i];
                //不相等就先交换
                temp = nums[i];
                nums[i] = nums[changeIndex];
                nums[changeIndex] = temp;
            }
        }
        return -1;

    }

    /**
     * set 如果已经出现过那么返回值是null
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        //遍历数组，如果之前的值已经在里面出现过了，就返回这个值
        Set<Integer> set = new HashSet<>();
        boolean flag = true;
        for(int i =0;i <nums.length;i++){
            //set添加重复元素的时候返回的是false
            flag = set.add(nums[i]);
            if(flag == false){
                return nums[i];
            }
        }
        return -1;
    }

    //对数组排序的时间复杂度+遍历的时间复杂度
    //所以性能不加

    public int solution1(int[] nums) {
        //首先对数组进行排序
        Arrays.sort(nums);
        int low = 0;
        int fast = 1;//一定不会越界，题上说有重复的
        while(fast < nums.length){
            if(nums[low] == nums[fast]){
                break;
            }else{
                low = fast;
                fast++;
            }
        }
        //因为一定可以找到，所以一定是因为找到跳出的循环
        return nums[low];

    }
}
