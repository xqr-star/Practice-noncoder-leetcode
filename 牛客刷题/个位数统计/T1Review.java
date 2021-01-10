package code;

import java.util.*;

/**
 * 题目总结
 * 1.注意输入的数据范围是否可以用int 存放的下
 * 2.注意map的里面的元素类型是Integer 而数组的类型是char 类型要注意
 * 3.map 的各种方法不够熟练
 */

public class T1Review {
    //每个输入包含1个测试用例，即一个不超过1000位的正整数N。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        char [] arr = str.toCharArray();

        Map<Integer,Integer> map = new TreeMap<>();

        //因为数组是char 类型的，所以处理一下
        for(char c : arr){
            map.put(c-'0',map.getOrDefault(c-'0',0)+1);

        }
       /*
        for(int i = 0;i < arr.length;i++){

            //
            if(map.containsKey(arr[i]-'0')){    // 而且你这个还涉及到一个什么问题：就是我的数组类型是char 不能强制类型转换，转换就变成ASCII码了
                map.put(arr[i]-'0',map.get (arr[i]-'0')+1  );//put方法可以设置key值的value
            }else {
                map.put(arr[i]-'0',1);
            }
        }*/
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    public static void main2(String[] args) {
        /*链接：https://www.nowcoder.com/questionTerminal/a2063993dd424f9cba8246a3cf8ef445
        来源：牛客网*/

        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] chars = N.toCharArray();


        /**
         * 用list 实现
         * 索引表示0-9号位数，索引对应位置的数值就是出现的次数
         * list***有10个item表示0-9，每个item的值表示数字的个数
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);//初始化每个item都是0
        }
        for (int i = 0; i < chars.length; i++) {
            // 每遇到一个数字，就把值+1
            // set 某个下标位置的值 在原有的基础上+1
            list.set(chars[i] - '0', list.get(chars[i] - '0') + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                System.out.println(i + ":" + list.get(i));
            }
        }
    }


    /**
     * 整体解决的思路没有什么问题，但是注意数据数据范围有些大，int类型存放不下
     * @param args
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //这里数字如果不存在就不要都放进去
        Map <Integer,Integer> map = new <Integer,Integer>TreeMap();//map里面有key 和 value 所以要设置两个

        if(num == 0) {
            System.out.println("0:1");
        }
        //数字是0 的情况没有考虑到
        while(num != 0){
            int temp = num%10;
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);//put方法可以设置key值的value
            }else {
                map.put(temp,1);
            }
            num = num/10;
        }
        //最后打印这个map

        for (Map.Entry<Integer,Integer> entry : map.entrySet() ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
