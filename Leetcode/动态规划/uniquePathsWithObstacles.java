package lc2;

import java.util.Arrays;

//63. 不同路径 II
public class uniquePathsWithObstacles {
    /**
     * 有多少跳路径的问题 可以使用深度搜索DFS+回溯
     * 或者动态规划
     * @param obstacleGrid
     * @return
     */

    public static void main(String[] args) {
        int[][] num = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(num));
    }


    /**
     * DP 如何进行动态规划
     * 用一个二维数据 dp[i][j] 表示移动到i，j 的路径数量
     * */

    public  static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //为了少处理数组越界的问题 多开辟空间
        int[][] dp = new int[m+1][n+1];

        //初始化都数组的状态
        dp[1][1] = 1;
        if(obstacleGrid[0][0] == 1) {
            dp[1][1] = 0;
        }

        for(int i = 1; i < m+1;i++){
            for(int j = 1 ;j < n+1;j++){
                if(i == 1 && j == 1)continue;
                if(obstacleGrid[i-1][j-1] == 1) {
                    //表示如果这里是一个陷阱
                    continue;
                }
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }


    /**
     * 深度优先搜索
     * @param obstacleGrid
     * @return
     */


    static int[][] board ;
    static int m;
    static int n;
    static int[][] arr;

    public  static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        arr = obstacleGrid;
        board = new int[m][n];

        //这个填充是什么意思？？？
        for(int i = 0;i < m;i++){
            Arrays.fill(board[i],-1);
        }

        //判定特例
        if(arr[m-1][n-1] == 1){
            return 0;
        }
        if(m == 1 && n == 1) {
            return 1;
        }
        return dfs(0,0);
    }

    //我的这个dfs超时了 .....
    //如果没有使用记忆数组就会出现问题的
    //思了一下，发现我这里的写法会重复计算：
    //
    //当前节点先往右开始，不断探索到达终点，经过的路径设为path1
    //当前节点再往下开始，不断探索到达终点，经过的路径设为path2
    //path1和path2会有重复
    //

    private  static  int dfs(int i, int j) {
        //越界
        if(i >= m || j >= n) return 0 ;
        if(arr[i][j] == 1){ //这里提前剪枝说明是陷阱
            return 0;
        }
        //说明向右就可以走到了最后的终点位置
        if(i == m-1 && j== n-1){
            //表示有一条路径
            return 1;
        }

        if(board[i][j] != -1){
            return board[i][j];
        }

        int temp = 0;
        //向右移动
        temp += dfs(i,j+1);
        //向下移动
        temp += dfs(i+1,j);

        board[i][j] = temp;
        return temp;

    }
}
