package array;

import java.util.Arrays;
import java.util.PriorityQueue;

//215. 数组中的第K个最大元素
public class findKthLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        findKthLargest2(arr,4);
    }

    /**
     * 使用jdk自带的排序来做
     * 然后遍历数组拿到倒数第k个
     * 数组的排序中小规模的排序使用的是插入排序
     * 大规模的是使用快排
     * @param nums
     * @param k
     * @return
     */
    public  static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];

    }
    /**
     * JDK的优先级队列中使用的是小堆
     * 如果要找的是第k个最大的，那么实际上就可以
     * 倒着去寻找第k个
     * 由于k总是有效的，所以不需要多考虑什么
     * 数组的元素个数是arr.length 要获取的是倒数第k个
     * 前面需要删除的是arr.length- k 然后再获取堆顶的元素
     * 堆并不能做到有序性，只能做上一层和这一层的关系，无法保证一层里面的关系
     * 所以如果使用建立小堆的方式是做不到的
     * 必须建立大堆，一旦建立大堆，就需要考虑到自己实现的问题
     *
     * 优先级队列，虽然看起来是二叉树的结构，但是本质上是一个数组的结构
     *
     * 错误解法，不应该采用
     * */
    public  static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i< nums.length;i++){
            queue.add(nums[i]);
        }
        for(int i = 0;i <= nums.length -k;i++){
            queue.remove();
        }
        return queue.remove();
    }
}
