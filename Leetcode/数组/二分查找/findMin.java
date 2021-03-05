package array;

//153. 寻找旋转排序数组中的最小值
//二分查找的变种

/**
 * 相比较而言154题来说
 * 因为数据不可以出现重复的所以
 * 用mid 和 right 比较
 * 或者用 mid 和left比较都是可以做到的
 *
 * 总结以下 考虑等号合并到那一边的时候的情况
 * 因为最后要返回的是一个left 所以三个相遇的时候找到了以后，一定不可以移动left
 * 那么只能合并到右right的条件里面去
 */
public class findMin {
    public static void main(String[] args) {
        int[] arr = new int[] {3,1,2};
        System.out.println(findMin1(arr));
    }

    /**
     * 用mid和right比较
     * nums[mid] < nums[right])  说明数组是连续递增的 在左半边查找 但是mid不能被排除在外 right = mid
     * else  nums[mid] >  nums[right] 说明数组不是连续的，最小元素就在右区间里面，那么就需要在右半边查找
     * mid肯定不是最小值 left = mid +1
     * 那么等号合并到什么情况里面去 当找到的时候，一定是三指针重合
     * 假定我要返回的是left 那么left 一定在相等的时候不可以移动，所以把等号合并到不改变left的条件里面去
     *
     *
     *
     * @param nums
     * @return
     */
    public static int findMin3(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right){
            mid = left+(right-left)/2;
            if(nums[mid] <= nums[right]){ //说明数组是连续递增的 在左半边查找
                right = mid; //有可能mid是最小值，所以不能排除mid
            }else { //nums[mid] >=  nums[right]  //说明数组不是连续的，最小元素就在右区间里面，那么就需要在右半边查找
                //mid肯定不是最小值
                left = mid+1;
            }
        }
        return nums[left];//或者right都可以
    }


    /**
     * 用mid和 left比较
     * 如果 nums[left] < nums[right] 那么说明数据一定是递增的，就直接返回left指向的就可以啦
     * 如果不是 用mid和left进行比较
     * arr[mid] >= arr[left]  那么向右区间进行搜索 left = mid +1;
     * else arr[mid] < arr[left] 说明中间出现了数据的断层  那么right = mid 而不是mid -1 因为mid 不确定
     *
     *
     * 为什么会想到=合并到大于的里面 就比如 只有两个元素的时候，就很方便的去想== 应该在哪一边
     * 3 1  自然是需要到右区间进行搜索
     *
     * @param nums
     * @return
     */
    public int findMin4(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        //这种写法一定不会存在下标越界的问题，主要是因为数据的特殊性
        while (nums[left] > nums[right]){
            mid = left+(right-left)/2; // 这样的写法是为了防止数据的溢出
            if(nums[mid] >= nums[left]) { //说明该数组是来连续递增的
                left = mid+1; //在这种情况下mid可以被排除
            }else {
                //说明数组不是连续递增的
                right = mid; //错误点在这里，不可以写成right = mid - 1，因为mid不可以被排除
            }

        }
        return nums[left];
    }
    /**
     * 数字没有重复
     * 如果数组没有翻转，那么arr[left] <= arr[right]
     * 那么返回arr[left]
     *
     * 若 nums[left] <= nums[mid]，
     * 说明区间 [left,mid] 连续递增，
     * 则最小元素一定不在这个区间里，可以直接排除。因此，令 left = mid+1，在 [mid+1,right] 继续查找
     *
     *
     * 如果上述情况不成立，说明数组不连续，那么最小元素一定在这个区间里面
     * right = mid   而不是 right = mid -1 注意！！！
     * 这个区间的范围应该是[left,mid] 因为mid这个元素是无法被排除的
     *
     * 跳出的条件就是arr[left] <= arr[right]
     * 测试用例 312 没有通过
     *
     * @param nums
     * @return
     */


    /**
     * 这种写法才是严格的二分查找的一个变形
     * @param nums
     * @return
     */

    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left < right){
            mid = left+(right-left)/2;
            if(nums[left] < nums[right]){ //如果这个区间是递增的，那么直接返回left即可
                return nums[left];
            }else {
                if(nums[mid] >= nums[left]){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
        }
        return nums[left];//或者right都可以
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        //这种写法一定不会存在下标越界的问题，主要是因为数据的特殊性
        while (nums[left] > nums[right]){
                 mid = left+(right-left)/2; // 这样的写法是为了防止数据的溢出
            if(nums[mid] >= nums[left]) { //说明该数组是来连续递增的而且这个等号是不可以省略的
                left = mid+1; //在这种情况下mid可以被排除
            }else {
                //说明数组不是连续递增的
                right = mid; //错误点在这里，不可以写成right = mid - 1，因为mid不可以被排除
            }

        }
        return nums[left];
    }

    /**这是别人的正确写法--他这个写的是有问题的事实上等号是必须加上**/
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
}
