package day10.binarySearch;

/**
 * 二分查找 以及变形
 *
 * 如果数组中包含了重复的元素
 * 搜索元素的上下界问题
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,5,5,5,5,9};
        int key = 5;
        System.out.println(theLowerRange(arr, 5));
        System.out.println(theHigherRange(arr, 5));
    }

    //如果一定能找到元素的时候求下边界-- 就是第一次出现的
    private static int theLowerRange(int[] arr,int key) {
        int left = 0;
        int right = arr.length-1;
        int mid =0 ;
        while (left <= right){
            mid = (left+right)/2;
            if (arr[mid] >= key){ //如果是大于等于的状态都需要一直缩小right边界
                right = mid-1;
            }else {
                //mid值比key小
                left = mid+1;
            }
        }
        return left;
        //最后跳出前的一步是left = right = mid 之后继续往下执行
        //跳出循环的时候，无法判断是由什么原因跳出
        //但如果存在，那么一定可以肯定的是left的位置就是它的第一个出现位置
        // 然后出界结束循环，所有left就是最后一个位置
    }

    //求上边界--就是最后一次出现的
    private static int theHigherRange(int[] arr,int key) {
        int left = 0;
        int right = arr.length-1;
        int mid =0 ;
        while (left <= right){
            mid = (left+right)/2;
            if (arr[mid] <= key){ //如果是小于等于的状态都需要一直扩大left边界
              left = mid+1;
            }else {
                //mid的值比目标设置大
                right = mid-1;
            }
        }
        return right;
        //跳出前最后一步是这样进去的left = right = mid 之后继续往下执行
        //因为这个目标元素是在数组中一定存在的，注意这个条件
        //不一定是执行第一个逻辑之后跳出循环，也有可能是第二个
        //但是返回right 一定是对的
        //那么此时right 的位置就是需要找寻的上边界
    }


}
