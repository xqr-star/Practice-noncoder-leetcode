import java.util.*;

//子集II
/*
将数组排序 统计每一个数字出现的次数
然后枚举每一个出现出现的次数
 */
public class subsetsWithDup {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
    static List<List<Integer>> res = new LinkedList<List<Integer>>();
    static List<Integer> now = new LinkedList<>();
    static int  n = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //先对数组进行排序将相同的数字放在一起
        Arrays.sort(nums);
        n = nums.length;
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        dfs(nums,0);
        return res;

    }

    /**
     *
     * @param nums
     * @param start  对第几个map里面key进行枚举
     */

    private  static void dfs(int[] nums, int start) {
        if(start == n){
            //所有的数字都枚举完了
            res.add(new LinkedList<>(now));
            return;
        }

        int count = map.get(nums[start]);
        for(int i = 0;i <= count;i++){
            dfs(nums,start+map.get(nums[start]));
            now.add(nums[start]);
        }

        //要恢复现场，删除已经添加的元素
        for(int j = 0;j <= count;j++) {
            now.remove(now.size() - 1);
        }


    }


}
