package day06;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class reverseOnlyLetters {
    /**
     * 主要是学习api 以及栈的利用
     * @param args
     */
    public static void main(String[] args) {
        solution("?6C40E");
    }
    public  static String solution(String S) {
        Stack<Character> stack = new Stack();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))  //判断是不是字母 是字母金放进栈里面
                stack.push(c);
        }

        StringBuilder res = new StringBuilder();
        for(char ch : S.toCharArray()){
            if(Character.isLetter(ch)){
                res.append(stack.pop()); //如果遇到了字母那么就让栈里面的元素处出来
            }else {
                res.append(ch);
            }
        }

        return  res.toString();


    
    }

   
    /*
    投机取巧
    但是思路是差不多，只是api不知道
     */

  
    public  static String solution2(String S) {
        //利用栈来颠倒顺序

        //现在的问题是怎么才能让符号的位置固定住
        //全部转换成数组
        //然后new一个新的数组 先把所有的元素设置成0 然后
        //同时遍历两个数组，先把不是字字母的字符放到数组里面去

        char[] arr = S.toCharArray();
        char[] res = new char[arr.length];//初始化的时候默认是null
        for(int i=0 ;i <res.length;i++){
            res[i] = '\\';//  不能把这个数组初始话为0但是如果本身就有0的话就会出问题的
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0;i < arr.length;i++){
           if( !((arr[i]>='a'&& arr[i] <='z')  || (arr[i]>='A'&& arr[i] <='Z') )){
               res[i] = arr[i];
           }else {
               stack.push(arr[i]);
           }
        }

        //然后将栈里面的元素再放放到结果数组中
        for(int j =0 ;j <res.length;j++){
            if(res[j] =='\\' ){
                res[j] = stack.pop();
            }
        }
        return new String(res);

    }
}
