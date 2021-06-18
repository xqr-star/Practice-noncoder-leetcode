package 背包;

import java.util.*;

//多重背包问题
public class Test3 {
    //每一个物品有物品数量的限制


    /**
     * 优化一
     * 二进制优化方法
     * 如何把多重背包问题 变成一个0-1背包问题
     * 把每个物品对应的不同中选择进行一个拆分
     * 拆成对应的个数
     *
     * 但是一个一个的拆的做法 时间复杂度依旧会很高
     * 所以用二进制来拆
     *
     * 比如某一个物品的数量是 7
     * 选择什么数字可以把 7以内的数字都组合出来
     * 拆成7个1
     * 1 1 1 1 11 1 1 每一位表示
     * 所有的数字都可以被这7个1组合出来 但是用的物理空间太多了
     * 但是数字的规模太大
     * 7
     * 至少用三个数字可以表示出来 倍增思想
     * 1 2 4
     * 1 1
     * 2 2
     * 3 1+2
     * 4 4
     * 5 1+4
     * 6 2+4
     * 7 1+2+4
     * s 10
     * log(s) 上取整4
     * 1 2 4 8 但是这样表示的数字 最多是15 会多表示数字
     * 1 2 4 （这是最大的和是7 10-7 = 3） 3
     *
     *
     *
     *
     *
     */

    static class  Good{
        int V;
        int W;

        public Good(int v, int w) {
            V = v;
            W = w;
        }

        public int getV() {
            return V;
        }

        public int getW() {
            return W;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N+1];
        int[] w= new int[N+1];
        int[] l = new int[N+1];
        for(int i = 1 ;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            l[i] = sc.nextInt();//物品数量的限制
        }
        int[] f = new int[V+1];
        Deque<Good> deque = new LinkedList<>();

        //然后处理每一个物品对应的个数 把他拆成一个0-1背包的问题
        //转换成很多物品的体积价值的关系
        // 转换成不同的物品 对应不同的体积和价值
        for(int i = 1;i<= N;i++){
            //得到每一个物品的个数
            int num = l[i];
            //处理这里处理数据的方式
            for(int k = 1;k <= num;k*=2){
                num -= k;
                deque.push(new Good(k*v[i],k*w[i]));
            }
            if(num >0) deque.push(new Good(num*v[i],num*w[i]));
        }

        //0-1背包 枚举每一个物品 注意物品的数量变了!
        N = deque.size();
        for(int i = 0; i < N;i++){
            //然后从大到小枚举体积
            Good temp = deque.pop();
            for(int j = V; j >=temp.getV();j--){
                f[j] = Math.max(f[j],f[j-temp.getV()]+temp.getW());
            }
        }

        System.out.println(f[V]);

    }
    /**
     * 不能使用map这个数据结构 如果体积一样的话 会把key都一定的value改掉的
     * @param args
     */
    public static void mainerror(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N+1];
        int[] w= new int[N+1];
        int[] l = new int[N+1];
        for(int i = 1 ;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            l[i] = sc.nextInt();//物品数量的限制
        }
        int[] f = new int[V+1];
        HashMap<Integer,Integer> map = new HashMap<>();

        //然后处理每一个物品对应的个数 把他拆成一个0-1背包的问题
        //转换成很多物品的体积价值的关系
        // 转换成不同的物品 对应不同的体积和价值
        for(int i = 1;i<= N;i++){
            //得到每一个物品的个数
            int num = l[i];
            //处理这里处理数据的方式
            for(int k = 1;k <= num;k*=2){
                num -= k;
                map.put(k*v[i],k*w[i]);
            }
            if(num >0) map.put(v[i]*num,w[i]*num);
        }

        //0-1背包 枚举每一个物品 注意物品的数量变了
        for(Map.Entry<Integer,Integer> mapping : map.entrySet()){
           //然后从大到小枚举体积
            for(int j = V; j >= mapping.getKey();j--){
                f[j] =Math.max(f[j],f[j-mapping.getKey()]+mapping.getValue());
            }
        }

        System.out.println(f[V]);

    }



    /**
     * 多重背包
     * f[v] 表示 体积是v的时候背包的最大价值
     * 所有的都是0 f[v] 就是答案
     * f[0] 是0 其他是负无穷  就是 从 f[0] - f[v]找最大值
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N+1];
        int[] w= new int[N+1];
        int[] l = new int[N+1];
        for(int i = 1 ;i <= N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            l[i] = sc.nextInt();
        }


        int[] f = new int[V+1];
        for(int i = 1 ;i <= N;i++){
            //这里必须是从大到小 枚举保证没有计算过
            //而完全背包问题 之所以可以是用从小到大枚举是 没有k这个循环在里面的
            for(int j = V;j >= v[i];j--){
                f[j] = f[j];
                for(int k = 1 ;k <= l[i] && k* v[i] <= j;k++){
                    f[j] = Math.max(f[j],f[j-k*v[i]]+k*w[i]);
                }
            }
        }

        System.out.println(f[V]);
    }

}
