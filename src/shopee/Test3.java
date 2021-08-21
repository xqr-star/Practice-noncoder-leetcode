package shopee;


//https://blog.csdn.net/u011317250/article/details/86650725
//https://testerhome.com/topics/17949%EF%BC%BD

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 这个题确实蛮难的
 */
public class Test3 {
    /**
     * 每遇到一个{  就可以代表一个深度
     * 使用栈同时进行一个统计
     * @param str
     * @return
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stack = new LinkedList<>();
        int max = stack.size();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.contains("{")){
                stack.push('{');
                max = Math.max(stack.size(),max);
            }
            if(stack.contains('}')){
                stack.pop();
            }
        }
        System.out.println(max);


    }

    /**
     *
     * 计算字符串2中的字符串1个数
     * @param args
     */
    public static void main(String[] args) {

        String str = "java";
        String  str2 = "javajava_eclipse_class_jajavavajavajdjdj";


        System.out.println(getCount(str, str2));
        method_5(str2,str);
        method_2(str2,str);
    }

    //使用模拟双指针 滑动窗口的思路
    private static int getCount(String str, String str2) {
        int count = 0;
        if(str == null) return 0;
        if(str2.length() < str.length()) return 0;
        int left = 0;
        int right = str.length()-1;
        //使用的闭区间 [left,right]
        while (right < str2.length()){
            if(str2.substring(left,right+1).equals(str)){
                count++;
            }
            left++;
            right++;
        }
        return count;
    }

    public static void method_5(String string, String a) {

        int counter = 0;
        for (int i = 0; i <= string.length() - a.length(); i++) {
            if (string.substring(i, i + a.length()).equals(a)) {
                counter++;
            }
        }
        System.out.println("方法五 ---> 个数" +counter);

    }



    //  如果含有三个子字符串 会吧数据集划分4个
    public static void method_2(String string, String a) {
        String[] array = string.split(a);
        if (array != null)
        {
            System.out.println("方法二 ---> 个数" + (array.length - 1));}
    }
}

