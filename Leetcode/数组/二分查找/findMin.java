package array;

//153. 寻找旋转排序数组中的最小值
//二分查找的变种
public class findMin {
    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1};
        System.out.println(findMin(arr));
    }
    /**
     * 如果数组没有翻转，那么arr[left] <= arr[right]
     * 那么久返回arr[left]
     *
     * 若 nums[left] <= nums[mid]，
     * 说明区间 [left,mid] 连续递增，
     * 则最小元素一定不在这个区间里，可以直接排除。因此，令 left = mid+1，在 [mid+1,right] 继续查找
     *
     *
     * 如果上述情况不成立，说明数组不连续，那么最小元素一定在这个区间里面
     *
     * 跳出的条件就是arr[left] <= arr[right]
     * 测试用例 312 没有通过
     *
     * @param nums
     * @return
     */
    //这是别人的正确写法
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right){
            mid = left+(right-left)/2; // 这样的写法是为了防止数据的溢出
            if(nums[mid] > nums[left]) {
                left = mid+1;
            }else {
                //说明是连续递增的
                right = mid;
            }
        }
        return nums[left];
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (nums[left] > nums[right]){
            mid = left+(right-left)/2; // 这样的写法是为了防止数据的溢出
            if(nums[mid] >= nums[left]) {
                left = mid+1;
            }else {
                //说明是连续递增的
                right = mid-1;
            }

        }
        return nums[left];
    }
}
