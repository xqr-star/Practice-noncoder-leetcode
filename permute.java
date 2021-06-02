import java.util.LinkedList;
import java.util.List;

//46. 全排列
//使用思想 枚举每一个位置放哪一个数字
//在考虑 枚举每一个数字 放在哪一个位置
public class permute {


    static int size = 0;
    //定义一个boolean 数组来表示当前的元素是否遍历过
    //即为定义状态遍历
    static boolean[] arr ;
    //用来存放最终的结果list
     static List<List<Integer>> res = new LinkedList<>();
     static List<Integer> now = new LinkedList<>();

    public  static List<List<Integer>> permute(int[] nums) {
        //枚举每一个数字作为全排列的qidia
        size = nums.length;
        arr = new boolean[size];
        //起点就是枚举第一个位置放哪一个元素
        dfs(nums,0);
        return res;
    }

    private static void dfs(int[] nums, int i) {
        //表示的是当前的方案
        //表示所有的位置都枚举完了
        if(i == size) {
            //下面这么写错误的原因 ： 因为回溯的过程中会回到跟结点
            // res 里面add的now 是指向now的地址的，但是由于回溯的时候 会不断地出now里面的元素
            // 导致res 指向的now 最后会变为空
            //所以这里需要做的就是复制一份
            //res.add(now);
            res.add(new LinkedList<>(now));
            return;
        }
        //i 号位置可以存放哪些元素进行枚举
        for(int j = 0 ;j < size;j++){
        // 确实不可以这么写 如果连这个条件都进不去的话 后面的也根本不会产生循环了 也不会有++的操作
        //for(int j = 0 ;j < size && arr[j] != true;j++){
            if(!arr[j]) {
                //当前的元素已经遍历过了
                arr[j] = true;
                now.add(nums[j]);
                dfs(nums, i + 1);
                //恢复现场 回溯已经加入now的结点的标记 同时在now中删除这个结点
                //回溯的过程是和上面添加的过程是相对称的
                now.remove(now.size()-1);
                arr[j] = false;

            }
        }

    }

    public static void main(String[] args) {
        int[] arr  = new int[]{1,2,3};
        System.out.println(permute(arr));
    }


}
