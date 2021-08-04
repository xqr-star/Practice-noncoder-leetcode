import java.util.Arrays;

//剑指 Offer 56 - I. 数组中数字出现的次数
//剑指 Offer 56 - II. 数组中数字出现的次数

public class singleNumbers {
    public static void main(String[] args) {

        int[] arr = new int[]{6,5,5,9,10,9,4,10};
        System.out.println(singleNumbers(arr));
        System.out.println(1);
    }


    public  static int singleNumbers(int[] nums) {
        int[] count = new int[32];
        for(int num: nums){
            //遍历一个数字的32位
            for(int j = 0; j<32;j++){
                count[j]+= (num >> j) & 1;
            }
        }

        //然后每一位 % 3 同时进行运算
        int res = 0;
        for (int i= 0;i<32;i++){
            count[i] = count[i] %3;
            if (count[i] == 1) {
                res += Math.pow(2,i);
            }

        }
        return res;


    }

    public  static int[] singleNumbers2(int[] nums) {
        //全部异或一遍 得到是两个出现一次的数字的异或结果
        int temp = 0;
        for(int num: nums){
            temp ^= num;
        }
        //遍历这个异或的结果 看看哪一个位置是1 然后得到这个对应的十进制数字就可以把数组一分为二
        int count = 0;
        while(count < 32){
            if(( (temp >> count )& 1 )== 1){
                break;
            }
            count++;
        }
        //跳出循环后找到了第一个1的二进制位
        int[] res = new int[2];
        int split = (int) Math.pow(2,count);


        for(int num:nums){
            if((num & split) == 0) {
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }


    public int[] singleNumbers1(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int index = 0;
        int i = 0;
        for(i =0; i < nums.length-1;i++){
            if(nums[i] != nums[i+1]){
                res[index++] = nums[i];
            }else{
                i = i+1;
            }
        }
        if(i == nums.length-1) res[1] = nums[i];
        return res;
    }
}
