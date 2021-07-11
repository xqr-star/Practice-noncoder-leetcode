//131.分割回文串

import java.util.*;

public class partition {
    /**
     * 回溯
     */




    static List   <List<String>> res = new LinkedList<>();
    static boolean[][] dp;

    public static void main(String[] args) {
        partition("cdd");
    }
    public  static List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return res;
        int len = s.length();
        //深度优先搜索
        //先把字符串变成一个数组传进去，可能是因为subStrig 消耗性能的原因
        char[] arr = s.toCharArray();
        dp = new boolean[len][len];
        //在这里预先进行一个判断是不是回文串
        //通过枚举字符串结束的位置的方式
        for(int right = 0; right < len ; right++){
            //如果你在这里继续使用循环双指针判断回文串
            // 其实动规的思想还是没有用上 只不过仅仅是记忆数组的方式
            //再次优化就是  记忆数组 + 动规
            for(int left = 0; left <= right ; left++){
                if (arr[left] == arr[right] && (right - left +1  <= 3 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        dfs(arr,0,len);
        return res;
    }

    static Deque<String> path = new LinkedList<>();
    private  static void dfs(char[] arr, int from, int len) {
        //说明开始的位置已经越界了 就不要继续枚举了
        if(from == len){
            //把path 路径加入到最终的结果路径
            res.add(new ArrayList<>(path));
        }

        //枚举从开始的位置截取到哪个下标
        for(int i = from; i< len;i ++){
            if(!dp[from][i]){
                continue;
            }
//            if(!checkPalinddrome(arr,from,i)){
//                continue;
//            }
            //说明当前这个是回文串
            //数组- 偏移量 - 个数
            path.addLast(new String(arr,from,i+1-from));
            dfs(arr,i+1,len);

            //最后的时候当前的一组分割以及完成需要状态进行一个回溯
            path.removeLast();
        }
    }

    //判断是否会回文串
    private  static boolean checkPalinddrome(char[] arr, int from, int end) {
        while (from < end){
            if(arr[from] != arr[end]){
                return false;
            }
            from++;
            end--;
        }
        return true;
    }


}
