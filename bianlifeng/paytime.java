import java.util.Scanner;

//在便利店中顾客的结账时间是很重要的指标。结账时间由排队等待时间，和顾客操作付款时间两部分组成。
//
//程序输入为顾客列表 customers，每一位顾客 customer[i] 包含两个数值 arriveTime, payDuration。
//
//arriveTime 表示顾客挑选完商品去结账的时刻；
//
//payDuration 表示顾客操作付款的时间。
//
//请计算所有顾客的总结账时间。
//
//
//
//输入描述
//第一行：总顾客数
//
//剩余行：每位顾客的 arriveTime, payDuration。
//
//如：
//3
//1,2
//2,5
//4,3
//第一位顾客在时刻 1 到达，付款耗时 2。结账时间为 2；
//第二位顾客在时刻 2 到达，等待顾客 1 结账完成，在时刻 3 开始付款，付款耗时 5。结账时间为 6； 等待时间是1 结账时间5 1+ 5 = 6
//第三位顾客在时刻 4 到达，等待顾客 2 结账完成，结账时间为 7； 时刻8开始结账 等待时间是4 付款耗时3 结账时间7
//共计 2 + 6 + 7 = 15。

//每一行的数据按照 arriveTime 递增顺序排列。如果两位顾客 arriveTime 相同，排在前面的顾客先结账。
//
//最终输出结果不超过 2^31 - 1；arriveTime 取值范围为 [1, 2^63 - 1] 间的正整数；payDuration 取值范围为 [1, 2^31 - 1] 间的正整数。
public class paytime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //顾客的总数
        int number = sc.nextInt();
        sc.nextLine();
        //表示前一个顾客是否结账完成
        //每一个顾客要结账 耗时 ： （开始结账的时刻 - 到达的时刻） + 付款耗时

        int[][] arr= new int[number][2];
        for (int i = 0; i< number;i++){
            String str = sc.nextLine();
            String[] date = str.split(",");
            for(int j = 0; j < 2;j++){
                arr[i][j] = Integer.parseInt(date[j]);
            }
        }
        int time = 1;
        int now = 1; //表示当前的时刻
//        boolean flag = false; //表示是否有客人在结账
        int wait = 0;

        int sum = 0;
        for(int i = 0; i< number;i++){
            //这是第一个客人的结账时间
            //客人达到的时刻的等于当前时刻
            if(now ==arr[i][0] ) {
                sum += arr[i][1];
                now += arr[i][1]; //更新当前时刻
            }else if(now  > arr[i][0]){ //也就是当前的时刻 比客人到达的时刻要大
                wait = now - arr[i][0];
                sum = sum +  wait + arr[i][1];
                now += arr[i][1];//更新当前时刻
            }else { //当前时刻小于客人到达的时刻
                now = arr[i][0];//更新当前时刻
                sum += arr[i][1];
                now += arr[i][1];//再次更新
            }
        }
        System.out.println(sum);
    }
}
