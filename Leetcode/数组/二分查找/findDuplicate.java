
//287. 寻找重复数
public class findDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,3,4,2};
        int[] arr2 = new int[]{1,3,4,2,2};
        int[] arr3 = new int[]{1,4,4,2,4};
        int[] arr4 = new int[]{4,3,1,4,2};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicate(arr2));
        System.out.println(findDuplicate(arr3));
        System.out.println(findDuplicate(arr4));

    }





    /**
     * 快慢指针
     * 个题目给的特殊的数组当作一个链表来看，
     * 数组的下标就是指向元素的指针，把数组的元素也看作指针。
     * 如 0 是指针，指向 nums[0]，而 nums[0] 也是指针，指向 nums[nums[0]].
     * @param nums
     * @return
     */
    public  static int findDuplicate(int[] nums) {
        //链表有环的思想 快慢指针 一定要把保证的是 有相同的起点，这样才有性质可说
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        // 这里确实是在相遇
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //但是这时候的一个一步走的根本不可能实现 找到重复度额数字
        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }

        return nums[slow];
    }

    /**
     * 错误题解
     * @param nums
     * @return
     */
    public  static int errorFindDuplicate(int[] nums) {
        //链表有环的思想 快慢指针
        int slow = 0;
        int fast = 1;
        // 这里确实是在相遇
        while(nums[slow] != nums[fast]){
            slow = (slow+1)% nums.length;
            fast = (fast+2)% nums.length;
        }

        //但是这时候的一个一步走的根本不可能实现 找到重复度额数字
        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = (slow+1)% nums.length;
            fast = (fast+1)% nums.length;
        }

        return nums[slow];
    }

    /**
     * 二分
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        //常规思路 数组排序之后  进行遍历的两两比较的操作

        //萝卜坑原理 每一个数字放的位置 都应该是数值-1 如果要存放的位置已经是这个数字 那么这个遍历到的数字就是一个重复的数字

        //如果不限制额外的空间 还可以使用 hashmap 计数的方式
        //使用链表判断是否有环的做法来判断

        //抽屉原理
        int left = 1;
        int right = nums.length-1;
        int mid = 0;
        int sub = 0;
        while(left < right){
            mid = (left+right+1)/2;
            sub = mid-left;
            //count 每次都要重新计算
            int count = 0;
            for(int i =0;i < nums.length;i++){
                if(nums[i] >= left && nums[i] < mid) count++;
            }

            //check函数
            if(count > sub){
                right = mid-1;
            }else{
                left = mid;
            }

        }
        return left;
    }

}
