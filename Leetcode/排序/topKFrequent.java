package PriorityQueue;

import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        int[] arr =new int[]{1,2};
        int [] res = topKFrequent3(arr,2);
        System.out.println(Arrays.toString(res));
    }

    //区别于前k大的元素


    /**
     * 记得就是泛型里面也可以传数组
     *
     * 首先是建立一个出现的元素和出现的数组之间的关系映射
     * 然后就是找到这个出现的次数的数组里面数字最大的前k个
     *
     * 可以使用堆排序  也可以使用基于快排的排序
     * 排序的对象是基于二维数组的
     * 这个题没有想到的地方 就是 堆里面存放的是一个数组 然后按照数组的第二个元素进行建堆的排序
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //后面的做法其实就是找出前k大的元素   那么就可以使用堆 或者基于快速排序的思想
        //对上面建立的hash的数组进行排序 堆里面存放的元素是一个数组


        //建立一个小根堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });


        //然后开始遍历每一个的hash 往堆里面添加元素的操作
        // 优先级队列本质上还是一个数组  只是这里的数组的元素是 一个数组
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(priorityQueue.size() < k){
                priorityQueue.offer(new int[]{key,value});
            }else if(value > priorityQueue.peek()[1]){
                priorityQueue.remove();
                priorityQueue.offer(new int[]{key,value});
            }else {
            }
        }
        //最后对这个map进行选择k个输出
        int[] res = new int[k];
        for(int i = 0; i <k;i++){
            res[i] = priorityQueue.poll()[0];
        }
        return res;


    }

    /**
     * 这个题做的我也太艰辛了
     * 快排的思想
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //借助map完成hash表的映射关系
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //由于排序的操作不能直接对map操作 所以需要把键值对的关系转换为数组
        ArrayList<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            list.add(new int[]{key,value});
        }

        //对list 里面的每一个数组的 value 来进行许选择排序
       int index =  quickSort(list,0,list.size()-1,k);

        //最后对这个map进行选择k个输出
        int[] res = new int[k];
        for(int i = 0; i < k;i++){
            res[i] = list.get(index+i)[0];
        }
        return res;

    }

    //使用闭区间的方式来做
    private static int quickSort(ArrayList<int[]> list, int start, int end, int k) {
        int pivot = list.get(start)[1];
        int partIndex = partition(list,pivot,start,end);
        if(partIndex == list.size()- k){ // 前面出现的个数是list.size()- k个
            return partIndex;
        }else if(partIndex < list.size()- k){
            return quickSort(list,partIndex+1,end,k);
        }else {
            return quickSort(list,start,partIndex-1,k);
        }
    }

    private static int partition(ArrayList<int[]> list,int pivot, int start, int end) {
        int tempKey = list.get(start)[0];
        int tempValue = list.get(start)[1];
        while (start  < end){
            while (start < end && list.get(end)[1] > tempValue){
                end--;
            }
            swap(list,start,end);
            while (start < end && list.get(start)[1] <= tempValue){
                start++;
            }
            swap(list,end,start);
        }
        list.get(start)[0] = tempKey;
        list.get(start)[1] = tempValue;
        return start;
    }

    private static void swap(ArrayList<int[]> list, int start, int end) {
        int endKey = list.get(end)[0];
        int endValue =  list.get(end)[1];
        list.get(start)[0] = endKey;
        list.get(start)[1] = endValue;
    }

    //用快排把这个map 进行一个排序 map可以进行排序吗








    /**
     * error
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        //暴力法 建立一个hash表产生映射关系
        //然后对映射出来的这个数组进行建堆的操作
        /**
         * 还有一个就是 如果懒得转换下标 处理边界 就多开辟一个数组的大小
         */
        int length = nums.length;
        int[] arr = new int[length];
        for(int i = 0; i< length;i++){
            arr[nums[i]-1] =  arr[nums[i]-1]+1;
        }

        //建立小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1 - o2;
            }
        });
        //保证堆的数量控制在k个
        for (int value : arr) {
            if (queue.size() < k){
                queue.add(value);
            }else if(queue.peek() < value){
                queue.remove();
                queue.add(value);
            }else {

            }
        }

        //但是这样的做法把下标的关系给破坏掉了 -- 既然这样的哈希表的实现无法做到，那么使用
        //哈希表的其他实现带有键值对的做法
        int[] res = new int[k];
        int i = 0;
        for(int e:queue){
            res[i++] = e;
        }
        return res;

    }
}
