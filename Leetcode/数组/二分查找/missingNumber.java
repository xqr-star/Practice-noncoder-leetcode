package array;

//剑指 Offer 53 - II. 0～n-1中缺失的数字
public class missingNumber {
    /**
     * 排序数组中的搜索问题，首先想到 二分法 解决
     * 查找第一个和下标不匹配的元素
     * 数组被划分成两部分
     * 左边的是arr[i] == i
     * 右边的是arr[i] != i
     */
    public int missingNumber2(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int middle = 0;
        while (leftIndex <= rightIndex){
            middle = (leftIndex+rightIndex)/2;
            if(nums[middle] == middle){
                leftIndex = middle+1;
            }else { //只有不等于的情况 这里就不用讨论大于小于的问题了全部合并
                rightIndex = middle-1;
            }
        }
        return leftIndex;

    }
    /**
     * 暴力法，第一个和下标不一样的数字是谁，就返回对应的下标
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int i =0;
        for(;i < nums.length;i++){
            if(nums[i] != i){
                break;
            }
        }
        //如果遍历完没有找到也要返回之后的i
        //题目的意思是如果数组没有缺失的值，就返回后一个所以这个成立
        return i;

    }
}
