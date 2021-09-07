package 百度;

//绿叶衬红花

import java.util.Scanner;

/**
 * X星理工大学新学期开学典礼正在X星理工大学体育馆隆重举行，
 * 小小X作为新生代表坐上了主席台。
 * 在无比骄傲的同时，看到下面坐着的黑压压的人群，
 * 小小X想到了这么一个问题：
 * 作为一所理工大学，女生真的很少。
 * 俗话说，红花还需绿叶衬。
 * 假设所有参加开学典礼的同学坐成一个 m 行 n 列的矩阵，
 * 其中男生用“M”表示，女生用“F”表示。
 * 如果一个女生的旁边8个方位（前、后、左、右以及左前、右前、左后、右后）坐着另外一个女生，
 * 那么她们属于“同一朵红花”。
 * 现在给出一个用于表示男生和女生就坐情况的字符矩阵，
 * 请编写一个程序统计在该字符矩阵中一共有多少朵“红花”？
 */
public class Test2 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] arr = new char[m][n];

        for(int i =0; i < m;i++){
            String str = scanner.nextLine().trim();
            for(int j = 0; j < n;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        //记忆数组 用来保存这个f是不是已经被遍历过了
        //不用进行回溯处理
        boolean[][] memory = new boolean[m][n];


        for(int i= 0; i < arr.length;i++){
            for(int j = 0; j< arr[0].length;j++){
                dfs(memory,arr,i,j);
            }
        }

        System.out.println(count);
    }

    private static void dfs(boolean[][] memory, char[][] arr, int i, int j) {

        //如果越界了返回即可
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length){
            return;
        }

        //如果当前的是男生 那么返回即可
        if(arr[i][j] == 'M') return;

        if(arr[i][j] == 'F' && !memory[i][j]){
            memory[i][j] = true;
            count += 1;


            //判断下标是否合法并进行标记
            if(i-1 >=0 && j-1 >=0){
                memory[i-1][j-1] = true;
                memory[i-1][j] = true;
            }
            if(j+1 < arr[0].length){
                memory[i][j+1] = true;
            }

            if(j-1 >=0 ){
                memory[i][j-1] = true;
            }
            if(j+1 < arr[0].length){
                memory[i][j+1] = true;
            }

            if(i+1 < arr.length){
                if(j-1 >=0){
                    memory[i+1][j-1] = true;
                }
                if(j +1 < arr[0].length){
                    memory[i+1][j+1] = true;
                }

                memory[i+1][j] = true;
            }




            //然后开始以当前的为中心 进行上下左右 以及 8个方位的搜索
//            dfs(memory,arr,count,i-1,j-1);
//            dfs(memory,arr,count,i-1,j);
//            dfs(memory,arr,count,i-1,j+1);
//
//            dfs(memory,arr,count,i,j-1);
//            dfs(memory,arr,count,i,j+1);
//
//            dfs(memory,arr,count,i+1,j-1);
//            dfs(memory,arr,count,i+1,j);
//            dfs(memory,arr,count,i+1,j+1);
//
//            //搜索完了之后 把对应的花的数量加上1

        }
    }


}
