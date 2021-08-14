//剑指 Offer 21.调整数组顺序使奇数位于偶数前面
public class exchange {


    //快慢指针

        public int[] exchange(int[] nums) {
            if(nums == null || nums.length == 0) return nums;
            int slow = 0;
            int fast = 0;
            while(slow < nums.length && fast < nums.length){
                while(slow < nums.length  && nums[slow] %2 != 0){
                    slow++;
                    fast++;
                } //这里找到了第一个偶数
                while(fast < nums.length && nums[fast] % 2== 0){
                    fast++;
                }//这里找到了一个奇数
                //执行交换的逻辑
                if(slow < nums.length && fast < nums.length){
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
            }
            return nums;
        }


    //首尾双指针
    public int[] exchange1(int[] arr) {
        if(arr == null || arr.length == 0) return arr;
        int left = 0;
        int right = arr.length-1;
        int key = arr[left];
        while(left < right){
            while(left < right && arr[right] %2 == 0){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] %2 != 0){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return arr;
    }
}
