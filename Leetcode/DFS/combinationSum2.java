import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//40. 组合总和II
public class combinationSum2 {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    Queue<Integer> path = new LinkedList<>();
    private void dfs(int[] candidates, int index, int target) {
        if(target == 0){
            //可以添加到结果集里面了
            res.add(new LinkedList<>(path));
            return;
        }

        if(index == candidates.length) return;  //说明是以及遍历越界了

        //枚举每一个数字作为开始
        for(int i = index;i < candidates.length;i++){
            if(candidates[i] <= target){
                if(i > index && candidates[i] == candidates[i-1]) continue;
                path.add(candidates[i]);

                //由于这里限定只可以从第i个字符往后选择 所以可以做到不会出现重复的结果集
                dfs(candidates,i+1,target-candidates[i]);

                //这里是在回溯
                path.remove(candidates[i]);
            }

        }
    }
}
