import java.util.ArrayList;
import java.util.List;

//剑指 Offer 57 - II. 和为s的连续正数序列
public class findContinuousSequence {

    public static void main(String[] args) {
        findContinuousSequence2(9);
    }

    /**
     * 使用滑动窗口的性质来做
     * 左边界 右边界 [i,j)  sum和
     * 边界只会往右走
     * @param target
     * @return
     */
    public  static int[][] findContinuousSequence2(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        //结束查找的条件 如果滑动窗口最左边的数字 都要比target还要大的话
        //进一步优化条件  因为是一个有序递增不重复的序列 所以如果 最左边的数字 比target的一半还要大 那么就结束
        //一定要写 <=   target = 5  5/2 = 2
        while (left < target/2){
            if(sum <= target){
                sum+= right;
                right++;
            }else if(sum > target){
                sum -= left;
                left++;
            }else {
                //记录结果
                int[] arr = new int[right-left];
                for(int k = left;k < right;k++){
                    arr[k-left] = k;
                }
                res.add(arr);
                //然后继续去找下一个结果
                sum -=left;
                left++;
            }
        }

        return  res.toArray(new int[res.size()][]);
//        return (int[][]) res.toArray();
    }




//    ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
//    public int[][] findContinuousSequence(int target) {
//        ArrayList<Integer> path = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//        for(int i =1 ;i < target;i++){
//
//        }
//
//        dfs(target,1);
//
//    }
//
//    //深搜+记忆数组的方式
//    private void dfs(int target,int number) {
//        if(number > target)
//    }


}
