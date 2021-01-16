package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //处理组数
        for(int i = 0;i < num;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            //用链表的方式解决
            //数据导入
            List<Integer>  list = new LinkedList<Integer> ();
           for(int j =0 ;j <2*n;j++){
               list.add(sc.nextInt());
            }

            shuffle(list,n,k);
           //数据输出
           for(int m = 0; m <list.size();m++){
               System.out.print(m == list.size()-1?list.get(m):list.get(m) +" ");
           }
            System.out.println();

        }

    }

    private static void shuffle(List<Integer> list, int n ,int k) {
        while (k >0 ){
            int left = 1;
            //处理洗牌的核心逻辑
            for(int i = n;i < list.size()-1;i++){
                int num = list.remove(i);
                list.add(left,num);
                left = left+2;
            }

            k--;
        }
    }
}
