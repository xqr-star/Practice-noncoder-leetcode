package Stack;
//622. 设计循环队列

/**
 * 什么是循环队列
 * 对数组的空间进行循环利用
 * 把数组前面的元素取出来以后，是否要把后面的元素往前搬运？
 * 如果搬运的话，效率很低
 * 如果不搬运，可用的空间会变少
 * 所以循环队列就可以做到 下次再次插入的的时候，从空的位置插入
 * 做法就是 不搬运元素+循环的机制
 *
 * 对象里面需要有的东西
 * 一个数组 数组里面元素个数
 * 队首的下标
 * 队尾的下标
 */
public class MyCircularQueue {
    private int[] arr ;
    private int size;
    private int frontIndex;
    private int rearIndex;
    public MyCircularQueue(int k) {
        arr = new int[k];

    }

    //插入到循环队列中，失败返回false（失败就是容量满了）
    //往队列里面插入元素，移动的应该是队尾的下标
    public boolean enQueue(int value) {
        if(size == arr.length) return false;
        arr[rearIndex++] = value;
        rearIndex = rearIndex%(arr.length);//处理下标越界的情况
        size++;
        return true;
    }

    //出队列
    //只有出队列的时候，才移动队首的下标
    public boolean deQueue() {
        if(size == 0) return false;
        frontIndex++;
        frontIndex = frontIndex%(arr.length);
        size--;
        return true;
    }

    //获得队首的元素，如果队列为空返回-1
    public int Front() {
        if(size == 0)return -1;
        return arr[frontIndex];
    }


    //返回队尾元素，如果为空返回-1
    //理论的位置是在arr[rearIndex- 1]的位置
    //但是数组的下标判断
    public int Rear() {
        if (size == 0) return -1;
        if(rearIndex == 0){
            return arr[arr.length-1];
        }
        return arr[rearIndex-1];

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
