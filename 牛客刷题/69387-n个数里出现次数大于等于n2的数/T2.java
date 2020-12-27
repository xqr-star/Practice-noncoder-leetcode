package code;
import java.util.*;
public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");//以，分割
            int[] arr = new int[strs.length];

            //字符串数组转换成int数组
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }

            int count = 0;
            int num = arr[0]; // 从第一个出现的位置开始计数


            // 最简单的方法
            Arrays.sort(arr);
            //3 4 6 7 8 9 2 2 2 2 2 2
            //2 2 2 2 2 2 3 4 6 7 8 9  --  12
            System.out.println(arr[(arr.length/2)-1]);

            //如果用数据结构来写这道题 -- map
            //key 是数组中的每一个元素  value 是出现的次数
            Map<Integer,Integer> map = new TreeMap<>();
            for(int i =0 ;i < arr.length;i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i])+1); // map.get(i) 返回key 对于的value
                }else {
                    map.put(arr[i],1);//Map中键值对的Key不能直接修改，value可以修改，如果要修改key，只能先将该key删除掉，然后再来进行重新插入
                }                // set 中只有key 没有value 所以如果要修改key 必须先删除再修改
            }

            for(Map.Entry<Integer,Integer> entry : map.entrySet()){  //Set<Map.Entry<K, V>> entrySet() 返回所有的 key-value 映射关系
                if(entry.getValue() >= arr.length/2){
                    System.out.println(entry.getKey());
                }
            }


        }
    }
}







