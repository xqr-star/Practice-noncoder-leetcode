package lc2;
//664. 奇怪的打印机
public class strangePrinter {
    //每一次打印都只可以打印一种类型的字符
    //但是打印该种类型的字符打印多少个是不确定的
    //数据范围限定在100 以内 三重循环解决问题
    //区间DP常用的状态表示
    //f[i][j] 表示的是所有将i-j 染成最终的样子的方式i的表示
    // 属性MIN

    /**
     * 如果用三重循环 i 枚举起点 j枚举终点 k 来枚举 [i][j] 区间的左右两部分
     */

    public  static int strangePrinter(String s) {

        int length = s.length();
        if(length == 0) return 0;

        int[][] f = new int[length][length];

        for(int i = length-1 ;i >= 0;i--){
            f[i][i] =1;
            for(int j = i+1 ; j < length;j++){
                //两端的字符相同
                if(s.charAt(i) == s.charAt(j)){
                    f[i][j] = f[i][j-1];
                }else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;

                    // 但是不可以这么写 太要命了！！！
//                    for(int k = i; k < j;k++){
//                        f[i][j] = Math.min(f[i][j],f[i][k]+f[k+1][j]);
//                    }
                }
            }
        }

        return f[0][length-1];

    }


    /**
     * 枚举长度
     * 每一个状态计算的时候 只会用到长度比它小的状态
     * 动态规划
     *
     * 这道题可以归为区间DP；
     *
     * 区间DP模板是三重循环
     *
     * 一重循环：区间长度
     *
     * 二重循环：区间起点
     *
     * 三重循环：区间分割点
     *
     * 状态表示：dp[n + 1][n + 1]
     *
     * dp[i][j] 表示打印i到j位置字符串的次数；
     * 属性：Min；
     * 状态计算：k = i ~ j
     *
     * 假设第i个字母后这个区间的每一个字母都不相同，dp[i][j] = 1 + dp[i + 1][j]；
     * 假设区间里有字母和区间首部元素相同，那么最小值一定出现在这样的打印方案中。也就是说其他的可以忽略：if(s[k] == s[i]) dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j])；
     * 初始化：
     *
     * 因为区间是从小到到大来动态规划，所以只需要初始化区间长度为1的就行，一个字母最少也要打印一次，dp[i][i] = 1；
     *
     *
     * @param s
     * @return
     */

    public static void main(String[] args) {
        System.out.println(strangePrinter("aaabbb"));
    }

    public  static int strangePrinter3(String s) {
        int length = s.length();
        if(length == 0) return 0;
        int[][] f = new int[length+1][length+1];

        //区间的初始化
        for(int i = 0; i < length; i++){
            f[i][i] = 1;
        }

        //枚举长度
        for(int len = 1;len <= length ;len++){
            //枚举开始的起点
            for(int left = 0; left + len <= length;left++){
                int right = left+len-1; //结束的右端点
                //只打印左端点
                f[left][right] = f[left+1][right]+1;
                //其他的情况
                for(int k = left+1; k <= right;k++) {
                    if (s.charAt(left ) == s.charAt(k)) {
                        f[left][right] = Math.min(f[left][right], f[left][k - 1] + f[k + 1][right]);
                    }
                }
            }
        }
        return f[0][length-1];

    }




    public int strangePrinter2(String s) {

        int length = s.length();
        if(length == 0) return 0;
        int[][] f = new int[length+1][length+1];

        f[1][1] = 1;
        //
        for(int i = 1; i<= length;i++){
            for(int j = i; j-1 <= length;j++){
                //f[i][j] = f[i][i] + f[i+1][j]
                //表示只打印了第一个
                f[i][j] =  1+ f[i+1][j];
                for(int k = i;k <= j ;k++){
                    if(s.charAt(i-1) == s.charAt(j-1)) {
                        f[i][j] = Math.min(f[i][j], f[i][j - 1]);
                    }else { //枚举里面的状态
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                    }
                }

            }
        }

        return f[1][length];
    }

    public int strangePrinter1(String s) {
        int length = s.length();
        int[][] f = new int[length+1][length+1];

        f[1][1] = 1;
        //
        for(int i = 1; i< length;i++){
            //只打印一个字母的是一种方式
            f[i][i] = 1;
            for(int j = i; j< length;j++){
                if(s.charAt(i-1) == s.charAt(j-1)){
                    f[i][j] = Math.min(f[i][j],f[i][j-1]);
                }else {
                    for(int k = i;k <= j ;k++){
                        f[i][j] = Math.min(f[i][j],f[i][k]+f[k+1][j]);
                    }
                }
            }
        }

        return f[1][length];

    }
}
