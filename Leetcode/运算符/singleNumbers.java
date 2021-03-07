package array;

import java.util.HashSet;

//剑指 Offer 56 - I. 数组中数字出现的次数
/**
 * 这个题的难点在于如果使用位运算符做到
 * 把一个数组擦拆分成两个 使得两个不同的数字分别位于不同的数组
 * 通过不断的按位与操作 找到了两个数字的 二进制中的哪一位不同
 * 然后 用这个m 去和所有的数字进行按位与
 * 那两个数字一定会被分到不同的组
 * 至于其他的数组 一定是相同的两个在一组。 不关心到底哪个数字被分到哪个组
 * 反正相同的一定或会在一个组里面
 */
public class singleNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,4,6};
        singleNumbers(arr);
    }

    /**
     * 位运算--是比较优化的一种解法
     * 同时复习一下运算符的优先级问题
     * 关系运算符的优先级 （== != ）大于 位运算符( &  ^ |)
     * @param nums
     * @return
     */
    public  static int[] singleNumbers2(int[] nums) {
        //首先遍历所有的数据 进行一次整体的异或操作
        // 因为相同的数字异或的结果是0，那么最后也就是得到了两个不同数据的异或结果
        //用0和一个数字进行异或，异或的结果是数字本身
        //两个相同的数字的异或结果是0
        int n = 0;//用来存储所有数据的异或结果
        for(int i = 0;i < nums.length;i++){
            n ^= nums[i];
        }

        //想要通过一种方法，可以把数组划分成两个数组，每一个数组里面都只有一个不同的数字
        //循环左移计算m
        //若整数 x ^ y 某二进制位为 1 ，
        // 则 x 和 y 的此二进制位一定不同。换言之，找到 两个异或的 某为1 的二进制位，即可将数组 nums拆分为上述的两个子数组
        //找到数组整体异或的结果中哪一位是1
        //m 是000000..1 只有和某一位是1的时候按位与的结果是1才找到了那个位置
        int m =1;
        while ((m & n) ==0){ //如果按位与的结果一直是0 就说明还没有找到两个数组不同的那一个二进制位
            m <<= 1; //就让m左移一位，一直去找
        }

        //3.将数组拆分成两个子数组 x y分别用来记录两个子数组那个不一样的值
        int x = 0;
        int y = 0;
        for(int num : nums){
            if((num & m) == 0){
                x ^= num;     //4.分别遍历两个子数组求出异或的结果
            }else {
                y ^= num;
            }
        }
        return new int[]{x,y};
    }



    //说明数组的个数一定是偶数的


    //但是这个的缺点就是用到了额外的空间
    public  static int[] singleNumbers(int[] nums) {
        int[] arr = new int[2];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        //把数字放到set里面去
        for(int i =0 ;i <nums.length;i++){
            //如果set里面包含这个数字的话，就要把这个数字去掉
            if(set.contains(nums[i]) ){
                set.remove(nums[i]);
                continue;
            }
            //不包含就添加
            set.add(nums[i]);
        }
        for(Integer num:set){
            arr[index++] = num;
        }
        return arr;
    }
}
