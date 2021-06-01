//79. 单词搜索
public class existII {

    //枚举四个方向的技巧  向量 上下左右
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int level = 0;
    int column = 0;


    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        if(word == null) return false;

        level = board.length;
        column = board[0].length;

        //递归一个个的字母搜索
        char[] original = word.toCharArray();

        //枚举起点
        for(int i = 0; i< level ;i++){
            for(int j = 0 ;j< column;j++){
                if(dfs(board,i,j,word,0)) return true;
            }
        }
        //表示的是所以的起点都没有枚举到 那么返回false
        return false;

    }

    /**
     *
     * @param board
     * @param i 当前枚举的坐标
     * @param j
     * @param word 目标单词
     * @param m 目标单词的第几位
     * @return
     */
    private boolean dfs(char[][] board, int i, int j, String word, int m) {

        //如果首个单词都不相等 那么就返回false
        if(board[i][j] != word.charAt(m))  return false;
        //这个条件表示 字符相等且已经走到了最后一个
        if(m == word.length()-1) return true;

        //然后继续dfs 这个单词的上下左右 但是不是四个方向都可以 得排除哪个从哪里来的位置
        //对应的位置的坐标才不可以枚举
        //对已经使用过的位置进行一个标记
        board[i][j] = '.';
        //然后枚举上下左右的四个方向
        for (int count = 0; count < 4; count++) {
            int a = i + dx[count];
            int b = j + dy[count];
            // 其实可以不写 board [a] [b] != '.' 因为 肯定字符里面不会有这个字母 所以一定不会匹配到
            if(a >= 0 && a < level && b >= 0 && b < column && board[a][b] != '.') {
                 if (dfs(board,a,b,word,m+1) ) return true;
            }

        }

        //然后需要回溯也就是恢复初始状态
        board[i][j] = word.charAt(m);

        return false;

    }
}
