//52 N 皇后II
//每一行每一列只能摆放一个皇后
//依次枚举每一个皇后的位置 并且不能存在冲突
// 搜索像是一个全排列
// 全排列就是不能用之前用过的数字 还有顺序的问题
public class totalNQueens {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }


    //每一列只能有一个皇后 列的状态数字 col【n]
    //每条对角线上只能有一个皇后 d[2n] 斜线存在两种
    //一种是整的一种是反的 ud[2n] 反着的
    // 每一个坐标在哪一个斜线上
    //关于斜对角线的性质 同一条正向的写对角线的和是固定的
    //同一条反向斜对角线的的差值是固定的 但注意可能出现负数 所以都加上一个n


    static boolean[] column ;
    static boolean[] d;//正对角线
    static boolean[] ud;//反对角线
    static int res = 0;
    static int level ;
    public static int totalNQueens(int n) {
        column = new boolean[n];
        d = new boolean[2*n];
        ud = new boolean[2*n];
        level = n;
        dfs(0);
        return res;
    }

    /**
     * 枚举每一行
     * @param i
     */
    private static void dfs(int i) {
        if(i == level){
            //说明所有的行都枚举过了
            res++;
            return;
        }
        for(int j = 0;j < level;j++){
            //枚举每一列  正向斜对角线  反向写对角线
            if(!column[j] && !d[i+j] && !ud[i-j+level]) {
                column[j] = true;
                d[i+j] = true;
                ud[i-j+level] = true;
                dfs(i+1);
                column[j] = false;
                d[i+j] = false;
                ud[i-j+level] = false;
            }
        }



    }
}
