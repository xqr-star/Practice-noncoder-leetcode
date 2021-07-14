import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//387. 字符串中的第一个唯一字符
public class firstUniqChar {


    /**
     * LinkedHashMap
     * @param s
     * @return
     */
    public int firstUniqChar3(String s) {
        //哈希表里面放 char 和 索引
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length;i++){
            if(map.get(arr[i]) != null){
                //如果重复出现，就把哈希值索引设置为-1
                map.put(arr[i],-1);
            }else{
                map.put(arr[i],i);
            }
        }

        //遍历哈希表找出所有不为-1 的 但是要找出最小的哪一个值
        for(Map.Entry<Character,Integer> mapping : map.entrySet()){
            int val = mapping.getValue();
            if(val!= -1 ){
                return val;
            }
        }
        return -1;
    }
    public int firstUniqChar1(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }


    public int firstUniqChar(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0 ; i < arr.length;i++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }
        return 0;

    }
}
