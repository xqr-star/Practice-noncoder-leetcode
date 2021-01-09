package code;

public class Robot {
    /// 题目要求走的是大格子而不是网格线的交点，所以有两种走法。
    // x 行 y 列
    public int countWays(int x, int y) {

        //如果向下走  x y-1
        //如果向右走 x-1 y-1

        //(递归的出口就是 x= 1 || y = 1 那么就没有选择走法的余地就只有1钟
        if (x == 1 || y == 1){
            return 1; // 代表没有选择
        }

        return countWays(x-1,y)+countWays(x,y-1);

    }
}
