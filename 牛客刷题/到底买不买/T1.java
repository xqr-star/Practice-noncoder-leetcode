package code;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T1 {

    /**
     * 写出来的问题是，不仅要判断包含不包含，还要看我要的个数满足了没有
     * 想用数据结构做 比如map
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String old = sc.nextLine();
        String want = sc.nextLine();
        isBuy(old,want);
    }

    private static void isBuy(String old, String want) {
        Map<Character ,Integer> map = new TreeMap<>();
        char[] arr = old.toCharArray();
        //计算商家手里的珠子
        for(int i = 0; i<arr.length;i++){
            map.put(arr[i] , map.getOrDefault(arr[i],0)+1);
        }

        int lastCount =0;
        char[] wantArr = want.toCharArray();
        for(int j =0;j < wantArr.length;j++){
            if(map.containsKey(wantArr[j])){
                if(map.get(wantArr[j])> 0){
                    //有的话把商家手里的map拿出来-1
                    map.put(wantArr[j],map.get(wantArr[j])-1);
                }else {
                    //表示数量不够了
                    lastCount++;
                }
            }else {
                //表示商家手里没有这个珠子
                lastCount++;
            }
        }
        if(lastCount == 0) {
            //反正我要的你珠子你都有，两个差的数量就是商家比我多的数量
            //我不用关心到底多了什么
            System.out.println(arr.length - wantArr.length);
        }else {
            System.out.println("No "+lastCount);
        }
    }


    private static void isBuy1(String old, String want) {
        int count = 0;
        boolean flag = true;
        for(int i = 0;i < want.length();i++){
            //String str = want.substring(i,i+1);
            String str = String.valueOf(old.charAt(i));
            if(old.contains(str)){
            }else {
                flag = false;
                //记录下不不相等的个数 -- 即为缺了多少个
                count ++;
            }
        }
        //如果出出来还是true的话，说明想要的都有
        //需要计算有多少个不想要的
        if(flag == true){
            for(int i = 0;i <old.length();i++){
                String str = String.valueOf(old.charAt(i));
               // String str = old.substring(i,i+1);
                if(want.contains(str)){

                }else {
                    //记录多余的的个数 --
                    count ++;
                }
            }
            System.out.println("Yes "+count );

        }else {
             System.out.println("No "+count );
        }
    }
}
