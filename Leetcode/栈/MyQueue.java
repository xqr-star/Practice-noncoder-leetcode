<<<<<<< HEAD
package Stack;

import java.util.Deque;
import java.util.LinkedList;

//232. 用栈实现队列
public class MyQueue {

    /** Initialize your data structure here. */
    private Deque<Integer> stack1; //准备出的
    private Deque<Integer> stack2; //有限放的

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //无脑push 全部放到栈2里面
        stack2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //首先要把栈2 里面的元素全部放到栈1里面，然后从栈1里出
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();

    }
}
=======
package Stack;

import java.util.Deque;
import java.util.LinkedList;

//232. 用栈实现队列
public class MyQueue {

    /** Initialize your data structure here. */
    private Deque<Integer> stack1; //准备出的
    private Deque<Integer> stack2; //有限放的

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //无脑push 全部放到栈2里面
        stack2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //首先要把栈2 里面的元素全部放到栈1里面，然后从栈1里出
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                Integer e = stack2.pop();
                stack1.push(e);
            }
        }
        return stack1.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();

    }
}
>>>>>>> 5c2b30d43db8758c498135a65f852414a31c98c2
