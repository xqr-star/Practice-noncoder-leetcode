//剑指 Offer 49. 丑数
public class nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public  static int nthUglyNumber(int n) {
        int dp[] = new int[n];//用来存储丑数序列

        //分别表示的第a个需要乘以2   a-1 之前的数字都已经乘过2了
        //第b个数需要乘以3
        //第c个数需要乘以4
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;

//        for(int i= 1;i < n;i++){
//            dp[i] = Math.min(dp[a]*2,dp[b]*3);
//            dp[i] = Math.min(dp[i],dp[c]*5);
//            if(dp[i] == a) a++;
//            if(dp[i] == b) b++;
//            if(dp[i] == c) c++;
//        }
        for(int i= 1;i < n;i++){
            int n2 = dp[a]*2;
            int n3 = dp[b]*3;
            int n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n-1];
    }
}
