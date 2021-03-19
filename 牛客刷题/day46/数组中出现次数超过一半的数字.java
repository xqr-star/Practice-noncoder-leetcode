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

    //它返回的下表是 表示start
    //比如以第一个数字作为基准 它返回的就是 index = 1
    //而我的返回的index = 0
    public static int MoreThanHalfNum_Solution3(int [] array) {
        if(array.length<=0)
            return 0;

        int start = 0;
        int length = array.length;
        int end  = length-1;
        int middle = length>>1;

        int index = Partition(array,start,end);


        while(index!=middle){

            if(index>middle){
                index = Partition(array,start,index-1);
            }
            else{
                index = Partition(array,index+1,end);
            }
        }
        int result = array[middle];

        int times = 0;
        for(int i=0;i<length;++i){
            if(array[i] == result)
                times++;
        }
        if(times*2<length){
            System.out.println(times);
            return 0;
        }else{
            return result;
        }
    }
    public  static int Partition(int[] array,int start,int end){

        int flag = array[start];

        while(start<end){
            while(array[end]>flag){
                end--;
            }
            swap(array,start,end);
            while(array[start]<=flag){
                start++;
            }
            swap(array,start,end);
        }
        return start;
    }
    public static void swap(int[] array,int num1,int num2){
        int temp =array[num1];
        array[num1] =array[num2];
        array[num2] =temp;
    }




    //基于选择排序的思想
    //把2当作基准
    //比  <= 2的放在前面 >2的放在后面
    public static int MoreThanHalfNum_Solution2(int [] array) {
        int half = array.length/2;
        int index = quickSort(array,half,0,array.length-1);
        //然后开始以index 为基准向前检索元素的个数
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
            return quickSort(array,half,left,index-1);
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
