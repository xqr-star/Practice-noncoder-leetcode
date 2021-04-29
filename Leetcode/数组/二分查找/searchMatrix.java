
//74. 搜索二维矩阵
// 可以扩展练习 240. 搜索二维矩阵 II
//二分模板的使用
//但是首先要做到的是找到一个区间 然后在区间里面进行二分查找

import sun.plugin.liveconnect.OriginNotAllowedException;

import java.awt.print.PrinterGraphics;每一行单调递增
所有的数字都是单调递增的

// 二段性 一定是要把区间分成两段
public class searchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[] []{{1}};
        System.out.println(searchMatrix1(matrix, 0));
    }


    /**
     * 这是一种写法 其实就是先找到区间 然后在区间里面进行具体的找值
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        //判断特例 行是空的 或者行不是空的，但是列是空的
        if(matrix == null || matrix[0].length == 0) return false;
        int level = matrix.length;
        int column = matrix[0].length;

        //判断特例
        if( matrix[0][0] > target) return false;
        if( matrix[level-1][column-1] < target) return false;

        //首先需要先找出在哪一个区间里面
        // 也就说
        //然后在具体的区间里面去找有没有对应的值

        //根据二分的性质 找出在哪一个区间里面
        int i = 0;
        for(;i < level;i++){
            if( matrix[i][0] <=target  && target <= matrix[i][column-1]){
                break;
            }
        }
        //这是是说明没有找到对应的区间
        if(i == level) return false;
        //然后在找到的区间里面再次二分找到对应的值
        //此时i 记录的就是具体的区间的位置
        int left = 0;
        int right = column-1;
        while (left < right){
            int mid = (left + right)/2;
            if(matrix[i][mid] >= target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return matrix[i][left] == target;
    }


    /**
     * 还有一种写法是 把二维数组的每一个元素 进行一个编号 （0 ~ n *m -1）
     * 那么二分就相当于是 在 0 ~ n*m -1 里面进行查找
     * 但是还需要做的是 把具体的元素的编号 转换成下标
     * 这里面有一个公式可以计算
     * 比如当前数字的下标是k
     * 那么转换成二维数组的下标 i j
     * i = k / 行数 下取整
     * j = k % 列数
     * 这里的left right 是自己编的号
     */

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix[0].length == 0) return false;
        int level = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = level * column - 1;
        while (left < right){
            int mid = (left +right)/2;
            if(matrix[mid/level][mid % column] >= target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        //这里跳出的条件是找到的第一个 大于等于target的数字
        return matrix[left/level][left%column] == target;
    }
}
