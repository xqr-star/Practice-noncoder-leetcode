package array;

//26. 删除有序数组中的重复项
public class removeDuplicates {

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        //长度限制 肯定不可能出现重复项
        if(length <= 1) return  length;
        int slow = 0;
        int fast = 1;
        for(;fast < length;fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        //长度限制 肯定不可能出现重复项
        if(length <= 1) return  length;
        int slow = 0;
        int fast = 1;

        while(fast < length){
            while( fast < length && nums[slow] == nums[fast]){
                fast++;
            }
            //找到第一个和slow 不相等的数值
            if( fast < length && nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
