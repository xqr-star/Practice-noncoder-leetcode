package code;

import java.util.Scanner;

public class TestDemo2 {
    /**
     * 神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，
     * 这些物品的总体积必须是40。John现在有n个想要得到的物品，
     * 每个物品的体积分别是a1，a2……an。
     * John可以从这些物品中选择一些，如果选出的物体的总体积是40，
     * 那么利用这个神奇的口袋，John就可以得到这些物品。
     * 现在的问题是，John有多少种不同的选择物品的方式。
     * @return
     */


//    本题采用递归思想：
// ①物品n个，物品体积逐一放入a[30]中
//②递归函数count(i,sum)=count(i+1,sum-a[i])+count(i+1,sum);
//    其中，i为第i个物品，sum代表剩余空缺体积数
//    count(i+1,sum-a[i]) 代表从第i+1个物品开始，剩余体积数为sum-a[i]的方案数
//（隐含：已经将a[i]的体积计算进去，即包含a[i]的体积）
//    count(i+1,sum) 代表从第i+1个物品开始，剩余体积数为sum的方案数
//（隐含：不将a[i]的体积计算进去，即不包含a[i]的体积）

    static int [] arr = new int[30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//一共有n个想要的物品

        //把各种想要的物品的体积放到一个数组里面
        for(int i = 0 ;i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 40;
        System.out.println(count(40, 0, n));


    }
    //返回值代表的是组合数字
    private static int count(int sum,int k,int n) {
        if(sum == 0) {
            return 1;  //表示找到了一种组合
        } // 这两个操作的顺序还不可以交换
        if(k >= n || sum < 0){
            return 0 ; //表示这种的组合不满足规则
        }
        return count(sum,k+1,n)+count(sum-arr[k],k+1,n);
    }

}

