package day34;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        //全部转换为大写
        String typedStr = sc.nextLine().toUpperCase();//输入
        String actStr  = sc.nextLine().toUpperCase();//输出
        //使用set去重--其实这一步有没有都可以
        //把输出的数据放到一个set里面 方便查找提高效率
        Set<Character> actSet = new TreeSet<>();//实际输出
        for(char ch : actStr.toCharArray()){
            actSet.add(ch);
        }

        //再用一个set存放已经输出过这个坏的的键盘
        Set<Character> hasUes = new TreeSet<>();
        for(char ch : typedStr.toCharArray()){
            //遍历所有的元素，看看在输出的里面是否包含
            if(!actSet.contains(ch)&& !hasUes.contains(ch)){//如果实际输出的字符里面不包含
                hasUes.add(ch);//并且已经输出过的集合里面也没有那么就
                System.out.print(ch);//那么输出并且加入输出的集合
            }

        }
        System.out.println();

    }

}
