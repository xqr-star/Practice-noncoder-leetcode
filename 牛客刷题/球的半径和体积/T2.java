package day34;

import java.util.Scanner;

public class T2 {
    /**
     * 注意一下计算公式！！ 注意小数除法 4/3.0
     * 以及注意以下在使用分数的时候，要注意int/int 不会变成小小数的问题
     * @param args
     */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();

            double R = Math.sqrt(Math.pow(x1-x0,2)+Math.pow(y1-y0,2)+Math.pow(z1-z0,2));
            double V =4/3.0 * Math.acos(-1)*Math.pow(R,3);

            //保留三位小数
            System.out.printf("%.3f %.3f",R,V);
        }
    }
}
