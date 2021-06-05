import java.util.LinkedList;
import java.util.List;
// 组合总和III
public class combinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    /**
     * 从1 - 9 找出由k个数字组成和为n的组合 要求不能包含重复数字
     * 二进制 枚举集合 枚举数字的出现
     *
     * @param k
     * @param n
     * @return
     */
    static List<List<Integer>> res = new LinkedList<>();
    static List<Integer> now = new LinkedList<>();



//    public static List<List<Integer>> combinationSum3(int k, int n) {
//
//    }

    // 2^ 5  + 2 ^1 + 2 ^0 = 9+2+1
    public static List<List<Integer>> combinationSum3(int k, int n) {
        //需要对now里面的数组统计大小的
        int temp  = k;
        int sum = 0;
        int number = (int) (Math.pow(2,9)-1);
        for (int i = 0; i <= number; i++) {
            //统计每一个数字是否是1
            int j = 0;
            //循环9次进行判断
            for (j = 0; j < 9; j++) {
                //说明和数字的个数不满足 需要剪枝
                if ((i >> j & 1) == 1) {
                    sum += j+1;
                    now.add(j+1);
                    k--;
//                    //说明综合超过了需要剪枝 或者是数字的个数已经够了
//                    if(sum >= n || k == 0) break;
                }
            }
            //最后出来有可能小于或者等于所以再次判断
            //但是这其实是没有达到剪枝的效果 还是df完了以后才进行的剪枝操作
            if ( j == 9 && sum == n && k == 0) {
                res.add(new LinkedList<>(now));
            }
            //恢复现场
            now.clear();
            k = temp;
            sum = 0;
        }

        return res;



    }


//    private void help(int k, int n) {
//        //退出的条件
//        if(sum == k && n == 0){
//            res.add(new LinkedList<>(now));
//            return;
//        }
//        //剪枝的条件
//        if(sum > k || n == 0){
//            return;
//        }
//        //枚举1 - 9 里面的数字是否进行选择
//        //使用二进制的方法来表示是否选择
//
//        }
//
//    }

}