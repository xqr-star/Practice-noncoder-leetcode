//剑指 Offer 29. 顺时针打印矩阵
public class spiralOrder {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder2(arr);
    }

    public  static int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }


    public  static int[] spiralOrder1(int[][] matrix) {

        if(matrix == null || matrix[0].length == 0) return null;
        int level = matrix.length;
        int column = matrix[0].length;
        int length = level * column;
        int[] res = new int[length];

        int leftX = 0;
        int leftY = 0;
        int rightX = matrix.length-1;
        int rightY = matrix[0].length-1;
        int x = 0;
        int y = 0;
        int i = 0;

        while(length > 0){
            if (x == leftX ){
                res[i++] = matrix[x][y];
                length--;
                y++;
                if(y > rightY) {x++;y--;}
            }
            else if (y == rightY) {
                res[i++] = matrix[x][y];
                x++;
                length--;
                if(x > rightX) {x--;y--;}
            }
            else if (x == rightX){
                res[i++] = matrix[x][y];
                y--;
                length--;
                if(y < leftY){ x--;y++;}
            }
            else if(y == leftY) {
                res[i++] = matrix[x][y];
                length--;
                x--;
                //每调整完一轮之后 定向的指针都要变化
                if(x == leftX ) {
                    leftX++;leftY++;
                    rightX--;rightY--;
                    x = leftX;
                    y = leftY;
                }
            }

        }
        return res;
    }
}
