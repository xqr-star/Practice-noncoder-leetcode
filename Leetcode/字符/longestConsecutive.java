package String;

import java.util.HashSet;

//128. 最长连续序列
public class longestConsecutive {

    public int longestConsecutive2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        //使用set存放数组作为一个可以快速判断是否存在的hash集合
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int count = 0;
        int max = 0;


        //枚举每一个数字的前一个是否出现在哈希数组中
        //如果出现 说明当前的字符是一定会被计算到某一个连续的最长子序列中的
        //如果没有出现 那么以当前的序列为起点开始进行检索 更新当前的子序列的长度


        for (int num :set){
            int target = num;
            //如果前一个不存在 开始进行当前的搜索
            if(!set.contains(target-1)){
                count ++;
                target++;
                while (set.contains(target)){
                    count++;
                    target++;
                }
                max = Math.max(count,max);
            }

            //最后结束的时候更新count
            count = 0;
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        //使用set存放数组作为一个可以快速判断是否存在的hash集合
        for(int i = 0; i< nums.length;i++){
            set.add(nums[i]);
        }

        int count = 1;
        int max = 1;
        for(int i = 0; i< nums.length;i++){
            int target = nums[i];
            //最多循环数组的长度-1次，判断比当前数字多1 多2 多3 ...的数字是否存在
            for(int j = 1; j < set.size();j++){
                if(set.contains(target+j)){
                    count++;
                }else {

                    break;
                }
            }
            //更新当此的结果
            max = Math.max(max,count);
            count  = 1;
        }
        return max;
    }

    //最长递增字符串 输入abcabcdefad  输出：abcdef

    public static void main(String[] args) {
        String str = "abcdefg";
        char[] arr = str.toCharArray();
        int max = 1;
        int count = 1;
        int end = 0;

        for(int i = 1;i < arr.length;i++){
            if(arr[i] - arr[i-1] == 1){
                end = i+1;
                count++;
                max = Math.max(max,count);
            }else {
                count = 1;
            }
        }
        //注意完全递增的情况也需要更新
        if(end == arr.length){
            max = Math.max(max,count);
            System.out.println(str.substring(end - max));
        }else {
            System.out.println(str.substring(end - max, end + 1));
        }

        System.out.println(max);
    }
}
