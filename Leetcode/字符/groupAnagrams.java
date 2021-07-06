import java.util.*;

//49. 字母异位词分组
public class groupAnagrams {
    public static void main(String[] args) {
        String [] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strings));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            //字符串确实是没有办法排序的 但是字符数组可以做到
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            //数组和字符串的转换
            String  sorted = new String(arr);
            System.out.println(sorted.hashCode());
            if(map.get(sorted) == null){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }else{
                List<String> temp =  map.get(sorted);
                temp.add(str);
            }
        }
        //最后再把结果遍历一遍 整合起来

        for(Map.Entry<String,List<String>>mapping : map.entrySet()){
            res.add(mapping.getValue());
        }
        return res;
    }
}
