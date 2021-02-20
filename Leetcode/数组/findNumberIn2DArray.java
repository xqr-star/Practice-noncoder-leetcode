package array;

//剑指 Offer 04. 二维数组中的查找
//主题240
public class findNumberIn2DArray {
    /**
     * 我竟然连暴力的都没有想到?!
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //没有处理特殊情况
        //那么有什么特殊的情况
        //1. 数组是一个引用类型，有可能这个引用不指向任何对象
        //2. 数组是一个空数组
        if(matrix == null|| matrix.length == 0 ) return false;
        int column = matrix[0].length;//因为数组不是一个空的数组所以一定有第一行的长度
        for(int i = 0 ;i <matrix.length;i++ ){
            for(int j =0;j <column ;j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;

    }
}
