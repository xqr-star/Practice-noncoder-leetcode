package tencent;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //这个数字除了一和它本身以外还至少有一对因子
        while (count > 0){
            int num = scanner.nextInt();
            int res = help(num);
            System.out.println(res);
            count--;
        }
    }

    /**
     * 你得保证找到的这两个数字 枚举的那个数字在+1 就不可以整除
     * @param num
     * @return
     */
    private static int help(int num) {
        int res = Integer.MAX_VALUE;
        int cur = 0;
        int i = num+1;
        /**
         * 相差的因子至少为 num 不一定相差的一定是num
         */
        while (true){
            int temp = i + num;
            cur = i * temp;
            if(valid(cur,i)){
                res = Math.min(res,cur);
                break;
            }
            i = i+1;
        }
        return res;
    }

    private static boolean valid(int cur, int i) {
        //cur 不能被 1- i 之间的任何一个数字整除
        for(int j = 2;j<i;j++){
            if(cur % j == 0) return false;
        }
        return true;
    }
}
