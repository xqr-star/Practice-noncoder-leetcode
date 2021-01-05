package CodeReview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class T1Version2 {


    public static void main(String[] args) {

        //队列模拟实现

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Deque<Integer> stack = new LinkedList<>();
        if(num < 1000){
            //将元素放入list中
            for (int j = 0; j < num; j++) {
                stack.add(j); //默认执行的是尾插
            }
        }else{
            for (int j = 0; j < 1000; j++) {
                stack.add(j); //默认执行的是尾插
            }
        }

        //0 1 2 3 4 5 6 7  8
        //0 1   3 4   6 7
        //  1   3     6 7
        //      3     6
        //            6


        //但是这个算法效率太低，创建太多的临时变量
        int temp = 0;
        while (stack.size() >1) {

            //拿出两个
            for (int i = 0; i < 2; i++) {
                temp = stack.peek();
                stack.remove(); //remove 的返回值是布尔类型不是元素
                stack.add(temp);
            }
            //删除首元素
            stack.remove();

        }
        System.out.println(stack.peek());


    }
}
