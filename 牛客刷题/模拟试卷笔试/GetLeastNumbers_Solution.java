package 模拟笔试试卷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution1(arr,4);
    }


    /**
     * 找出其中最小的k个数字
     *
     * 解题思路，对前k个数字进行建大堆的操作
     * 由于jdk的默认实现的堆是一个小堆，所以构建优先级队列的，需要传入一个比较器进去
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }
        //它的构造方法是 优先级队列的容量是k 然后再传入一个比较器进去
        //这样就可以做到是一个建立大堆的操作

        //这种写法就是一个牛逼
        //Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0;i < input.length;i++){
            if(heap.size() < k){
                heap.offer(input[i]);
            }else {
                if(heap.peek() > input[i]){
                    heap.remove();
                    heap.offer(input[i]);
                }
            }
        }
        //这里不能写head的size因为是在不断变化的
        for(int i = 0;i < k;i++){
            list.add(heap.remove());
        }

        return list;
    }

    /**
     * 这是一种垃圾的算法
     * 特殊的情况
     * 1.由于数组是一个引用，如果引用的指向是空
     * 2.k的数字考虑 如果k是一个负数 或者k比数组的大小还要大
     * 如果K>数组的长度，那么返回一个空的数组
     * 为什么这个代码没有过的原因就是一些特殊的情况是没有考虑到的
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }

        Arrays.sort(input);
        for(int i =0;i< k;i++){
            list.add(input[i]);
        }
        return list;
    }

}
