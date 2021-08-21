package 度小满;

import java.util.HashMap;
import java.util.Scanner;

/***
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小A成为了一名粉刷匠！某次他去工作时，他得到了n个不同颜色的颜料桶。这些颜料都是来自某一家专门生产神奇颜料的公司的，一共有m  种颜色混合规则，
 * 每一条规则都是两种颜色混合起来会得到一种新的颜色（
 * 两种相同的颜色混合也有可能得到不同的颜色！）。小A把这些颜料桶分别编号为1~n，现在他要往一个空桶内分别倒入k桶颜料。他想知道最后能够得到什么颜色
 5 5
 1 3 4 6 2
 2 5 5 2 3
 3 4 6 1 3
 5
 3 5 5 2 2

 3 -> 4 -> 6 -> 1 -> 3

 */
public class Test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =scanner.nextInt();
        scanner.nextLine();

        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        String[] c = scanner.nextLine().split(" ");

        HashMap<String,String> map = new HashMap<>(m);


        for(int i = 0; i < m;i++){
            String key = a[i]+b[i];
            map.put(key,c[i]);
        }

        int k = scanner.nextInt();
        scanner.nextLine();
        String [] o = scanner.nextLine().split(" ");

        String temp = o[0];
        for(int i = 1; i < o.length;i++){
            String hun = o[i];
            String he = temp+hun;
            temp  = map.getOrDefault(he," ");

            //颜色一模一样
            if(temp.equals(" ")){
                StringBuilder sb = new StringBuilder(he);
                he= sb.reverse().toString();
                temp  = map.getOrDefault(he," ");
            }
            if(temp.equals(" ")){
               temp = he.substring(0,1);
            }


        }

        System.out.println(Integer.parseInt(temp));



    }
}
