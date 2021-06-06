//37. 解数独
public class solveSudoku {
    //搜索的顺序问题
    //从前往后枚举每一个空格 哪一个空格该填哪一个数字
    //每一行哪个数字是否以及出现过了
    // row[9][9] 第一个维度表示的是第几行 第二个维度表示的是哪一个数字是否以及填过了
    // colunmn [9][9] 哪一列哪一个数字是否以及填过了
    // cell[3][3][9]  哪一行那一列 哪一个数字有没有被填过
    //当所有的空格都填满了以后就结束了
    //这和皇后问题 是一类精确覆盖问题
    //数据结构 dancing links 十字链表


    boolean[][] row   = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        if(board  == null || board[0].length ==0){
            return;
        }
        for(int i = 0;i < 9;i++) {
            for(int j = 0; j < 9;j++) {
                if (board[i][j] != '.') {
                    //把初始化的数据都先写好
                    row[i][board[i][j] - '1'] = true;
                    column[j][board[i][j] - '1'] = true;
                    cell[i / 3][j / 3][board[i][j] - '1'] = true;
                }
            }
        }
        dfs(0,0,board);
    }



    //这里面为什么要有返回值 每一个地方的return 为什么都那么重要呢？
    private boolean dfs(int i, int j,char[][] board) {
        if(i == 9) return true;
        if(j == 9){
            return dfs(i+1,0, board);
        }
        //首先先判断当前位置是否可以填
        if (board[i][j] == '.') {
            //枚举这个位置1-9
            for(int m = 0;m < 9;m++){
                if(!row[i][m] && !column[j][m] && !cell[i/3][j/3][m] ){
                    board[i][j] = (char) ('1'+ m);
                    row[i][m] = true;
                    column[j][m] = true;
                    cell[i/3][j/3][m] = true;

                    if(dfs(i,j+1,board)) return true;
                    board[i][j] = '.';
                    //这里必须得到一个返回值才能继续往下走
                    row[i][m] = false;
                    column[j][m] = false;
                    cell[i/3][j/3][m] = false;
                }
            }
        }else {
            return dfs(i, j + 1, board);
        }

        return false;
    }
}
