package day10.binarySearch;


/**
 * 找出数组中第一个大于目标元素的索引和
 * 数组中第一个小于目标元素的索引
 */


public class FirstBiggerAndFirstLetter {
    /**
     * 找出数组中第一个大于目标元素的值
     * 目标元素在数组中：那么就是它后面(这里的它是它的上界)的第一个
     * 目标元素不在数组中： 数组内部分大于它 那么就是大于它的第一个
     *                   数组内全部大于它 那么就是数组的第一个
     *                   数组全部小于它  返回-1
     */
    public static int firstBiggerNum(int[] arr,int key){
        int left =0;
        int right = arr.length-1;
        int mid = 0;
        while (left <= right){
            if(arr[mid] <= key){  //如果存在要找它的上边界，所以和前面的写法一样
                left = mid+1;//小于等于的处理逻辑还是不变的 因为即使等于也不能确定是等于的后一个数字
            }else if(arr[mid] > key) { //如果目标ke在数组中，但是它的前一个没有
                if (arr[mid - 1] <= key || mid == 0) {  //还要考虑如果数组中所有元素都比他大，那么返回第一个元素
                    return mid;
                }
                right = mid - 1;
            }
        }
        //如果上面都没有结束 就说明没有找到也就是所有的元素都比目标元素小
        return -1;
    }

    /**
     * 找出数组中第一个小于于目标元素的值
     * 目标元素在数组中：那么就是它前面(这里的它是它的下界)的第一个
     * 目标元素不在数组中： 数组内部分小于它 那么就是小于于它的第一个
     *                   数组内全部小于它 那么就是数组的最后一个
     *                   数组全部大于它  返回-1
     */
    public static int firstLetterNum(int[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left <= right){
            //就算是找到了目标元素还是要不断的向下缩小边界
            if(arr[mid] >= key ){
                right = mid - 1;
            }else if(arr[mid] < key){
                //如果当前小于，但是前一个大于等于，可以返回
                //判断是不是数组的最后一位
                if(arr[mid + 1] >= key || mid == right){
                    return mid;
                }
                //这里就还是正常走
                left = mid + 1;
            }
        }

        //跳出循环还没有返回的情况经过上面分析就只有一种
        //那就是数值中的元素都比它大
        return -1;
    }


/**
 * 关于这里面为什么不直接写成else 的情况
 * 主要是为了自己看程序的时候，能够好理解这里的逻辑
 */
}

