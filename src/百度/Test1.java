package 百度;

import java.util.Scanner;

//容易等级

/**
 * Kimi的英语老师是一个非常有趣的人。
 * 每一次考试之前她都会在不经意间透露一下试题的难度，
 * 她会在黑板上写一串长长的字符。
 * 你需要从这串字符中按照次序找到E或e、A或a、S或s、Y或y这四个字母，
 * 每四个字母为一组，将构成一个大家熟悉的单词（easy）。
 * 每找到一组字母，即构成一个单词easy则容易等级加1。
 * 当然，容易等级越大就意味着考试题目越容易，
 * 所以Kimi希望能够从中找到最多的字母组合。
 * 值得注意的是如果有多于一个easy，
 * 每一个easy都需要按照次序出现，
 * 也就是说下一个easy中的“e”必须在前一个easy中的“y”之后出现。
 * 你能否编写一个程序告诉Kimi这次英语考试的容易等级是多少呢？
 * abcdesAssayEaaaassYyy
 * 样例输出
 * 2
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.trim();

        char[] arr = str.toCharArray();

        //使用滚动机的状态
        String flag = "0";
        int count = 0;
        for(char ch :arr) {
            switch (flag){
                case "0":
                    if(ch == 'E'|| ch =='e'){
                        flag = "e";
                    }
                    break;
                case "e":
                    if(ch == 'A'|| ch =='a'){
                        flag = "a";
                    }
                    break;
                case "a":
                    if(ch == 'S'|| ch =='s'){
                        flag = "s";
                    }
                    break;
                case "s":
                    if(ch == 'Y'|| ch =='y'){
                        count++;
                        flag = "0";
                    }
                    break;
                default:break;
            }
        }

        System.out.println(count);
    }
}
