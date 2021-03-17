package day44;

import java.util.Scanner;

public class 单词倒排 {
    /**
     * 数学家问题
     * 着火了 用灭火器
     * 没有着火怎么办 点一把火
     *
     * 不会正则表达式 只会用空格替换怎么办
     * 把所有的非字符串全部替换为空格
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine().trim();
            //把所有非字母的换成空格
            char[] ch = str.toCharArray();
            for(int i = 0; i < ch.length;i++){
                if( !Character.isLetter(ch[i])){
                    ch[i] = ' ';
                }
            }
            //把一个char 数组转换成一个字符串
            str = String.valueOf(ch);
            //然后用空格拆分
            String[] arr = str.trim().split(" ");
            StringBuilder sb = new StringBuilder();
            //之后从尾部开始拼接
            for(int i = arr.length-1;i >= 0;i--){
                sb.append(arr[i]).append(" ");
            }
            str = sb.toString().trim();
            System.out.println(str);
        }

    }



    /**
     * 学习正则表达式
     * @param args
     */
    public static void main1(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine().trim();
            //分割是按照所有非字母的进行分割 而不是空格
            //匹配的是所有非26个字母大小写的字符
            String[] arr = str.trim().split("[^a-zA-Z]+");
            StringBuilder sb = new StringBuilder();
            for(int i = arr.length-1;i >= 0;i--){
                sb.append(arr[i]).append(" ");
            }
            str = sb.toString().trim();
            System.out.println(str);
        }
    }
}
