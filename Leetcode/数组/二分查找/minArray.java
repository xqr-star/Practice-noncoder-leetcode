package array;

import java.util.Arrays;

//剑指 Offer 11. 旋转数组的最小数字
//154. 寻找旋转排序数组中的最小值 II
//153. 寻找旋转排序数组中的最小值的变形题
//输入一个递增排序的数组的一个旋转
//允许数组出现重复

/**
 * 本题的解题思路：暴力+二分
 * 使用二分查找的两个关键因素
 * 1.顺序存储  只有顺序存储才可以通过下标来获取的对应的元素
 * 2.元素需要有序  （原因 ： 任取一个关键字的值 就可以确定 所要寻找的关键字的值的位置是在它的左边还是右边）
 *
 * 第一步确定用谁和谁比较：
 *  left 和 mid 进行比较无法对区间进行缩小
 *  虽然两个的mid 都比 left大，但是无法确定最小值应该在哪一个区间里面
 *  3 4 5 1 2
 *  1 2 3 4 5
 * 但是用mid 和right 进行比较就可以对区间进行缩小
 *
 * 第二步讨论单纯的只使用二分查找：
 * 那么到底可以不可以单纯的只使用二分查找 就要看是否满足上面的条件
 * 此时仍然没有办法确定到底是在左边还是右边
 * 示例
 * mid == right
 * 所以采用暴力的方法，也就是让right向左挪动一个
 * 4 3 4 4 4
 * 4 4 4 3 4
 * 以第一个数据为例 变成了
 * 4 3 4 4 这样的数据就可以使用二分查找确定在哪一个区间里面进行搜索了
 * 所以确定了使用暴力+二分
 *
 * 第三步分析可能产生的结果：
 * 为数组中允许重复元素的出现 所以mid 和 right 的比较结果可能产生三种情况
 * mid > right 那么说明中间中间出现了分界点，所以对右区间进行搜索，所以left= mid+1
 * mid < right 那么着之间肯定是依次递增，所以对左区间进行搜索，但是不知道mid是不是最小的 ,right = mid 而不是 right = mid-1
 * mid == right 是一个特殊情况 那么就使用暴力的办法 把right向左挪动一个 right -- 即可！
 *
 *
 */
public class minArray {
    public static void main(String[] args) {
        int[] arr = new int[] {10,1,10,10,10};
        System.out.println(minArray4(arr));
    }


    /**
     * 正确代码
     * @param numbers
     * @return
     */
    public static int minArray5(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        while (left < right){ //二分的模板
            mid = left+(right -left)/2;
            if(numbers[mid] > numbers[right]){
                left = mid+1;
            }else if(numbers[mid] == numbers[right]){
                right--;
            }else { //numbers[mid] < numbers[right]
                 right = mid;
            }
        }
        //最后相遇的时候就是找到了
        return numbers[left];
    }
    /**
     * error
     * 这里出错的地方就是 不能用 left 和 mid 进行比较
     * @param numbers
     * @return
     */
    public static int minArray4(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        while (left < right){
            mid = left+(right-left)/2;
            if(numbers[left] < numbers[right]){
                return numbers[left];
            }else {
                if(numbers[left] < numbers[mid]){ //中间有重复的元素，所以就算是相等了也不可以跳过
                    left = mid+1;
                }else{
                    right = mid;
                }
            }


        }
        //left == right 的时候处理的情况
        return numbers[left];

    }

    /**
     * 和153题的区别就是此题是会出现可重复元素的
     * 不通过的测试用例 3,1,3
     * 关键是如何处理等号的问题
     * 以及涉及到
     * @param numbers
     * @return
     */

    public static int minArray3(int[] numbers) {
        /**
         * 二分查找解决此问题
         **/
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        while(numbers[left] >= numbers[right]){
            //如果外层不写等号 313 这个判断是进不去的
            //如果写了等号 left right mid 指向同一个元素的时候，还是没有办法跳出循
            //会出现数组越界的问题
            mid = left + (right - left) /2;
            if(numbers[left] > numbers[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return numbers[left];

    }



    //测试用例没有通过 1，3，5
    //3,4,5,1,2
    //不是说所有的数据都是旋转的 或者也可以理解问一个135的递增数组 经过3次旋转达到的效果
    //351 513 135
    public static int minArray2(int[] numbers) {
        int lowIndex = 0;
        int fastIndex = 0;
        //因为一定存在这样的元素，所以不用考虑太多
        //所以跳出的时候一定是找到了 第一个比它小的元素
        while(numbers[lowIndex] <= numbers[fastIndex] && fastIndex < numbers.length){
            fastIndex++;
        }
        return numbers[fastIndex];
    }

    //暴力解法
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }


}
