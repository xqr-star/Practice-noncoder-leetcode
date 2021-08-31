package 深信服;

import org.omg.PortableInterceptor.INACTIVE;

//求最大和子矩阵
//注意是必须要围成一个封闭的图形，不能只是路径的问题
public class Test1 {
    public int[] max_sub_matrix (int[][] matrix) {
        // write code here
        int[][] memory = matrix;
        int level = matrix.length;
        int column = matrix[0].length;
        //辅助 原始矩阵从上到下加下来的
        for(int i= 1; i < level;i++){
            for(int j =0 ;j <column;j++){
                memory[i][j] += memory[i-1][j];
            }
        }

        int max  = Integer.MAX_VALUE;
        for(int i = 0; i < level;i++){
            for(int j  = i ; j < column;j++){
                //用来保存从i - j 的对应矩阵的上下值的和
                int[] temp  = new int[matrix[0].length];

                for(int m = 0; m < matrix[0].length;m++){
                    if(i ==0){
                        temp[m] = memory[j][m];
                    }else {
                        temp[m] = memory[j][m] - memory[i-1][m];
                    }
                }
                int maxTemp = maxSubsenquence(temp);
                if (maxTemp > max) {
                    max = maxTemp;
                }

            }
        }
        return
    }

    private int maxSubsenquence(int[] temp) {
    }
}
