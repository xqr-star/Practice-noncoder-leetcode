package lc2;

//62. 不同路径
public class uniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
    static int row;
    static int column;
    static int res;
    static int[][] memory  ;
    public static int uniquePaths(int m, int n) {
        row = m;
        column = n;
        memory = new int[row][column];
        return  dfs(0,0);
    }

    private static int dfs(int i, int j) {
        if(i >= row || j >= column){
            return 0;
        }
        if(i == row-1 && j == column-1){
            return 1;
        }

        //使用记忆 表示这里走过
        // 区分于之前障碍物 用-1 填充
        if(memory[i][j] != 0){
            return memory[i][j];
        }

        memory[i][j] += dfs(i,j+1);
        memory[i][j] += dfs(i+1,j);
        return memory[i][j];
    }


    /**
     * DFS 和DP 的不同之处在于
     * DP 考虑的是最后一步的状态是由那一步转移而来的 是怎么过来的
     * DFS 考虑的是 如何从第一步往下继续走 如何枚举 才能枚举完
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i< m;i++){
            for(int j = 0; j< n;j++){
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
