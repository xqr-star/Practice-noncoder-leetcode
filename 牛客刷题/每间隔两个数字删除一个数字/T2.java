package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 每间隔两个删除一个数字
 * 链接：https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
 * 有一个数组a[N]顺序存放0~N-1，
 * 要求每隔两个数删掉一个数，
 * 到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 */

//小tips idea ctrl+d  结束hasnext的输入
//    eclipse ctrl+z
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //处理多组数据输入
        while (sc.hasNext("0")) {
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            // ---- 处理找规律的
            //                             size =  8
            // 0  1  2  3  4  5  6  7     i        i              i         i
            //       ·        ·           2 % 8 == 2   size= 7    4 % 7 == 4     size = 6
            // `           `              6 % 6 == 0   size = 5   2 % 5 == 2     size = 4
            //     ·                ·     4 % 4 == 0   size = 3   2 % 3 == 2     size = 2
            //          ·                 4 % 3 == 0   size = 1
            //最后一个取出的       ·                                2% 1 == 0  size = 0
            //简单的整型链表
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            //list.size ()获取list 的长度
            while (list.size() > 1) {
                //每间隔两个remove一个

                // i 在里面得是一个一直有的不会一直初始化的变量
                i = (i + 2) % list.size(); // 这种做法有点强
                // 刚开始我的数字一定比来链表的长度小 那我就用这个数%
                list.remove(i); // list下标是从0 开始的。

            }
            //跳出的时候 链表的长度只有一个，取出最后一个就可以了。
            System.out.println(list.get(0));
        }
    }
}





//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            if (n > 1000) {
//                n = 999;
//            }
////            List<Integer> list = new ArrayList<Integer>();
//            for (int i = 0; i < n; i++) {
//                list.add(i);
//            }
//            int i = 0;
//            while (list.size() > 1) {
//                i = (i + 2) % list.size();
//                list.remove(i);
//            }
//            System.out.println(list.get(0));
//        }
//    }
//}
