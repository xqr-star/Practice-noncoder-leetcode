package Leetcode;

//72. 编辑距离 hard

/**
 * 第一次在指导下写了一个动态规划，真的是难得
 * 虽然很难，但你相信我，每一天你都在进步，这就足够了！！！
 */
public class minDistance {
    /**
     * 状态表示中用几维数组来表示，是一个经验和刷题感觉的问题 所以别太强求 多做做就好了
     * F[i][j]  表示 所有可以将第一个字符串的前i个字母变成与第二个字符串的前j个字母的方法数
     * 属性 min
     * 状态转移
     * 因为可以由三种不同的操作
     * 增加
     *      加上一个字母就可以让 前i = 前j  那么说明之前  前i 已经和 前j-1 匹配上
     *      增加的这个字母一定是第j个字母
     *      f[i ,j] = f[i, i-1]+1
     *
     * 删除
     *      删除一个zim 前i= 前 j 那么说明 前i- 1  已经和前j匹配了
     *      f[i,j] = f[i-1,j] + 1
     *
     * 替换
     *      替换可能出现两种情况
     *      words[i] = words[j]
     *      f[i,j] = f[i-1,j-1]
     *
     *       words[i] != words[j]
     *       f[i,j] = f[i-1,j-1] +1 替换第i个字母
     *
     *
     * 定理一：如果其中一个字符串是空串，那么编辑距离是另一个字符串的长度。比如空串“”和“ro”的编辑距离是2（做两次“插入”操作）。再比如"hor"和空串“”的编辑距离是3（做三次“删除”操作）。
     *
     * 定理二：当i>0,j>0时（即两个串都不空时）dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))。
     *
     * 啥意思呢？举个例子，word1 = "abcde", word2 = "fgh",我们现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：
     *
     * 现在i指向e j 指向h
     * 增加 要通过增加操作 那么只需要知道 f[i,j-1] +1 就是当前的编辑距离
     * 知道"abcde"变成“fg”多少步（假设Y步），那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
     * 删除 要通过删除作 那么只需要知道 f[i-1,] +1 就是当前的编辑距离
     * 知道"abcd"变成"fgh"多少步（假设X步），那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
     * 替换
     * 知道"abcd"变成“fg”多少步（假设Z步），那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。（先不管最后一个字符，把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //因为处理下标会很麻烦 不断的有-1的操作，所以让数组多初始化 就可以少考虑边界的问题了
        int[][] dp = new int[n+1][m+1];

        //初始化边界条件
        // 也就是说让一个空串变成 有串的 或者反过来，只能要么增加 要么删除
        for(int i =0 ; i< m+1; i++) dp[0][i] = i; //要想让保持 字符串的前0个等于 前i个只能添加i次
        for(int j = 0; j < n+1;j++) dp[j][0] = j ;// 要想让字符串的前j个等于前0个，只能删除j次


        for(int i = 1 ;i < m+1;i++){
            for(int j = 1; j < n+1;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]);
                //这个是看最后第i个和第j个字母相等不相等的
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }

        return dp[n][m];
     }
}
