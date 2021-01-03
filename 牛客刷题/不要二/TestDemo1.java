package code;

import java.util.Scanner;
//不要二
public class TestDemo1 {

    public static int deal1(int r, int c) { // c 是行
        int n = 0;
        if (r % 4 == 0 || c % 4 == 0) {
            n = r * c / 2;
        }//如果能整除4 那么蛋糕个数为网格个数的一半
        else {
            n = r * c / 2 + 1;
        }//不能被4整除 将蛋糕每隔一个空放一个 可以放多少 奇数的一半+1
        return n;
    }


    public static int deal2(int r,int c) { // c 是行
        int temp = c / 4;  // 表示一共有多少个4 行
        int count = 0; // 表示蛋糕的个数
        int y = c % 4; // 表示余数
        int 前两行规律 = (r / 4) * 2 + (r % 4 < 2 ? r%4 : 2);
        int 后两行规律 = (r / 4) * 2 + (r % 4 < 2 ? 0 : r%4 - 2);

        count = temp * (前两行规律 + 后两行规律) * 2;
        if (y == 0) {
            return count;
        }
        if (y == 1) {
            return count += 前两行规律;
        }
        if (y == 2) {
            return count += (前两行规律 * 2);
        }
        else{ // (y == 3)
            return count = count +(前两行规律 * 2)+ 后两行规律;
        }
    }





    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int r = sc.nextInt(); // 表示长  -- 对应的是列
            int c = sc.nextInt(); // 表示宽 -- 对应的是行
            //int res = deal1(r, c);
            int res = deal2(r, c);
            System.out.println(res);
        }
    }

        /**
         * 错误原因：题意理解错误！
         * 下面解法的错误是 不是说距离 00 位置的距离是二 是距离每一个蛋糕的距离都不能是二
         * @param args
         */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();//(0-h-1)
        int h = sc.nextInt();//(0-w-1)
        double distance = 0;  // 欧氏距离算出来的肯定有小数，你给人家的数值类型变成整型，咋弄？不认真啊
        int count = 1 ;//用来对能满足欧几里得的网格进行计数
        for(int i = 0;i < h;i++){
            for(int j = 0 ;j <w;j++) {
                distance =  Math.sqrt((i)*(i)+(j)*(j));//它直接从i 的位置开始走，会跳过i 前面的数字
                if (distance > 0 && distance <2) {
                    count++;
                } else if (distance > 2) {
                    count++;
                }
            }
        }
        System.out.println(count);


    }*/

}
