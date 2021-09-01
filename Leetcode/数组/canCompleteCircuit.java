//134. 加油站

/**
 * 枚举加油站的起点  然后看是否可以返回加油站
 * 当前油桶里面的油是要大于等于 去往下一站的油的量
 *
 * 然后更新油 ： 当前的 减去开往下一站消耗的 以及 + 开往下一站获得的油
 */
public class canCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4,};
        int[] cost = new int[]{3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public  static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0; //表示从第一个加油站开始进行探测

        //循环继续的条件 没有枚举完所有的起点
        while (i < n){
            int sumGas = 0;//表示总共加的油
            int sumCost = 0;//表示消费的油
            int count = 0;//记录可以走过的站点数量
            while (count < n){ //退出循环的条件是走过所有的站点 也就是最多的循环次数
                int j = (i+count)%n; // 避免数组越界
                sumGas += gas[j];
                sumCost += cost[j];
                if(sumCost > sumGas){
                    break; //当前已经走到了可以走的最远的站点
                }
                count++; //这个站点是满足情况的

            }

            if(count == n){
                return i; //说明可以循环一周
            }else {
                //这里就可以跳过i - count 之间所有的点作为枚举的起点了
                // i ~ i+count 是可达的
                i = i+count +1 ;
            }
        }

        //已经枚举了所有的点作为起点 但都不满足
        return -1;
    }


    public  static int canCompleteCircuit1(int[] gas, int[] cost) {

        int length = gas.length;
        int res = 0;
        for(int i =0 ;i  <length;i++){
            res =  dfs(gas,cost,length,i,0);
            if(res == 0) return i;
        }
        return -1;

    }

    //还有几个count 个 加油点需要去枚举
    //表示的是从index 的位置开始枚举
    //还需要枚举的次数
    //sum 是油的数量
    //0 表示可以走完
    // -1 表示不可以
    private static int dfs(int[] gas, int[] cost, int count, int index,int sum) {
        if(count == 0 && sum >= 0){
            //说明枚举结束 可以返回起始的位置
            return 0;
        }

        //在这个地方获得的油
        sum += gas[index ];
        //开往下一个地方应该减去的油
        sum -= cost[index % gas.length];

        if(sum < 0) return -1;
        return dfs(gas,cost,count-1,(index+1)% gas.length,sum);

    }
}
