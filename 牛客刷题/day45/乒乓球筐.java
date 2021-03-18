package day45;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//b中的所有类型都应该在a中
//并且每一种球的数量都不大于a中的数量
// 所以如果遍历a 在b的map中 b的值一定是 小于或者等于0的
public class 乒乓球筐 {
    public static void main(String[] args){
        //将b放在hashMap中
        //a中只要在b中有键 就对应删除b的一个值
        //最后去判断b中的所有值有没有不为0的
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str[] = sc.nextLine().split(" ");
            String a = str[0];
            String b = str[1];

            HashMap<Character,Integer> map = new HashMap<>();
            //录入数据
            for(char ch : b.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            for(char ch : a.toCharArray()){
                if(map.containsKey(ch)){  // 注意map是键值对的方式，所以一定要写是不是包含key
                    map.put(ch,map.get(ch)-1); //map中的值有可能出现负数 就是因为a中的个数大于b的个数
                }else{
                    //要判断a中是否包含b的所有种类
                }
            }

            //看b中是否有值大于0的
            boolean flag = true;
            for(Map.Entry<Character,Integer> mapSet: map.entrySet()){
                if(mapSet.getValue() > 0){
                    flag  = false;
                }
            }
            if (flag) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }


    }
}
//
/*
ABCDFYE CDE
ABCDGEAS CDECDE
ABCDFYE CDE
ABCDGEAS CDECDE
*/

