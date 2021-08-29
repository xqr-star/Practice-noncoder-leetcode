import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//442. 数组中重复的数据
public class findDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;

        for(int i = 0;i< length;i++){
            //这里 % length 是处理可能会数据越界的情况
           nums[ (nums[i]-1) %length] += length;
        }
        for(int i = 0; i< length;i++){
            if(nums[i] >= 2*length+1 && nums[i] <= 3*length){
                list.add(i+1);
            }
        }
        return list;
    }
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == nums[i+1]){
                list.add(nums[i]);
                i++;
            }
        }
        return list;
    }
}
