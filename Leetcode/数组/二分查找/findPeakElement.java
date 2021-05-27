//162 寻找峰值 mid
// 图画清楚 找好思路即可
public class findPeakElement {
    public int findPeakElement(int[] nums) {
        //最简单的做法 暴力遍历一遍然后求解
        //一旦出现了拐点，那么整个拐点就是峰值
        //但是一定不可能出现越界的问题 如果mid 是边界
        //那么说明left == right
        //这种情况是不可能进入到循环里面的，所以不会出现越界
        int left = 0;
        int right = nums.length-1;
        int mid =0 ;
        while(left < right){
            mid = (left +right)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
