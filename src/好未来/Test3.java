package 好未来;

import java.util.*;


//TreeMap 能不能用key来排序
public class Test3 {
    public static void main(String[] args){

        Random random = new Random();
        int num = random.nextInt(100);
        System.out.println(num);



//        Scanner scanner = new Scanner(System.in);
//        String[] split = scanner.nextLine().split(" ");
//        String[] split2 = scanner.nextLine().split(" ");
//
//        //arr 数组 用来放所有的整数 -- 需要统计出来相同的数字出现的次数
//        int[] arr = new int[split.length];
//        for(int i = 0; i < arr.length;i++){
//            arr[i] = Integer.parseInt(split[i]);
//        }
//
//        //统计出来每一个数字出现的次数
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int num : arr){
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//
//        int index = 0;
//        int[] origin = new int[map.size()];
//        for(Map.Entry<Integer,Integer> mapping : map.entrySet()){
//            origin[index++] = mapping.getValue();
//        }
//        Arrays.sort(origin);
//
//        int[] quantity = new int[split2.length];
//        for(int i = 0; i <split2.length;i++){
//            quantity[i] = Integer.parseInt(split2[i]);
//        }
//
//        Arrays.sort(quantity);
//
//        if(quantity.length > origin.length){
//            System.out.println("false");
//        }
//
//        for(int i= 0 ; i <quantity.length ;i++){
//            if(origin[i] != quantity[i]){
//                System.out.println("false");
//            }
//        }
//        System.out.println("true");
    }
}
