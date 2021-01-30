package day08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 寻找第三大的数字
 * 注意数字会重复出现
 */

public class thirdMax {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        solution(nums);
    }
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        //然后记录以下当前的是地基大的数据
        int count =0 ;

        for(int j = nums.length-1 ;j > 0;j--){
            if(nums[j] != nums[j-1]){
                count++;
            }
            if(count == 3){
                return nums[j];
            }
        }
        //三个数字的时候，根本走不到最后一个
        //但是上面的循环根本判断不了第j-1 也即是最后一个没有办法执行了如果count刚好是2 那么最后一个就可以使用
        if(count == 2){
            return nums[0];
        }

        return nums[nums.length-1];

    }


    /**
     * 投机取巧
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        //要考虑数字重复的问题
        //那我先去除重复的
        Set<Integer> set = new HashSet<>();
        for(int e :nums){
            set.add(e);
        }
        // set.addAll(nums); //将集合中的元素添加倒set中去，去重
        Object[] arr = set.toArray(); //将set转换为数组
        // 它返回的数组是一个object[] 那么怎么把object[] 转换成 int[]
        Arrays.sort(arr);
         if(nums.length >= 3){
            return (int) arr[arr.length-3];
        }else{
            return (int) arr[arr.length-1];
        }

    }

}
