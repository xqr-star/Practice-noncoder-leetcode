package array;

//59. 螺旋矩阵 II
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
// 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
//要求是按照顺序打印输出矩阵
public class generateMatrix {
    public static void main(String[] args) {
        generateMatrix1(3);
    }

    /**
     * 以所有要填充的数字作为推出的条件
     * @param n
     * @return
     */
    public  static int[][] generateMatrix1(int n) {
        int[][] arr = new int[n][n];
        if(n == 0) return  arr;
        //找到那两个特殊的定点
        int left = 0;
        int top = 0;
        int right = n-1;
        int bottom = n-1;
        int number =1,target = n*n;
        //但中做法会涉及到重复覆盖的问题
        //所以需要在里面进行边界值的更新问题
        /**
         * 使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
         */
        while (left <= right && top <= bottom){
        //while (number <= target){

            for(int i = left;i <= right;i++) arr[left][i] = number++; //从left 到right
            top++;//缩小上边界
            for(int i = top;i<= bottom;i++) arr[i][right] = number++; //从top到bottom
            right--;//缩小右边界
            for(int i = right;i >= left;i--) arr[bottom][i] = number++; //从right 到left
            bottom--;//缩小下边界
            for(int i = bottom;i >= top;i--) arr[i][left] = number++; //从bottom到top
            left++;//缩小左边界
        }
        return arr;
    }
    /**
     * 对于 n行h列的矩阵来说
     * n如果是偶数那么最后也是一个n维的矩阵
     * n如果是奇数那么最后就只有一个
     * 版本一 主要是代码太复杂
     * @param n
     * @return
     */

    public  static int[][] generateMatrix(int n) {
        int line = n;
        int column = n;
        int[][] arr = new int[line][column];
        if(n == 0) return  arr;
        //找到那两个特殊的定点
        int lx = 0;
        int ly = 0;
        int rx = line-1;
        int ry = column-1;
        int number =1;
        while (lx <= rx && ly <= ry){
            //往矩阵里面填充数字的过程
            int x = lx;
            int y = ly;
            //打印前半圈以右下角为参照的依据
            while (y != ry) {
                arr[lx][y] = number++;
                y++;
            }
            while (x != rx) {
                arr[x][ry]  = number++;
                 x++;
            }

            //到这里的时候 x = rx y = ry
            //然后开始回去
            while (y != ly) {
                arr[rx][y] = number++;
                y--;
            }
            while (x != lx) {
                arr[x][ly] = number++;
                x--;
            }
            //只可能出现两个坐标相同的情况，那么这个时候就一定填充的是n
            if(lx == rx && ly == ry){
                arr[lx][ly] = n*n;
            }
            //更新坐标
            lx++;ly++;rx--;ry--;
        }
        return arr;
    }


}
