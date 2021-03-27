package String;

//5. 最长回文子串
//要用动态规划的算法来做--但是我不太会动态规划
public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    /**
     * 动态规划
     * 如果一个字串是回文串，那么它去掉左右两边也一定是一个回文串
     * s[i,j] 是回文串
     * s[i,j] 的其他情况 抱回下标越界和不是回文串
     * 只有 s[i+1:j-1] 是回文串，并且 ss 的第 i 和 jj个字母相同时，
     * s[i:j]才会是回文串。
     *
     *
     *
     * @param s
     * @return
     */
//    public  static String longestPalindrome2(String s) {
//
//    }

    /**
     * 首先先找到一个回文的字符串，然后在判断这个回文的字符串是不是最长的
     * 但是这题其实是没有做出来的
     * 这是暴力法
     * @param s
     * @return
     */
    public  static String longestPalindrome(String s) {
        //特殊值的处理
        if(s.length() == 1) return s;
        int maxLength = 0;
        int maxIndex = 0;

        for(int i =0;i < s.length();i++){
            for(int j = i+1;j <= s.length();j++){
                String str = s.substring(i,j);//开区间
                boolean flag = isHUiWen(str);
                if(flag  && str.length() > maxLength){
                    maxIndex = i;
                    maxLength = str.length();
                }
            }
        }
        return s.substring(maxIndex,maxIndex+maxLength);
    }

    private static boolean isHUiWen(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left < right ){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else {
                break;
            }
        }
        if(left >=right){ //奇数是大于 偶数是等于
            return true;
        }
        return false;
    }
}
