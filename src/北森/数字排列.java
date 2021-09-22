package 北森;

import java.util.LinkedList;

public class 数字排列 {
    // 4 5 6 7 8 9
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9};
        //用于记录当前的数字是否用过
        memory = new boolean[arr.length];
        for(int i = 4;i < arr.length;i++){
            dfs(arr,i,0);
        }
        System.out.println(number);

    }

    private static LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static boolean[] memory ;
    private static int number;

    private static void dfs(int[] arr, int start, int count) {

        if(count == 5){
            res.add(new LinkedList<>(path));
            number++;
            return;
        }

        //start 参数指定的意义就是确保数字的第一个添加
        if(path.size() == 0){
            path.add(arr[start]);
            memory[start] = true;
        }

        //这里循环的次数写的有问题
        for(int i = 0; i <arr.length;i++){
            //当前的这个数字没有用过
            if(!memory[i]) {
                path.add(arr[i]);
                memory[i] = true;
                dfs(arr,start,count+1);

                //进行回溯
                path.removeLast();
                memory[i] = false;
            }
        }
    }
}
