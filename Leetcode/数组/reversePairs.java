//剑指 Offer 51. 数组中的逆序对
public class reversePairs {
    /**
     * 暴力遍历
     *
     * 超时
     * @param nums
     * @return
     */

    /**
     * 归并计算
     * @param nums
     * @return
     */

    static int res = 0;

    public static void main(String[] args) {
//        int[] arr = new int[]{1,6,9,30,7,3,0,20};
//        mergeSort(arr);
//
//        int[] arr2 = new int[]{2,2,2,2,2};
//        mergeSort(arr2);
//        System.out.println(1);

        int[] arr = new int[]{7,5,6,4};
        System.out.println(reversePairs(arr));


    }
    public  static int reversePairs(int[] nums) {

        if(nums.length == 0) return res;
        mergeSort(nums);
        return  res;
    }

    private  static void mergeSort(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length-1;

        merSortInternal(nums,left,right);
    }

    private  static void merSortInternal(int[] nums, int left, int right) {
        int length = right-left+1;
        //说明划分区间已经结束了
        //递归的终止条件
        if(length == 1) return ;

        int mid = (right + left)/2 ;
        merSortInternal(nums,left,mid);
        merSortInternal(nums,mid+1,right);

        //开始对两个区间进行合并
        merge(nums,left, mid, mid+1,right);
    }

    private static void merge(int[] nums, int leftIndex, int mid , int rightIndex, int highIndex) {
        int[] newArr = new int[highIndex-leftIndex+1];

        int left = leftIndex;
        int right = rightIndex;

        int index = 0;
        while (left <= mid && right <= highIndex){
            while (left <= mid && right <= highIndex &&nums[left] <= nums[right]){
                newArr[index++] = nums[left];
                left++;
            }
            while (left <= mid && right <= highIndex && nums[left] > nums[right]){
                newArr[index++] = nums[right];
                //这里计算逆序对通过找到当前left 到mid 的个数
                res += mid-left+1;
                right++;
            }
        }
        while (left <= mid){
            newArr[index++] = nums[left];
            left++;
        }
        while (right <= highIndex){
            newArr[index++] = nums[right];
            right ++;
        }

        //源数组 数组的来源   -- 目标数组  从哪开始拷贝的个数

        System.arraycopy(newArr,0,nums,leftIndex,highIndex-leftIndex+1);


    }
}
