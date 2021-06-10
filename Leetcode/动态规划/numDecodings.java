package lc2;

//91. 解码方法
public class numDecodings {

    public static void main(String[] args) {
        System.out.println(numDecoding("12"));
    }
    /**
     * dp[i]  来表示 从第一个字符到i可以得出的解码方法
     *
     * 状态转移
     *
     * dp[i] = dp[i-1] + dp[i-2]
     * 特殊情况
     * 对于 dp[i-1] 如果当前的数字是0  不可以
     * 对于 dp[i-1]  如果当前的前一个是0 也不可以
     * @param s
     * @return
     */


    public  static int numDecoding(String s) {
        int length = s.length();
        //多开数组 减少下标判断
        int[] dp = new int[length+1];
        //初始化 有
        dp[0] = 1;
        for(int i =1 ;i <= length;i++){
            //这是第一种情况
            if(s.charAt(i-1) != '0'){
                dp[i]  += dp[i-1];
            }
            //第二种情况首先得确保有两位数字才可以
            if(i >= 2){
                //或者也可以这样写
                /*String str = s.substring(i-1,i+1);
                int temp = Integer.parseInt(str);*/
                int temp = s.charAt(i-1)-'0' +( s.charAt(i-2)-'0' )*10;
                if(temp >= 10 && temp <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[length];


    }
    public  static int numDecoding1(String s) {
        int length = s.length();
        //多开数组 减少下标判断
//        int[] dp = new int[length+1];
        int[] dp = new int[length];


        for(int i =0 ;i < length;i++){
            //这是第一种情况
            if(s.charAt(i) != '0'){
                if(i == 0) {
                    dp[i] = 1;
                    continue;
                }
                dp[i]  += dp[i-1];
            }
            //第二种情况首先得确保有两位数字才可以
            if(i >= 1){
                //或者也可以这样写
                /*String str = s.substring(i-1,i+1);
                int temp = Integer.parseInt(str);*/
                int temp = s.charAt(i)-'0' +( s.charAt(i-1)-'0' )*10;
                if(temp >= 10 && temp <= 26){
                    if(i == 1) {
                        dp[i] += 1;
                        continue;
                    }
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[length-1];


    }

}
