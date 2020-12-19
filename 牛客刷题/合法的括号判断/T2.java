package code;

import java.util.Stack;

/**
 * 合法的括号判断
 */

public class T2 {
    public static void main(String[] args) {



    }
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack <Character> ();

        //首先根据n的个数判断一下 如果是奇数或者字符串A里面没有元素，那都不用进行进出栈的操作
        if(n %2 != 0 || A.length() ==0 ) {
            return false;
        }
        //说明是偶数个括号，可以进行判断
        //如果遇到左括号就进栈，遇到右括号就弹出栈顶的元素  最后只用看栈里面是否还剩下元素即可。
        char [] arr = A.toCharArray();
        //对字符串进行遍历i++
        for(int i = 0; i< arr.length; i++) {
         //循环解决不了的情况  ")))()))d",8
            if( arr[i] == '('){
                stack.push(arr[i]);
            }else {
                if(arr[i] == ')' && !stack.isEmpty()){
                    stack.pop();
                }else {
                    return false; //表示遇到了） 但是栈已经是空的
                }
            }

            //如果还有其他的元素就不对他们进行处理了。
        }
        return stack.isEmpty() ;
    }
}
