package day48;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {

        int[][] arr  = new int[3][4];
        int count = 1;
        for(int i = 0 ;i < arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                arr[i][j] = count++;
            }
        }
        clockwisePrint(arr,3,4);
    }

    public  static ArrayList<Integer> printMatrix1(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row1 = 0,row2 = matrix.length-1;
        int col1 = 0,col2 = matrix[0].length-1;
        while (col1 <= col2 && row1 <= row2){
            if (row1 == row2){//只有一行
                for (int i= col1 ;i <=col2;i++){
                    list.add(matrix[row1][i]);
                }
            }else if(col1 == col2){//只有1列
                for (int i = row1 ; i<=row2;i++){
                    list.add(matrix[i][col1]);
                }
            }else {
                int currentC = col1;
                int currentR = row1;
                //从左到右打印
                while (currentC < col2){
                    list.add(matrix[row1][currentC]);
                    currentC++;
                }
                //从上到下打印
                while (currentR < row2){
                    list.add(matrix[currentR][col2]);
                    currentR++;
                }
                //从右到左打印
                while (currentC > col1){
                    list.add(matrix[row2][currentC]);
                    currentC--;
                }
                //从下到上打印
                while (currentR > row1){
                    list.add(matrix[currentR][col1]);
                    currentR--;
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        return list;
    }

    public  static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = new int[n*m];
        int row1 = 0,row2 = mat.length-1;
        int col1 = 0,col2 = mat[0].length-1;
        while (col1 <= col2 && row1 <= row2){
            if (row1 == row2){//只有一行
                for (int i= col1 ;i <=col2;i++){
                    list.add(mat[row1][i]);
                }
            }else if(col1 == col2){//只有1列
                for (int i = row1 ; i<=row2;i++){
                    list.add(mat[i][col1]);
                }
            }else {
                int currentC = col1;
                int currentR = row1;
                //从左到右打印
                while (currentC < col2){
                    list.add(mat[row1][currentC]);
                    currentC++;
                }
                //从上到下打印
                while (currentR < row2){
                    list.add(mat[currentR][col2]);
                    currentR++;
                }
                //从右到左打印
                while (currentC > col1){
                    list.add(mat[row2][currentC]);
                    currentC--;
                }
                //从下到上打印
                while (currentR > row1){
                    list.add(mat[currentR][col1]);
                    currentR--;
                }
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }



    //这个只能处理n维度的矩阵 n * n
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if(((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0))){
            return res;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int count = 0;
        int i = 0;
        int j = 0;
        while(left <= right && top <= bottom){
            i = top;
            j = left;
            // left - right
            for(;j <= right;j++) {res.add( matrix[top][j]);}
            top++;
            i= top;
            // top = bottom
            for(;i <= bottom;i++){ res.add( matrix[i][right]);}
            right--;
            j = right;
            // right - left
            for(;j >= left;j--){res.add( matrix[bottom][j]);}
            bottom--;
            i = bottom;
            // bottom - top
            for(;i >=top ;i--){res.add( matrix[i][left]);}
            left++;
        }
        return res;
    }
    /**
     * 这里面是绝对不可以用
     * 当i或者j 没有处于调整状态的时候，这里面是绝对不可以用它定坐标
     * 那个一定是越界的
     *
     * 同时因为不一定是n * n 维度的矩阵，所以需要有特殊情况的处理
     * 一行的情况
     * 一列的情况
     * @param mat
     * @param n
     * @param m
     * @return
     */

}
