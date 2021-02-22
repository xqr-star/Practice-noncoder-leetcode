package Stack;

//225. 用队列实现栈

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {


    /**
     *
     如果无脑的加入
    public int pop() {
        //出队列的时候要小心
        for (int i = 0; i < queue.size() - 1; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }
        return queue.remove();
     }


    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            Integer e = queue.remove();
            queue.add(e);
        }
        Integer e = queue.remove();
        queue.add(e);
        return e;
    }


    /**
     * 这是在add上面下功夫
     */
    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i = 0;i<queue.size()-1;i++){
            Integer e = queue.remove();
            queue.add(e);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();

    }
    //如果合并在add上面下功夫
    //然后直接再push和pop上面简单的话，也是会有问题的
    //比如 21
    //我先看一下队首 是2 但是你的实现是又重新添加add那么就出问题了
    //应该是用自己的push 把前面的元素再次反转
    /** Get the top element. */
    public int top() {
        Integer e = queue.remove();
        push(e);
        return e;
//        Integer e = queue.remove();
//        queue.add(e);
//        return e;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
