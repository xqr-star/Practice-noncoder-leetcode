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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        //把各种想要的物品的体积放到一个数组里面
        for(int i = 0 ;i < n; i++) {
            arr[i] = sc.nextInt();
        }

        public static int count(int i,int sum,int[]arr) {
            if(sum==0) return 1;
            if(i==n||sum<0) return 0;
            return count(i+1,sum-arr[i],arr)+count(i+1,sum,arr);
        }

        System.out.println(count);

    }

    //采用递归思想
    //N 代表还剩余的体积数
    //arr[i] 代表 检索到第i 个物品
    //返回值代表不同的选择物品的方式的数目。


//    本题采用递归思想：
// ①物品n个，物品体积逐一放入a[100]中
//②递归函数count(i,sum)=count(i+1,sum-a[i])+count(i+1,sum);
//    其中，i为第i个物品，sum代表剩余空缺体积数
//    count(i+1,sum-a[i]) 代表从第i+1个物品开始，剩余体积数为sum-a[i]的方案数
//（隐含：已经将a[i]的体积计算进去，即包含a[i]的体积）
//    count(i+1,sum) 代表从第i+1个物品开始，剩余体积数为sum的方案数
//（隐含：不将a[i]的体积计算进去，即不包含a[i]的体积）

    int count(int i,int sum){   //递归函数
        if(sum==0) return 1;
        if(i==n||sum<0) return 0;
        return count(i+1,sum-a[i])+count(i+1,sum);
    }
    int main(){
        while(scanf("%d",&n)!=EOF){
            for(int i=0;i<n;i++)   scanf("%d",&a[i]);
            printf("%d",count(0,40));
        }
        return 0;
    }



}

