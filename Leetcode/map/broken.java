package map;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class broken {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //1.转换成大写方便操作
        String in = sc.nextLine().toUpperCase();//如果直接转换的话，本身并不会发生改变
        String out = sc.nextLine().toUpperCase();//所有的原理都基于我是一个String类型，本身不变

        //2.把输出的数据放到一个set里面 方便查找提高效率
        char[] arr = out.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char ch : arr){
            set.add(ch);
        }

        char[] inArr = in.toCharArray();
        //3.为了把不存的元素放进去，需要去重 --
        // 但是因为需要按照放进去的顺序进行输出所以换一种数据结构
        /*Set<Character> outSet = new LinkedHashSet<>();*/


        /*//4.遍历所有要输入的--再在对应的输出里面查找

        for(char ch : inArr){
            if( !set.contains(ch)){ //不包含就输出--大写且但是还有考虑去重的问题
                outSet.add(ch);
            }
        }

        //5.遍历set的所有元素，然后输出结果--但是要转换成大写的
        for(Character ch : outSet){
            System.out.print(ch);
        }
        System.out.println();*/


        //如果不用LinkedHashSet == 还可以怎么做
        //对第四步和第五步进行改进
        Set<Character> outSet = new LinkedHashSet<>();
        for(char ch : inArr){
            if(! (set.contains(ch) )){ //第一层if判断是否按键是坏的
                //ch 是发现的错误的
                if(!outSet.contains(ch)){ //第二层判断之前是否输出过
                    //说明ch是刚发现的错误
                    System.out.print(ch); //表示如果不包含就输出 //保证

                    //如果不包含就把他放到坏的键的set里面去
                    outSet.add(ch);
                }
            }

        }
        System.out.println();

    }
}

