//剑指 Offer 46. 把数字翻译成字符串
public class translateNum {

    public static void main(String[] args) {
        System.out.println(translateNum(25));
    }
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[2];
        dp[0] = 1;
        for(int i = 1; i < s.length(); i ++){
            String temp ;
            if(i == 1){
                temp = s.substring(0, i+1);
            }else {
                temp = s.substring(i-1, i+1);
            }
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                if(i== 1) dp[1] = dp[i-1 &1] + 1;
                else dp[i%2] = dp[i-1&1]  + dp[i-2&1];
            }else{
                dp[i % 2] = dp[i - 1 & 1];
            }
        }
        return dp[s.length()-1 &1];
    }


}
