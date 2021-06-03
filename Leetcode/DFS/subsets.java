import java.util.LinkedList;
import java.util.List;

//78子集

/**
 * 枚举集合的时候 可以使用二进制的形式来枚举
 */
public class subsets {
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> now = new LinkedList<>();
    static int high = 0;
    static int  n  = 0;



    //用递归 也就是DFS来实现
    //依次递归的是每一个元素
    public static List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        dfs(nums,0);
        return res;
    }

    private static void dfs(int[] nums, int i) {
        if(i == n) {
            res.add(new LinkedList<>(now));
            return;
        }


        //如果选择这个元素
        now.add(nums[i]);
        dfs(nums,i+1);
        now.remove(now.size()-1);

        //如果不选择这个元素 就继续进行
        dfs(nums,i+1);

    }


    //用二进制的做法来实现
    public static List<List<Integer>> subsets1(int[] nums) {
        int  n = nums.length;
        high = (int) Math.pow(2,n)-1;


        //使用for循环的方式来做
        //用来循环的是不同的方案组合数字
        for (int i = 0; i<= high;i++){
            //当前的数字
            int number = i;
            //判断第j位数字是否是1
            for(int j = 0;j < n;j++){
                number = i;
                int bit = (number >> j)& 1;
                if(bit == 1){
                    now.add(nums[j]);
                }
            }
            res.add(new LinkedList<>(now));
            now.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,2,3};
//        int[] arr = new int[]{0};
        System.out.println(subsets(arr));
    }


}
