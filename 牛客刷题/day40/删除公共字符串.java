package day40;

import java.util.HashSet;
import java.util.Scanner;

public class 删除公共字符串 {
    //整体替换
    //使用的是正则表达式
    //字符串的正则表达是是加上l[]
    //replaceAll的第一个参数是正则表达式
    //也就是可以匹配到s1字符串中所有的正则表达的内容，并且将他们替换成空
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern =  "[" + s2 + "]";
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        String removeStr = sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        //set中添加字符方便查找
        for(int i = 0;i < str.length();i++){
            set.add(str.charAt(i));
        }
        //遍历需要删除的字符
        for(int i = 0; i< removeStr.length();i++){
            char ch = removeStr.charAt(i);
            if ( set.contains(ch)){
                continue;
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
