package tencent;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//新表达式计算
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Deque<String> stack = new LinkedList<>();
        Deque<String> stack2= new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i < str.length();i++){
            if(str.charAt(i) == '@'){
                if(!sb.toString().equals("")){
                    stack.push(sb.toString());
                    sb.delete(0, sb.length());
                }

                int temp1 = Integer.parseInt(stack.pop());
                i = i+1;
                //然后继续找下一个数字
                while (i < str.length() && str.charAt(i) >='0' && str.charAt(i) <= '9') {
                    sb.append(str.charAt(i));
                    i = i+1;
                }
                int temp2 = Integer.parseInt(sb.toString());
                sb.delete(0,sb.length());


                int res = temp1| (temp1+temp2);
                String temp = Integer.toString(res);
                stack.push(temp);
                i = i-1;
            }else {
                // char = toString
                if(str.charAt(i) <'0' || str.charAt(i) > '9'){

                    if(sb.toString().equals("")){
                        stack.push(String.valueOf(str.charAt(i)));
                    }else {
                        stack.push(sb.toString());
                        stack.push(String.valueOf(str.charAt(i)));
                        sb.delete(0, sb.length());
                    }
                }else {
                    sb.append(str.charAt(i));
                }

            }
        }
        stack.push(sb.toString());


        //先处理一遍 除了@ 全部进栈
        while (stack.size() > 1){
            while (stack.size() != 0) {
                String temp = stack.pop();
                if (temp.equals("x")) {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack2.pop());
                    int res = num1 * num2;
                    stack2.push(String.valueOf(res));
                }else {
                    stack2.push(temp);
                }
            }
        }

        while (stack2.size() > 1){
            String temp = stack2.pop();
            if(temp.equals("+")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack2.pop());
                int res = num1 + num2;
                stack.push(String.valueOf(res));
            }else {
                stack.push(temp);
            }
        }

        if(stack.size() == 0) {
            System.out.println(stack2.pop());
        }else{
            System.out.println(stack.pop());
        }
    }
}
