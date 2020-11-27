package code;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TestDemo1 {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();//作为主栈
        Stack<Integer> stack2 = new Stack<Integer>();//作为辅助栈

        public void push(int node) { //进栈
            stack2.push(node);
        }

        public int pop() {
            //逻辑漏洞就是 如果我现在正在出栈，然后进来一个元素，我还是把栈2 的取出来
            //压到栈1 里面，在弹出栈1 的首元素，那栈1 里面原有的元素都会被打乱顺序
            //然后出栈
            if(!stack1.isEmpty()){
                //现在要出栈不能打乱原有的栈的元素顺序
            }else{
                //如果栈1 为空的话应该怎么出栈 -- 把栈2 里面元素全部放进去
                while(!stack2.isEmpty()){
                    int temp = stack2.pop();
                    stack1.push(temp);//先把栈2 的元素去处理啊再放到栈1 里面去
                }
            }
            return stack1.pop();
        }

    }
}
