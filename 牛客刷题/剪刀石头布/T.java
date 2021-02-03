package day33;

import java.util.*;

//甲赢了就代表已输了
//默认如果两个一个人一直输，那么他对应赢得概率出现的手势是B，这是题目默认的，没有什么原因！！
//所以可以计算
public class T {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();
        int count = Integer.parseInt(str);
        int win = 0;
        int eql = 0;
        int fal = 0;

        Map<String,Integer> mapJia = new LinkedHashMap<>();
        Map<String,Integer> mapYi = new LinkedHashMap<>();
        while(count!=0){
           String[] arr = sc.nextLine().split(" ");
            int temp =jiaIsWin(arr,mapJia,mapYi);
            if(temp ==1){
                win++;
            }else if(temp == 0){
                eql++;
            }else {
                fal++;
            }
            //判断输赢
            count--;
        }
        System.out.println(win+" "+eql+" "+fal);
        System.out.println(fal+" "+eql+" "+win);

//        //找出map中出现次数最多
        //代码重复度太高


        //arrayList的构造方法里面可以放一个集合
        List<Map.Entry<String,Integer>>list = new ArrayList<>(mapJia.entrySet());
        List<Map.Entry<String,Integer>>list2 = new ArrayList<>(mapYi.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int temp =  o2.getValue()-o1.getValue();
                if(temp == 0){//按照出现的字典序排列
                   return (o1.getKey().compareTo("A"))-(o2.getKey().compareTo("A"));
                }
                return temp;
            }
        });
        Collections.sort(list2, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int temp =  o2.getValue()-o1.getValue();
                if(temp == 0){
                  return  (o1.getKey().compareTo("A"))-(o2.getKey().compareTo("A"));
                }
                return temp;
            }
        });
        //出什么手势胜算最大

        System.out.print(list.size()==0?"B":list.get(0).getKey());
        System.out.print(" ");
        System.out.print(list2.size()==0?"B":list2.get(0).getKey());

//        if(list.size() ==0&& list2.size()!=0){
//            System.out.println( " " + list2.get(0));
//        }else if(list2.size() ==0&& list.size()!=0){
//            System.out.println(list.get(0) + " " );
//        }else if(list.size()==0 && list2.size()==0){
//            System.out.println();
//        } else {
//            System.out.println(list.get(0) + " " + list2.get(0));
//        }

    }

    private static int jiaIsWin(String[] arr, Map<String,Integer>mapJia ,Map<String,Integer> mapYi) {
        if(arr[0].equals(arr[1])){
            return 0;//表示平局
        }else if(arr[0].equals("C") && arr[1].equals("J")){
            mapJia.put(arr[0],mapJia.getOrDefault(arr[0],0)+1);
            return 1;
        }else if(arr[0].equals("J") && arr[1].equals("B")){
            mapJia.put(arr[0],mapJia.getOrDefault(arr[0],0)+1);
            return 1;
        }else if(arr[0].equals("B") && arr[1].equals("C")){
            mapJia.put(arr[0],mapJia.getOrDefault(arr[0],0)+1);
            return 1;
        }else {
            //表示乙赢了
            mapYi.put(arr[1],mapYi.getOrDefault(arr[1],0)+1);
            return -1;
        }
    }
}
