package array;

//80. 删除有序数组中的重复项 II
public class removeDuplicatesII {
    /**
     * 通用解法: 由于是保留k个相同的数字
     * 所以对于前k个数字，可以直接跳过，进行保留
     * 对于后面的数字 能够保留的前提是 与当前写入位置的前面的第k个元素进行比较 ，不相同自可以进行保留该元素
     仅仅适用于数组是升序的
     */

    /**
     * slow 下标指向的的元素是 需要写入的位置 slow 之前的所有元素 表示重复的个数不超过2个
     * fast  下标指向的元素是 检索可以插入元素的位置
     * 可以插入元素的标准是 nums[fast] != nums[slow-2]
     * 那么slow这个位置，就是可以进行元素的插入
     */
    //这里表示的是前2个
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length  <= 2) return length;
        int slow = 2;//slow 代表当前进行写入的位置
        int fast = 2;//进行检索
        while (fast < length){
            if(nums[fast] != nums[slow-2]){
                //slow的值可以替换成fast 的然后写入的位置往后移动
                nums[slow] = nums[fast];
                slow++;
            }
            //表示一直在搜索可以插入的元素
            fast++;
        }
        //由于slow 代表的是写入的下标 slow的值刚好就是规定的数组的长度
        return slow;
    }


    /**
     * 一个很复杂的做法
     * 没有想出来 error
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int length = nums.length;
        if( length <= 2) return length;
        int slow = 0;
        int fast = 0;
        int count = 0;
        while(fast < length) {
            while (fast < length && nums[slow] == nums[fast] && count < 2) {
                fast++;
                count++;
            }
            //说明count 的数字个数超过了2 那么现在的slow就是一个坑
            if (count > 2 && fast < length) {
                slow = fast + 1;
                //然后找到第一个和坑不一样的数字
                while (fast < length && nums[fast] == nums[slow]) {
                    fast++;
                }
                //退出循环 找到了第一个不相等的  但也可能是下标越界

            }
        }
        return  0;
    }
}
