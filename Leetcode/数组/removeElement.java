package day2;

import java.util.ArrayList;
import java.util.List;

public class removeElement {
    public static void main(String[] args) {
        int [] arr= {3,2,2,3};
        System.out.println(removeElement(arr, 3));
    }

    /**
     * 两个指针，一个从前走一个只想最后一个
     * @param
     * @param val
     */

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // 根本都没有去指向交换的逻辑 只是单纯赋值，一定后面的是啥不管
                //反正每赋值一次就一定是找到了一个val
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static int removeElement2(int[] nums, int val) {
        //左右交换的方法
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            while(left <= right && nums[left] != val){
                left++;
            }//跳出循环说明left所指向的位置是val
            while(left <= right && nums[right] == val){
                right--;
            }
            //这个判断一定不能少，无法控制到底跳出循环因为什么条件
            if(left <= right){
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return left;
    }


    /*
    下面的做法是错误的
     */
    public static int removeElement1(int[] nums, int val) {
        //想要用ArrayList
        List<Integer> list = new ArrayList<>();
        for(int e : nums){
            list.add(e);
        }
        int count = 0;

        for(int i =0 ; i < list.size();i++){
            if(nums[i] == val) { //这样的做法一定会跳过很多元素没有处理，因为你删除了元素，元素的下标就一定会动态的重新变化
                //所以不可采取此种做法
                list.remove(nums[i]);
                list.add(nums[i]);//尾插进去
                count++;
            }

        }

        return list.size()-count;
    }

}
