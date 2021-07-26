//剑指 Offer 13. 机器人的运动范围
public class movingCount {

    static  int count = 0;
    static int level;
    static int column;
    static boolean[][] flag;

    public static int movingCount(int m, int n, int k) {
        level = m;
        column = n;
        flag = new boolean[m][n];
        dfs(0,0,k);
        return count;
    }

    private static void dfs(int i, int j, int k) {
        if(i < 0 || i >= level ||  j< 0|| j >= column) return;

        if(isValid(i,j,k) && !flag[i][j] ) {
            count++;
            flag[i][j] = true;
            dfs(i+1,j,k);
            dfs(i,j+1,k);
        }else{
            return;
        }

    }


    public static void main(String[] args) {


        int res = movingCount(2,3,1);
        System.out.println(res);
    }
    /**
     * 通过枚举每一个格子 然后判断 格子的位数和 来进行计数
     * @param m
     * @param n
     * @param k
     * @return
     */
//    public  static int movingCount(int m, int n, int k) {
//        int count = 0;
//        for(int i = 0;i < m; i++){
//            for(int j = 0; j < n;j++){
//                if(isValid(i,j,k)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    private  static boolean isValid(int i, int j,int k) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }

        while (j > 0) {
            sum += j % 10;
            j = j / 10;
        }

        if (sum <= k) return true;
        return false;
    }
}
