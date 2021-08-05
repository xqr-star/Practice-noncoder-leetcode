package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//15. 三数之和
public class threeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        threeSum(arr);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        //判定特例
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        //排序+双指针
        int left = 0;
        int right = 0;
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            target = -nums[i];
//            List<Integer> temp = new LinkedList<>();
//            temp.add(nums[i]);
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                //同一个组里面可能出出现相同的
                if (nums[left] + nums[right] == target) {

                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));

//                    temp.add(nums[left]);
//                    temp.add(nums[right]);
//                    res.add(new LinkedList<>(temp));
//                    temp.remove(1);
//                    temp.remove(1);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1] && right+1 < nums.length && nums[right] == nums[right+1]) {
                        left++;
                        right--;
                    }



//                    while (left < right && nums[left] == nums[left-1]){
//                        left++;
//                    }
//                    while (left < right && nums[right] == nums[right-1]){
//                        right--;
//                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            //删除当前的所有元素
//            temp.clear();
        }
        return res;
    }


    // 如果是三个0的处理结果没有放进去
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        //排序+双指针
        int left = 0;
        int right = 0;
        int target = 0;
        for (int i = 0; i < nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            target = -nums[i];
            List<Integer> temp = new LinkedList<>();
            temp.add(nums[i]);
            left = i+1;
            right = nums.length-1;
            while (left < right){
                //同一个组里面可能出出现相同的

                if(nums[left] + nums[right] == target){
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(new LinkedList<>(temp));
                    temp.remove(1);
                    temp.remove(1);
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }

                // 0 0 0 2 2

                while (left < right && nums[left] == nums[left-1] && right+1 < nums.length && nums[right] == nums[right+1]) {
                    left++;
                    right--;
                }

            }
            //删除当前的所有元素
            temp.clear();
        }
        return res;

    }
}
