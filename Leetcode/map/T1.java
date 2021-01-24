package map;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
//寻找只出现一次的数字
     /*   给定一个非空整数数组
        除了某个元素只出现一次以外，‘
        其余每个元素均出现两次。
        找出那个只出现了一次的元素。*/
//不需要额外的空间


public class T1 {

    public int singleNumber(int[] nums) {
        //不断的异或
        int num = 0;
        //任何数字和0做异或是它本身
        for(int e : nums){
            num ^= e;
        }
        return num;

    }

    public int singleNumber1(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int e : nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        //遍历所有的key-values 找到出现次数为1的key
        for(Map.Entry<Integer,Integer> mapSet: map.entrySet()){
            if(mapSet.getValue() == 1){
                return mapSet.getKey();
            }
        }


//        //最后遍历map 的value获取到对应的key //不可能根据value寻找key
//        Collection<Integer> values  = map.values();
//        for(int v : values){
//           if(v == 1){
//               //根据 value 寻找key--永远给我记住
//
//           }
//        }

    }
}
