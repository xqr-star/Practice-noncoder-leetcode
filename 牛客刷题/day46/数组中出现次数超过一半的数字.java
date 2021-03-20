package day46;

import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    //这个代码的bug没有调试出来
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2}; // 奇数
        int[] arr2 = new int[]{2,2,2,4,5,6};//偶数
        System.out.println(MoreThanHalfNum_Solution3(arr));
    }

    /**
     * 其实和下面不一样的地方就是
     * 还是基于快速排序的思想 只不过是
     * 如果数组是有序的并且又超过一半的数组，那么排序之后
     * 数组中间的那个元素就是我们要找的
     * 现在我们做的是把这个元素找到
     * 然后左右展开搜索
     * @param array
     * @return
     */

    private static int MoreThanHalfNum_Solution3(int[] array) {
        int half = array.length/2;
        int index = quickSort2(array,half,0,array.length-1);
        //然后开始以index 为基准向前检索元素的个数
        //因为我可以确保index之前的是一定小于等于它的
        int count = 0;
        int key  =array[index];
        count ++;
        //更换一种搜索的方式
        int left = index-1;
        int right = index+1;
        while (left >= 0){
            if(array[left] == key){
                count++;
                left--;
            }else {
                break;
            }

        }
        while (right <= array.length-1){
            if(array[right] == key){
                count++;
                right++;
            }else {
                break;
            }

        }
        if(count > half ){
            return key;
        }
        return 0;
    }

    private static int quickSort2(int[] array, int half, int left, int right) {
        //使用hover的挖坑法进行排序
        int index = partition(array,left,right);

        //要写一个不断递归的过程--这里的递归的过程写的有问题
        //在你不去判断index之前，这个index之前的值肯定是 <= index的
        //如果这个index的值刚好等一它之前的值
        //就会出现问题
        if(index > half){
            return quickSort2(array, half, left, index - 1);
        }else if (index < half) {
            return  quickSort2(array,half,index+1,right);
        } else {
            //可以停止递归
            return index;
        }
    }


    //基于选择排序的思想
    //把2当作基准
    //比  <= 2的放在前面 >2的放在后面
    //但是这个写法真的好差劲
    //因为在index  > half的时候不能盲目的去缩小边界。
    public static int MoreThanHalfNum_Solution2(int [] array) {
        int half = array.length/2;
        int index = quickSort(array,half,0,array.length-1);
        //然后开始以index 为基准向前检索元素的个数
        //因为我可以确保index之前的是一定小于等于它的
        int count = 0;
        int key  =array[index];
        for(int i = index; i >= 0;i--){
            if(array[i] == key){
                count++;
            }
        }
        if(count > half ){
            return array[index];
        }
        return 0;
    }

    //闭区间
    private static int quickSort(int[] array, int half, int left, int right) {
        //使用hover的挖坑法进行排序
        int index = partition(array,left,right);

        //要写一个不断递归的过程--这里的递归的过程写的有问题
        //在你不去判断index之前，这个index之前的值肯定是 <= index的
        //如果这个index的值刚好等一它之前的值
        //就会出现问题

        if(index > half){
            //这里不能盲目的进行缩小区间的做法
            //事实上这里就应该开始去检索了
            int count = 0;
            int key  =array[index];
            for(int i = index; i >= 0;i--){
                if(array[i] == key){
                    count++;
                }
            }
            if(count > half ){
                return index;
            } else{
                return quickSort(array, half, left, index - 1);
            }
        }else if (index < half) {
           return  quickSort(array,half,index+1,right);
        } else {
            //可以停止递归
            return index;
        }
    }


    private static int partition(int[] array, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        int key = array[left];
        while (left < right){
            while (left < right && array[right] > key){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= key){
                left++;
            }
            array[right] = array[left];
        }
        //相等时候填充数字进去
        array[left] = key;
        return left;
    }







    //hash解决
    public static int MoreThanHalfNum_Solution(int [] array) {
        //使用HashMap来进行计数统计
        HashMap<Integer, Integer> map = new HashMap<>();
        //是否区分奇数偶数的情况？
        int half = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() > half) {
                return mapEntry.getKey();
            }
        }
        return 0;
    }

}
