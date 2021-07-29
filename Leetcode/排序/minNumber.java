import java.util.Arrays;

//剑指 Offer 45. 把数组排成最小的数
public class minNumber {

    //所有数字排序
    //第一位是所有数字里面最小的数 除了0
    //第二位如果有0 就是0 如果没有0那么就一次去排列
    public static void main(String[] args) {
        int[] arr = new int[]{0,1};
        System.out.println(minNumber(arr));
    }


    //使用插排进行一个自定义的排序

    public  static String minNumber(int[] nums) {
        //排序的比较次数
        // 有序区间 [0-i)
        //无序区间 [i,arr.length)
        //每次拿出无序区间的第一个数字 然后遍历有序区间插入
        //找出循环次数和区间的关系
        for(int i = 1;i < nums.length;i++){
            //遍历
            int key = nums[i];
            int j = i - 1;
            for(; j  >=0 ;j--){
                //这里换一下比的规则
                StringBuilder sb = new StringBuilder();
                sb.append(nums[j]).append(key);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key).append(nums[j]);
                if(sb.toString().compareTo(sb2.toString()) > 0){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = key;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(num);
        }
        return sb.toString();
    }
    /**u
     * 这种写法是把所有的数字都打乱了
     * 20 1
     * 只能是 120
     * 不能是 102
     * @param nums
     * @return
     */
    public  static String minNumber1(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            sb.append(num);
        }
        String str = sb.toString();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        if(arr.length == 1) return new String(arr);

        if(arr[0] != '0') return new String(arr);
        char temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        return new String(arr);


    }
}
