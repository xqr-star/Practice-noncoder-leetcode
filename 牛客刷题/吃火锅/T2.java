import java.util.Scanner;

public class T2 {
    //吃火锅
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        //用来表示每一个城堡的能量值
        int[] arr = new int[n];
        for(int i = 0 ;i < n;i++){
            arr[i] = sc.nextInt();
        }
        //用来存储每一个道路之间的能量值

        int[] dp = new int[n];
        //dp数组用来到第n个点可以获取的最大的能量值



    }
}
