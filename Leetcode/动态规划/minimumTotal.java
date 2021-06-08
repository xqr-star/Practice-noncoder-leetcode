package lc2;

import java.util.LinkedList;
import java.util.List;

//120. 三角形最小路径和
public class minimumTotal {

    /**
     * 滚动数组修改状态  由于当前的状态之和上一行的状态有关 所以只用一维数组就可以做到
     * @param triangle
     * @return
     */
    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[2][length];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < length;i++){
            for(int j = 0;j < triangle.get(i).size();j++){
                //处理边界情况
                if(j == 0){
                    dp[i&1][j] = dp[i-1 &1][j]+triangle.get(i).get(j);
                }else  if (j == triangle.get(i).size()-1){
                    dp[i&1][j] = dp[i-1 &1][j-1]+triangle.get(i).get(j);
                }else {
                    dp[i&1][j] = Math.min(dp[i - 1&1][j], dp[i - 1&1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < triangle.get(length-1).size();m++){
            min = Math.min(min,dp[1][m]);
        }
        return min;
    }



    /**
     * 错误版本
     * @param triangle
     * @return
     */
    public  static int minimumTotal3(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp  = new int[length];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < length;i++){
            for(int j = 0;j <= i;j++){
                if(j ==0) {
                    dp[j] =dp[j]+triangle.get(i).get(j);
                }else if(j == i){
                    dp[j] =dp[j-1]+triangle.get(i).get(j);
                }else {
                    dp[j] = Math.min(dp[j],dp[j-1])+triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < length;m++){
            min = Math.min(min,dp[m]);
        }
        return min;
    }



    //需要创建一个二维数组，多开辟一些空间 来记录
    public int minimumTotal2(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < length;i++){
            for(int j = 0;j < triangle.get(i).size();j++){
                dp[i][j] = Integer.MAX_VALUE;
                //处理边界情况
                if(j == 0){
                    dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                }else  if (j == triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < triangle.get(length-1).size();m++){
            min = Math.min(min,dp[length-1][m]);
        }
        return min;
    }


    //要考虑每一层只可以移动的相邻的结点这个问题
    public int minimumTotal1(List<List<Integer>> triangle) {
        int length = triangle.size();
        //用来记录 第i层的最小值
        int[] f = new int[length];
        f[0] = triangle.get(0).get(0);
        //第一个值
        int num = Integer.MIN_VALUE;

        //依次遍历每一层
        for (int i = 1 ;i < length;i++){
            //依次得到这一层的每一个
            int min = triangle.get(i).get(0);
            for(int j = 0; j < triangle.get(i).size();j++){
                min = Math.min(min,triangle.get(i).get(j));
            }
            f[i] = f[i-1]+min;
        }
        return f[length-1];

    }
}
