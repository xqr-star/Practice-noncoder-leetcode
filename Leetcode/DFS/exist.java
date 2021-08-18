//剑指 Offer 12. 矩阵中的路径
public class exist {
    static String  str ;

    public static void main(String[] args) {
        char[][] board = new char[][] {{'a','b','c','d','e'},{'s','f','c','s'},{'a','d','e','f'}};
        String str = "abcced";
        System.out.println(exist(board, str));
    }
    public  static boolean exist(char[][] board, String word) {
        if(board == null) return false;
        str = word;
        int index = 0; //表示需要匹配的第一个字符

        for(int i = 0; i< board.length;i++){
            for(int j = 0; j< board[0].length;j++){
                boolean res = dfs(board,0,i,j);
                if (res) return true;
            }
        }
        return false;
    }
    public  static boolean dfs(char[][] board,int index,int i,int j){

        if(index == str.length()) return true; //所有都以及找到了

        if(i<0 || i >= board.length || j <0 || j >= board[0].length){
            //越界了
            return false;
        }
        char ch = board[i][j];
        if(board[i][j] == '.' || board[i][j] != str.charAt(index)) return false;

        //如果当前的这个位置没有走过  并且字符匹配 表示匹配
        board[i][j] = '.';
        //当前已经找到啦，继续去进行搜索上下左右
        boolean res = dfs(board,index+1,i+1,j) || dfs(board,index+1,i-1,j) || dfs(board,index+1,i,j-1)
                || dfs(board,index+1,i,j+1);


        //进行回溯
        board[i][j] = ch;
        return res;


        // 虽然当前这个字符匹配，但是之后的不行 ,继续进行搜索上下左右
        //这样写的话枚举的起点都变了
//        return dfs(board,index,i+1,j) || dfs(board,index,i-1,j) || dfs(board,index,i,j-1)
//                || dfs(board,index,i,j+1);


    }
}
