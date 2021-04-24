package Stack;

import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 09. 用两个栈实现队列
// add remove element
// offer poll peek
public class 用两个栈实现队列 {
    private Queue<Integer> stack1 = null;
    private Queue <Integer>stack2 = null;

    public 用两个栈实现队列() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack2.offer(value);
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            return stack1.poll();
        }else if(!stack2.isEmpty()){
            while(!stack2.isEmpty()){
                int temp = stack2.poll();
                stack1.offer(temp);
            }
            return stack1.poll();
        }else{
            return -1;
        }
    }
}
