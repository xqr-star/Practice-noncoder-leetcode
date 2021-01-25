package day03;

import java.util.Map;
import java.util.TreeMap;

public class canConstruct {
    public static void main(String[] args) {
        System.out.println(solution("aa", "aab"));
    }

    //桶排序 桶里面放的是每一个字符出现的数量
    public static boolean solution2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int [] arr = new int[26]; // 下标就表示从a 开始的26个字母，数组里面放的是每一个字符出现的次数
        //首先将magazine中各元素分配到桶中
        for(char ch : magazine.toCharArray()){
            arr[ch-'a'] = arr[ch-'a']+1;
        }
        //从桶中取出元素，与ransomNote中的元素匹配
        for(char ch : ransomNote.toCharArray()){
            int count = arr[ch -'a'];
            if(count >= 1){
                arr[ch -'a'] = count -1;
            }else {
                return false;
            }
        }
        return true;
    }


    //但是这个解法效率太低了
    //"abb" " bba" false // 这个题好像那个商人买珠子的题目
    public static boolean solution(String ransomNote, String magazine) {
        //会想使用Map
        Map<Character,Integer> map = new TreeMap<>();
        char[] arr = magazine.toCharArray();
        //所有字符串以及个数录入
        for(char ch : arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        char[] ran = ransomNote.toCharArray();
        for(char ch : ran){
           if(map.containsKey(ch)){
               int count = map.get(ch);
               if(count >= 1){
                   map.put(ch,count-1);
               }else {
                   return false; // 数量不匹配
               }
           }else {
               return false; // 就没有对应的字符
           }
        }
        return true;
    }
}
