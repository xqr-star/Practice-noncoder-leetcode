
//剑指 Offer57.和为s的两个数字
public class twoSum {


    /**
     * 思路二：要找两个数字和为target 那么首先找到target的大概位置
     * 之后定义两个双指针进行搜索
     */

    public int[] twoSum(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = binarySearch(nums,target);

        while (leftIndex < rightIndex){
            if(nums[leftIndex] + nums[rightIndex] == target){
                return new int[]{nums[leftIndex],nums[rightIndex]};
            }
            if(nums[leftIndex] + nums[rightIndex] < target){
                leftIndex++;
            }else {
                rightIndex--;
            }
        }
        return new int[2];

    }




    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right){
            mid = (left + right+1)/2;
            if(nums[mid] < target){
                left =mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    //常规思路：用哈希表存储已经遍历过的数字 然后遍历到当前数字的时候
    //在哈希表种查找之前是否遍历过 target - num即可
}
