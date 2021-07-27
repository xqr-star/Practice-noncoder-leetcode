import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer 30. 包含min函数的栈
public class MinStack {

    /**
     * 残差法
     */
    Deque<Long> stack;
    long min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(long x) {
        if(stack.isEmpty()){
            min = x;
            stack.push(0l);
        }else{
            stack.push(x - min);
            // 小于min则更新
            min = x < min? x: min;
        }
    }

    public void pop() {
        //看是否需要更新min
        if(stack.peek() < 0){
            //说明需要更新一下最小值
            min = min - stack.pop();
        }else {
            stack.pop();
        }
    }

    public long top() {
        //如果当前的栈顶小于0 那么top 就是min
        if(stack.peek() < 0) {
            return  min;
        }else {
            return  stack.peek() + min;
        }
    }

    public long min() {
        return min;
    }

}

