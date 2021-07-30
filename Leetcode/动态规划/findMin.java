package 一点资讯;

//寻找最小路径 oj
public class findMin {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(findMin(arr));
    }
    public  static int findMin (int[][] mapArray) {
        // write code here
        int m = mapArray.length;
        int n = mapArray[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = mapArray[0][0];
        for(int i = 0; i< m ;i++){
            for(int j= 0; j < n ;j++){
                if(i>0 && j > 0) dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+mapArray[i][j];
                if(i== 0 && j > 0) dp[i][j] = dp[i][j-1] + mapArray[i][j];
                if(j == 0 && i > 0) dp[i][j] = dp[i-1][j] + mapArray[i][j];
            }
        }
        return dp[m-1][n-1];

    }
}
