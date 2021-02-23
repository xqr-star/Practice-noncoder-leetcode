<<<<<<< HEAD
package Stack;

import java.util.Deque;
import java.util.LinkedList;

//155. 最小栈
//可以迅速返回栈里面元素--时间的复杂度是o(1)

/**
 * 准备两个栈，一个栈做就是正常的元素进栈出栈
 * 另一个栈永远保存的是当前的情况下最小的元素
 * 保持两个栈具有相同的size,
 * 同进 一个进正常值 一个进当前的最小值
 * 同出
 */
public class MinStack {
    /** initialize your data structure here. */
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
       stack = new LinkedList<>();
       minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek() ){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());//相当于入栈的时候，最小栈里面入栈的是当前最小的一个元素
        }

    }

    public void pop() { // 出栈的时候要保证两个同时出栈
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}
=======
package Stack;

import java.util.Deque;
import java.util.LinkedList;

//155. 最小栈
//可以迅速返回栈里面元素--时间的复杂度是o(1)

/**
 * 准备两个栈，一个栈做就是正常的元素进栈出栈
 * 另一个栈永远保存的是当前的情况下最小的元素
 * 保持两个栈具有相同的size,
 * 同进 一个进正常值 一个进当前的最小值
 * 同出
 */
public class MinStack {
    /** initialize your data structure here. */
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
       stack = new LinkedList<>();
       minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek() ){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());//相当于入栈的时候，最小栈里面入栈的是当前最小的一个元素
        }

    }

    public void pop() { // 出栈的时候要保证两个同时出栈
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}
>>>>>>> 5c2b30d43db8758c498135a65f852414a31c98c2
