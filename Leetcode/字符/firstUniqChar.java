import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//剑指 Offer 50. 第一个只出现一次的字符
public class firstUniqChar {
    public char firstUniqChar2(String s) {
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(char ch :arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> mapping : map.entrySet()){
            if(mapping.getValue() == 1) return mapping.getKey();
        }

        return ' ';
    }


    //不可以排序 不然的话顺序就被打乱了....
    public char firstUniqChar(String s) {
        if (s == null) return ' ';
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        if (arr.length == 1) return arr[0];
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (arr[left] == arr[right]) {
                while (right < arr.length && arr[left] == arr[right]) {
                    right++;
                }
            } else {
                return arr[left];
            }
            left = right;
            right = left + 1;
        }
        return ' ';
    }
}