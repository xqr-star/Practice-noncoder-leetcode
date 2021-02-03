package day10;

public class searchRange {
    public static void main(String[] args) {
        int [] arr = new int[]{5,7,7,8,8,10};
        solution(arr,6);

    }

    private static int[] solution(int[] nums, int target) {
        int [] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        int count = 0;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        //从一半的位置开始前后找

        //先写一个二分查找
        while (left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                break;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        //说明没有找到
        if(left > right){
            return arr;
        }
        //跳出循环的mid 就找到了target

        //以mid 开始左搜索
        left = mid;
        right = mid;
        while (left >=0 ){
            if(nums[left]==target){
                arr[0] = left;
            }else {
                break;
            }
            left--;
        }

        //以mid开始右搜索
        while (right <= nums.length-1){
            if(nums[right] == target){
                arr[1] = right;
            }else {
                break;
            }
            right++;
        }
        return arr;

    }

    /**
     * 暴力解法
     * 特别的low
     * @param nums
     * @param target
     * @return
     */
    public static  int[] solution1(int[] nums, int target) {
       //遍历数组
        int [] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                count++;
                arr[1] = i;
            }
        }

        if(count != 0) {
            //注意这里处理数字
            //如果只有一个那么他的左右下标应该是一样的。
            arr[0] = arr[1] - count + 1;
        }
        return arr;
    }
}
