package Day4;

import java.util.Scanner;

public class TestDemo1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //要想有正确的输出，只可能对应三种情况
        //1 完全被6 整除  2 完全被8 整除  3 是6i+8j
        //程序没有通过所有的测试用例的原因就是 如果一个数字既能被6  又能被8 整除 比如24
        //应该选择最小的数值 -- 尽量少的袋数

        if(n >=6) {
            if (n % 6 == 0 && n % 8 == 0) {
                System.out.println(Math.min(n / 6, n / 8));
                return;
            } else if (n % 8 == 0) {
                System.out.println(n / 8);
                return;
            } else if (n % 6 == 0) {
                System.out.println(n / 6);
                return;
            } else {
                for (int i = 1; i < n / 8; i++) {
                    for (int j = 1; j < n / 6; j++) {
                        if (8 * i + 6 * j == n) {
                            int temp = i + j;
                            System.out.println(i);
                            System.out.println(j);
                            System.out.println(temp);

                            return;
                            //System.out.println(i+j);
                        }
                    }
//                    for (int i = 1; i < n / 6; i++) {
//                        for (int j = 1; j < n / 8; j++) {
//                            if (6 * i + 8 * j == n) {
//                                int temp = i + j;
//                                System.out.println(i);
//                                System.out.println(j);
//                                System.out.println(temp);
//
//                                return;
//                                //System.out.println(i+j);
//                            }
//                        }
                }
            }
        }
        System.out.println(-1);
    }
}
