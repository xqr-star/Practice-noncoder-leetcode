package 数组;

//36. 有效的数独
public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];//初始化都是0  [1][5] =  1 就代表第二行 出现了6这个数字
        int[][] col = new int[9][9];//[1][5] =  1 就代表第二列出现了6这个数字
        int[][] sbox = new int[9][9];//[1][5] =  1 就代表第二个子数独出现了6这个数字

        for(int i = 0 ; i < 9;i++){
            for(int j = 0 ; j < 9 ;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0'-1;
                    if(rows[i][num] == 1 || col[j][num] == 1 || sbox[ (i / 3 ) * 3 + j / 3][num] == 1){ //说明这个下标以及存放过数字了
                        return false;
                    }else{
                        rows[i][num] = 1;
                        col[j][num] = 1;
                        sbox[ (i / 3 ) * 3 + j / 3][num] = 1;
                    }
                }
            }
        }
        return  true;
    }
}
