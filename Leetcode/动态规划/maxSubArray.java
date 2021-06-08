package lc2;
//53. 最大子序和
public class maxSubArray {
    /**
     * DP滚动数组的优化
     */

    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        //now就是用来记录上一个状态的
        int now =0;
        //状态初始化
        for(int i = 0;i < length;i++){
            //比较如果从上一个状态转移到这个  和从0 开始进行状态转移
            //并且让now记录当前的状态
            now = Math.max(now+nums[i],0+nums[i]);
            max = Math.max(max,now);
        }

        return max;
    }



    /**
     * DP的优化要做到的就是 不要分别的去的枚举每一个
     * 而是进行一个分类 去枚举类
     * 对类进行求解
     */
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        //集合f[i]表示所有以i结尾的子段的最大值
        int[] f =new int[length];
        //状态初始化
        f[0] = nums[0];  int max = f[0];
        for(int i =1 ;i < length;i++){
            f[i] = Math.max(f[i-1],0)+nums[i];//然后找出集合里面在最大值
            if(f[i] > max) max = f[i];
        }
        return max;
    }

    /**
     * 暴力搜索
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        //但是初始的max和temp不可以都设置成0 数字里面如果全部都是负数就会由问题
        //int max = Integer.MIN_VALUE ;//用来记录每一个阶段最大的
        int max = nums[0];
        int temp = 0;//用来记录当前起点到终点的值
        for(int i = 0; i<length;i++){
            temp = 0;
            for(int j = i; j<length;j++){
               temp+= nums[j];
               //这个if判断放在里面和外面完全是不一样的意思
                //其实思想的改进是枚举起点 然后扫描终点 而不用枚举终点的方式
               if(temp > max) max = temp;
            }
        }
        return max;
    }
}
