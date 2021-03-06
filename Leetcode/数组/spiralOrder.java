package array;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵

/**
 * 矩阵分圈处理
 */
public class spiralOrder {
    static List<Integer> list = new ArrayList<>();
    /**
     * 用左上角和右下角的左边来定打印的边界值问题
     * lx ly
     * rx ry
     * 然后一圈打印完成之后，分别对lx ly进行+1处理
     * rx ry进行-1处理
     * 处理结束的条件就是左上角坐标跑到了右下角坐标的右方或者是下方
     *
     * 矩阵可能出现的形态
     * 一行 一列 或者是 多行多列的元素
     *
     * @param matrix
     * @return
     */
    public  static List<Integer> spiralOrder(int[][] matrix) {

        //排除特殊的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length; //m行n列
        int n = matrix[0].length;
        //将矩阵看作是一个个的每一个的小矩阵
        //矩阵的对角线上的元素就是元素的限定范围

        int lx = 0;
        int ly = 0;

        int rx = m-1;
        int ry = n-1;

        //然后循环打印矩阵
        while(lx <= rx && ly <= ry){
            printMatrix(matrix,lx++,ly++,rx--,ry--);
        }
        return list;
    }

    private  static void printMatrix(int[][] matrix, int lx, int ly, int rx, int ry) {
        if(lx == rx){  //矩阵只有一行
            for(int i = ly; i<= ry;i++){
                list.add(matrix[lx][i]);
            }
        } else if(ly == ry){  //矩阵只有一列
            for(int i = lx;i <= rx;i++){
                list.add(matrix[i][ly]);
            }
        }else {//正常一个多行多列的矩阵
            //首先就先顺序打印变动ly  直到 ly == ry 的时候
            //开始变动lx 直到lx == rx -- 到这里已经打印了半个矩阵
            //然后再从 变动ry--   直到  ry == ly
            //在变动rx  rx       直到rx == lx
            //在不断变动的过程中，可见两个左边点是不可以动的，他们是一个参照
            int x = lx;
            int y = ly;
            //打印前半圈以右下角为参照的依据
            while (y != ry) {
                list.add(matrix[lx][y]);
                y++;
            }
            while (x != rx) {
                list.add(matrix[x][ry]);
                x++;
            }

            //到这里的时候 x = rx y = ry
            //然后开始回去
            while (y != ly) {
                list.add(matrix[rx][y]);
                y--;
            }
            while (x != lx) {
                list.add(matrix[x][ly]);
                x--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{ {1},{2},{3}};
        spiralOrder(arr);
    }
}
