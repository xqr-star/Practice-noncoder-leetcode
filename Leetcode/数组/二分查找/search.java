package array;

//剑指 Offer 53 - I. 在排序数组中查找数字 I
/**
 * 因为前几天画图研究过二分查找的变形，所以对这个题的流程还相对比较熟悉一些
 * 所以你看，所有的努力都不是白费的，不是吗？？
 * 加油吧，解淇茹，每个人都有自己的学习节奏，你要做的就是做好自己
 * 你要相信 自律一定会给你带来很多的东西的，所以别放弃好吧！
 */

public class search {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(search2(arr, 8));
    }
    /**
     * 基于二分查找的思想，做一个简单的变形
     * 二分查找 元素的上界（第一个不是target的元素）
     * 和二分查找元素的下届（同上）
     *
     */
    public static int search2(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int middleIndex = 0;
        while ( leftIndex <= rightIndex){
            middleIndex = (leftIndex+rightIndex)/2;
            //如果中间值比目标值小或者等于等去右半部分查找
            if(nums[middleIndex] <= target) {
                leftIndex = middleIndex+1;
            }else rightIndex = middleIndex-1;
        }
        //因为一定存在所以跳出的时候 rightIndex 的位置就是元素的上界
        int highIndex = rightIndex;

        leftIndex = 0;
        rightIndex = nums.length-1;
        while (leftIndex <= rightIndex){
            middleIndex = (leftIndex+rightIndex)/2;
            if(nums[middleIndex] >= target){
                rightIndex = middleIndex-1;
            }else {
                leftIndex = middleIndex+1;
            }
        }
        //跳出的时候leftIndex的位置就是下届
        int lowIndex = leftIndex;
        return highIndex- lowIndex+1;
    }


    /**
     * 基础的二分查找的方法 之后进行左右搜索
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        //首先二分查找一个数字，然后以这个下标为范围开始做左右搜索
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int count = 0;
        int middleIndex = 0;
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex+rightIndex)/2;
            if(nums[middleIndex] == target){
                count++;
                break;
            }else if(nums[middleIndex] >target){
                rightIndex = middleIndex-1;
            }else{
                leftIndex = middleIndex+1;
            }
        }
        //因为一定能找到，所以这里就不去判断找不到的情况了
        //然后重新定义左和右下标

        leftIndex = middleIndex-1;
        rightIndex = middleIndex+1;
        while(leftIndex >=0){
            if(nums[leftIndex] == target) {
                count++;
                leftIndex--;
            }
            else break;
        }
        while(rightIndex <= nums.length-1){
            if(nums[rightIndex] == target) {
                count++;
                rightIndex++;
            }
            else break;
        }
        return count;

    }

}
