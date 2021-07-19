import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//39. 组合总和


/**
 * 现在做到的只是可以枚举出所有的组合
 */
public class combinationSum {

     static List<List<Integer>> res = new LinkedList<>();
    public static void main(String[] args) {
//        int[] arr = new int[]{2,3,6,7};
//        int target = 7;
//
//        combinationSum(arr,target);
//        System.out.println("1");
//

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i< 10;i++){
            list.add(i+1);
        }
        //用的是 equals相等来比较的 所以可以删除
        System.out.println(list.remove(new Integer(1)));

//        System.out.println(list.remove(1));
        System.out.println("1");



    }

    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //枚举每一个数字作为第一个数字
        dfs(candidates,0,target);
        return res;
    }

    static Queue<Integer> path = new LinkedList<>();
    private  static void dfs(int[] candidates, int index, int target) {
        if(target == 0){
            //可以添加到结果集里面了
            res.add(new LinkedList<>(path));
            return;
        }
        if(index == candidates.length) return;  //说明是以及遍历越界了

        //枚举每一个结果的第一个数字作为开始
        for(int i = index;i < candidates.length;i++){

            if(candidates[i] <= target){
                path.add(candidates[i]);

                //由于这里限定只可以从第i个字符往后选择 所以可以做到不会出现重复的结果集
                dfs(candidates,i,target-candidates[i]);

                //这里是在回溯
                path.remove(candidates[i]);
            }


            //为什么不能删除元素  list 不可以删除元素吗 只可以删除index ？
//            path.remove(candidates[i]);// 链表属于尾插 头删除
//            path.remove(candidates[i]);
        }
    }
}
