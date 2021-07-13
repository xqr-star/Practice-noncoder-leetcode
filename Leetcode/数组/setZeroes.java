package 数组;

//73. 矩阵置零
public class setZeroes {
    public static void main(String[] args) {
        int[] [] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);
    }

    /**
     *
     */

    /**
     * 使用第一行和 第一列作为记忆空间
     * 然后额外使用两个变量 记录第一行和第一列是否有0
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagRow = false;
        boolean flagCol = false;

       //首先遍历第一行和第一列是否有 0
        for (int j = 0 ;j < n;j++){
            if(matrix[0][j] == 0){
                flagRow = true;
            }
        }
        for(int i = 0; i< m;i++){
            if(matrix[i][0] == 0){
                flagCol = true;
            }
        }

        //遍历数据 找到了0 就在记忆数组里面更新
        for(int i = 1; i < m;i++){
            for(int j = 1; j < n;j++){
                if(matrix[i][j] == 0){
                    //表示在原数组第0行 记录第i行是否有0 设置为0
                    // 但是人家如果如果原来的[0] [j]位置本身就是0   由于flag 遍历已经记录了行  当前位置存储当前列是否要变为0 即可  不矛盾
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //然后在根据第0 和 第0 列的记忆 进行一个重新设置数组
        for(int i = 1; i < m ;i++){
            for(int j = 1 ; j < n ;j++){
                if(matrix[i][0] == 0 ||  matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //最后在根据两个初始的记忆设置
        if(flagRow){
            for(int j = 0 ; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(flagCol){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

    }

    /**
     * 开辟 m+n 的空间
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //使用一个记忆数组的方式 如果记忆数组开辟的是和原数组的大小和一样的其实没有必要
        //因为要设置的是这一行一列是0 所有只用记录这一行 或者这一列是否有0就可以了
        //而不用记录这一行中的那一列为0
        boolean[] level = new boolean[m];
        boolean[] column = new boolean[n];

        for(int i = 0; i< m;i++){
            for(int j = 0 ;j < n;j++){
                if(matrix[i][j] == 0){
                    level[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0; i < m;i++){
            for(int j = 0 ; j < n;j++){
                if(level[i] ||column[j]){
                   matrix[i][j] = 0;
                }
            }
        }
    }

    private  static void replace(int[][] matrix, int i, int j) {
        for(int column = 0;column < matrix[0].length;column++){
            matrix[i][column] = 0;
        }
        for(int level = 0; level < matrix.length;level++){
            matrix[level][j] = 0;
        }
        return;
    }

}
