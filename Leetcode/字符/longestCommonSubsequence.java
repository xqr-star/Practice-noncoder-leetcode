//1143. 最长公共子序列
public class longestCommonSubsequence {

    /**
     * 使用动态规划
     * @param text1
     * @param text2
     * @return
     */
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        longestCommonSubsequence(text1,text2);
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] dp = new int[length1+1][length2+1];

        /**
         * dp[i][j]
         * 表示的意思的是第一个字符串 [0,i-1]
         * 和第二个字符串 [0,j-1]的最长公共子序列
         * 为什么要这么设计呢
         * dp[i,j] 为什么不定义成 [0,i] [0,j]呢
         * 方便dp[0][0] 表示的时候是两个字符串都是空的状态这样最长的公共子序列是0
         * 当i = 0 || j == 0 的时候，对应的都是0
         */

        for(int i =1; i<= length1;i++){
            for(int j = 1; j <= length2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];



    }
}
