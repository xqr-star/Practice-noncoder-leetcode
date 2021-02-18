package day12;

import java.util.Deque;
import java.util.LinkedList;

//150. 逆波兰表达式求值
public class evalRPN {

    /**
     * 但是你是怎么想到用栈整个数据结构的呢？
     * 利用栈来进行操作
     * 如果是数字进栈
     * 是符号一下出栈两个元素，然后将计算的结果压入栈中
     *
     * @param tokens
     * @return
     */
    public int solution(String[] tokens) {
        //从前往后遍历数组
        //如果是数字进栈
        //如果是符号，那么栈不等于空 才可以出栈，但是因为他说肯定是有效的，所以就不判断了
        //出栈一次出两个 用第二个出的和第一个做运算
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;//用来保存运算结果
        for(int i = 0; i< tokens.length;i++){
            if(tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }else if(tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push( b-a);//注意顺序
            }else if(tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);//这里需要注意顺序！
            }else {
                int temp = Integer.parseInt(tokens[i]);
                stack.push(temp);
            }
        }
        //在这里取之前一定可以确保栈不为空
        return stack.pop();

    }
}
