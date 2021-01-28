package map;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

//    [2,7,11,15], target = 9
    //原有的思路就是
    //[2,7,11,15], target = 9
    //拿上2 和7 11 15
    //拿上7 和11 15
    //这样的两层遍历

    /**
     * 实现思路：拿到每一个数字 然后用target - 数字 = 差值
     * 然后再map中找有没有和差值一样的数字 如果有 就返回 如果没有 就把这个数字放进去
     * map<数组中的每一个数字，对应的下标>
     * 2 ： 0    9 -2 = 7 map里面没有7 就先把2 放进去
     * 7 ： 1    9-7 = 2 map里面找有没有2 找到了就返回下标
     *
     *
     * 本质上还是遍历 -- 只是遍历的时间复杂度由O(n2) -- O(n)
     */
    public int[] solution(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0 ;i < nums.length;i++){
            int temp = target - nums[i];
            Integer res =  map.get(temp); //去查找map 看看里面有没有和差值一样的数字  没有会返回null
            if(res == null) {
                map.put(nums[i],i);
            }else { //map 中有差值对应的数字
                arr[0] = res;
                arr[1] = i;
            }
        }
        return arr;
    }




}
