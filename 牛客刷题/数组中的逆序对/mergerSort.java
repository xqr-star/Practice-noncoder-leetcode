package code;

import java.util.Arrays;

public class mergerSort {

    public static void main(String[] args) {
        int [] a = new int[] {2,2,2,2,2,2,2,2};
        System.out.println(Arrays.toString(a));
        mergerInternal(a,0,a.length);
        System.out.println(Arrays.toString(a));

    }

   // [low,high)
    public static void mergerInternal(int[] a, int low, int high) {
        int length = high - low;
        //不断的对数组进行拆分的过程
        if(length <= 1) {
            return; // 表示区间里面只有一个数字
        }
        int mid = (low + high) /2 ;  // (high- low)/2;  为什么写的不是这个 // 我的下标可不从0 开始 你找 3 5 之间的mid 是怎me找
        mergerInternal(a,low,mid); // 对左边的进行拆分
        mergerInternal(a,mid,high); //对右边的进行拆分

        mergeArray(a,low,mid,high); // 不太理解合并到过程-- 递归展不开 --还老是想把它展开就很无语
    }

    // 首先把无序数组从中间分割成两个无序数组
    //在对左右的数组进行相同的分割操作

    //直到数组的长度为1

    //当数组长度到达一以后，开始对两个数组进行合并

    /**
     * 合并两个有序的数组
     * @param arr 指的是 整个无序数组  其中待排序的区间是[low,high)
     *  @param low  指的是需要以已经有序的第一个数组[low,mid)
     * @param mid
     * @param high  已经有序的第二个数组[mid,high)
     */
    public  static void mergeArray(int[] arr, int low, int mid, int high ){
        int  i = low;
        int  j = mid;
        int length = high - low;
        //需要建立一个新的数组用来存放已经排好顺序的数组//这就是额外的空间复杂度o（n) -- 不考虑递归调用栈的额外空间开销是因为两者的关系是加法，舍去大的哪一个
        int [] extra = new int[length];
        int k = 0; // k 用来控制下标 // 在数组【】 的里面实现++的方式值得学习
        // 证明两个数字的元素有没有走完
        while (i < mid && j < high) {
            if(arr[i] <= arr[j]) { // 加入等号保证稳定性
                extra[k++] = arr[i];
                i ++;
            } else { // arr[i] >= arr[j]  -- 那就先把arr[j] 放到额外的数组里面去
                extra[k++] = arr[j];
                j++;
            }
        }

        //跳出循环说明 两个里面只有有一个已经搬空了
        while (i < mid) {
            // 那就把第一个有序数组的元素都放到额外数组后面去
            extra[k++] = arr[i++];
        }
        while (j < high) {
            //那就把第二个有序数组整个放到额外数组里面去
            extra[k++] = arr[j++];
        }

        //最后保证两个有序数组  被合并到extra  里面
        //再把合并好的搬回去
        for(int t = 0;t < length; t++) {
            arr[low + t] = extra[t];
        }

    }

}
