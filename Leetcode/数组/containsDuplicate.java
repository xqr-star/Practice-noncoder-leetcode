package day05.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(soulution(nums));
    }

    /*
    排序后查看相邻元素是否相同
     */
    public  static boolean soulution2(int[] nums) {
        Arrays.sort(nums);
        for(int i =0 ;i < nums.length-1;i ++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;

    }

    /*
    set去重后比较 size 和之前的length
     */
    public  static boolean soulution(int[] nums) {
        //比较去重后的长度和之前的长度是否一样
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            set.add(e);
        }
        return !(set.size() == nums.length);

    }
}
