import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //为什么和输出的结果不一致就是因为hashmap无法保输入的顺序
        //但是它的另一个实现类LinkeHashMap 可以保证 按照输入的顺序进行输出
        while (sc.hasNext()){
            int num = sc.nextInt();//候选人数
            //Map<String,Integer> map = new HashMap<>();
            Map<String,Integer> map = new LinkedHashMap<>();
            //把所有候选人放到map中去
            while(num > 0){
                map.put(sc.next(),0);
                num--;
            }
            int num2 = sc.nextInt();//投票的人数
            int invalid = 0;
            while(num2 > 0){
                String str = sc.next();
                int count =  map.getOrDefault(str,-1);
                if(count == -1){
                    //说明不存在
                    invalid++;
                }else{
                    map.put(str,count+1);
                }

                num2--;
            }

            //最后循环输出map
            for(Map.Entry<String,Integer> e : map.entrySet()){
                System.out.println(e.getKey() + " : "+e.getValue());
            }
            System.out.println( "Invalid : "+invalid);
        }
    }
}
