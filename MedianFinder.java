import java.util.Comparator;
import java.util.PriorityQueue;


//剑指offer41.求中位数
public class MedianFinder {

    PriorityQueue <Integer> queue1 = null; //小根堆
    PriorityQueue <Integer> queue2 = null; //大根堆


    public MedianFinder() {
        queue1 = new PriorityQueue<>();
         queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2-o1;
            }
        });
    }


    public void addNum(int num) {
        if(queue1.size()  == queue2.size()){ //取当前的和大根堆的堆顶里面最大的放入小根堆
            queue2.add(num);
            queue1.add(queue2.poll());
        }else { //取当前的和小根堆里最小的放入大根堆
            queue1.add(num);
            queue2.add(queue1.poll());
        }

     }

    public double findMedian() {
        if(queue1.size() == queue2.size()){
            return (queue1.peek()+queue2.peek()) /2.0;
        }
        return queue1.peek();
    }



}
