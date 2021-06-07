import java.util.Arrays;

//473. 火柴拼正方形
public class makesquare {
    /**

     *
     * 需要先判断数组的总和能否被4整除 如果不可以被4整除那么无解
     * 如果可以被4整数 那么依次枚举 构造正方形的每一条边
     *
     *      * 首先需要拼成一个正方形 那么就需要四条边
     *      * 也就说需要在一堆的数字里面  分出四个组合
     *      * 使得四个组合的和是相等的
     *      * 不存在顺序 只要和相等就可以啦。
     *
     * 剪枝：
     * 1. 从大到小枚举所有的边
     * 枚举大边的时候，有限枚举大的值，那么对应的分支少，会有更多的搜索空间剪枝。
     * 2. 每条边内木棒的长度规定从大到小
     * 3. 如果当前木棒拼接失败，则跳过去接下来所有长度相同的木棒
     * 4. 如果当前木棒拼接失败，并且是当前边的第一个，则直接剪掉当前分支。
     * 5. 如果当前木棒拼接失败，并且是当前边的最后一个，则直接剪掉当前分支。
     *
     * @param matchsticks
     * @return
     */

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,5,5,4,4,4,4,3,3,3,3};
        System.out.println(makeSquare(arr));
    }
     static boolean[]  now  ;
    //用来记录当前的边是否被枚举过
    public  static boolean makeSquare(int[] matchsticks) {
        //第二个剪枝
        Arrays.sort(matchsticks);
        int sum = 0;
        for(int n : matchsticks){
            sum += n;
        }
        now = new boolean[matchsticks.length];
        if(sum == 0 || sum  %4 != 0) return false;
        return dfs(matchsticks,0,0,sum/4);
    }

    /**
     *
     * @param matchsticks
     * @param side   当前拼接到了第几条边
     * @param cur    当前边的长度
     * @param length 这条边应该的长度
     * @return
     */
    private  static boolean dfs(int[] matchsticks, int side , int cur , int length) {

        //只有拼接好了以后 才可以接着往后枚举下一条边
        if(cur == length) {
//            return dfs(matchsticks,side+1,0,length);
            side++;
            cur = 0;
        }
        if(side == 4 ) {
            //说明所有的边都拼接完了
            return true;
        }

        //依次枚举 从大边到小边枚举 第一个剪枝
        for(int i = matchsticks.length-1;i >= 0;i--){


            /*if(!now[i] && matchsticks[i] + cur <=  length ){ //当前的边没有被用过
                //如果当前边的长度大于边长度的要求限制 那么直接剪枝
                // if(matchsticks[i] + cur > length) return false;

                now[i] = true;
                //如果当前的结果是true 那么就可以返回了
                if(dfs(matchsticks,side,cur+matchsticks[i],length)) return true;

                //如果不是需要恢复现场
                now[i] = false;
                //同时表示的是当前的木棒拼接失败 第一个和最后一个 也要剪枝
                if(cur == 0) return false;
                if(cur + matchsticks[i] == length) return false;

                //如果当前木棒拼接失败，那么跳过和他长度相同的木棒 第5给剪枝
                while (i - 1  >= 0 && matchsticks[i] == matchsticks[i-1]) i--;

            }
            */

            if(!now[i]){ //当前的边没有被用过
                //如果当前边的长度大于边长度的要求限制 那么直接剪枝
                if(matchsticks[i] + cur > length) return false;

                now[i] = true;
                //如果当前的结果是true 那么就可以返回了
                if(dfs(matchsticks,side,cur+matchsticks[i],length)) return true;

                //如果不是需要恢复现场
                now[i] = false;
                //同时表示的是当前的木棒拼接失败 第一个和最后一个 也要剪枝
                if(cur == 0) return false;
                if(cur + matchsticks[i] == length) return false;

                //如果当前木棒拼接失败，那么跳过和他长度相同的木棒 第5给剪枝
                while (i - 1  >= 0 && matchsticks[i] == matchsticks[i-1]) i--;

            }
        }
        return false;
    }
}
