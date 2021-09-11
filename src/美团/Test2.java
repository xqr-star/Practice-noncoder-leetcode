package 美团;

import java.util.Scanner;

//交换 --18%
//小美所在的城市有很多地铁站，地铁站之间由线路直接连接，组成了一个地铁网络。一天她突发奇想，把若干个地铁站的编号依次进行交换。请问在所有的交换结束之后，每个编号指向的地铁站直接相连接的地铁站一共有多少个？
//
//两个地铁站之间可能有多条线路直接连接。但是不存在直接指向自己的线路。
//
//
//
//输入描述
//第一行三个数字n,m,q(1≤n,m,q≤105)，分别代表地铁站数量，直接连接的地铁路数量，交换数量。
//
//接下来m行每行两个数字u,v(1≤u,v≤n)代表直接连接的两个地铁站编号。
//
//接下来q行每行两个数字x,y(1≤x,y≤n)代表你要交换的两个点编号。
//
//数字间均有空格隔开
//
//输出描述
//一行n个空格隔开的数字，每个数字代表与对应编号直接相连的地铁站一共多少个。
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//地铁站的数量
        int m = scanner.nextInt();//直接相连的数量
        int q = scanner.nextInt();//交换结点的数量
        scanner.nextLine();
        int[] arr = new int[m+1];

        int num1 = 0;
        int num2 = 0;
        //处理直接相连的
        for(int i = 0; i < m;i++){
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            scanner.nextLine();
            arr[num1]  += 1;
            arr[num2] += 1;
        }

        //处理交换的
        for(int i = 0; i < q;i++){
             num1 = scanner.nextInt();
             num2 = scanner.nextInt();
             scanner.nextLine();
             int temp = arr[num2];
             arr[num2] = arr[num1];
             arr[num1] = temp;
        }
        for(int i = 1; i <= m;i++){
            System.out.print(arr[i] + " ");
        }

    }
}
