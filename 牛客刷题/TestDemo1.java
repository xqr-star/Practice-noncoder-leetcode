package Day3;

import java.util.Deque;
import java.util.LinkedList;

public class TestDemo1 {

    public boolean chkParenthesis(String A, int n) {
        //利用栈的特性进行
        char[] arr = A.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        //数组的长度是 arr.length 字符串是str.length()
        for( int i = 0 ; i < n ;i++ ) {
            if(arr[i] =='(') {
                stack.push(arr[i]);
            }
            //现在要进行出栈的操作
            else if( arr[i] == ')' ) {
                if(!stack.isEmpty())  stack.pop();//栈不为空 且是左括号就放进去
                else {
                    return false;
                }
            }
            /**
             * 为什么这里不进行else if(!stack.isEmpty()&&arr[i] == ')' ) 的写法
             */
//            else if(!stack.isEmpty()&& arr[i] ==  ')' ){
//                //进来说明栈不空 并且遇到了右括号那么进行出栈操作
//                stack.pop();
//                //但是处理不了的逻辑  栈是空的遇到了右括号说明不匹配
//                //程序要返回false 不然这个逻辑跳过去
//                // 后面也没有push 东西进去栈空会当成true 处理
//            }

        }
        return stack.isEmpty();
    }
}
