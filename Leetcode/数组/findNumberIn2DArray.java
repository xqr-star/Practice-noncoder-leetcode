package array;

//剑指 Offer 04. 二维数组中的查找
//主题240
//数组满足的规律是从左到右递增
//从上到下递增
//那么右下角一定是最大的，左上角一定是最小的


public class findNumberIn2DArray {
    public static void main(String[] args) { int[] [] arr = new int[][]{ {-5}};
       findNumberIn2DArray2(arr,-10);
    }
    /**
     * 利用题目中已经给出的特点，可以发现类似的是一个二叉搜索树的结构
     * 左边比结点值小，右边比结点值大
     * 将矩阵进行一个旋转的操作
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //二维数组的特殊情况
        //第一个数组不存在
        //第二个数组存在但是 [  []  ]
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; //数组不存在或者是数组里面没有数据的情况
        }
        int column = matrix[0].length; //用来记录列的长度
        int i = 0;
        int j = column-1;
        int current = matrix[i][j];
        while (i < matrix.length && j >=0 ){
            current = matrix[i][j];
            if(target < current){
                j--;
            }else if(target > current){
                i++; //往下一行走
            }else {
                return true;
            }
        }
        return false; //处理越界的情况
    }

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
