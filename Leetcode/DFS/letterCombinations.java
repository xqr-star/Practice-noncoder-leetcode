//17. 电话号码的字母组合
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class letterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }


    //使用队列
    public static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null || digits.length() == 0) return list;

        HashMap<Character, String> map = new HashMap<>();
        //初始化map结构
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        Queue<String> queue = new LinkedList<>();
        for(Character num : digits.toCharArray()){
            //获取到每一个数字对应的字母组合
            int size = queue.size();
            //刚开始的时候队列是空的 那么就放入队列
            if(size == 0){
                for(Character ch :map.get(num).toCharArray()){
                    queue.add(ch.toString());
                }
            }else {
                //如果不是空的 就要把之前的已有个数记录下来 然后在后面拼接以后进行一个添加
                //依次拿出队列的元素进行拼接
                for(int i = 0 ;i< size;i++){
                    String head = queue.poll();
                    for(Character ch :map.get(num).toCharArray()){
                        queue.add(head+ch);
                    }
                }
            }

        }

        //然后把队列里面的元素放回到 list里面
        list.addAll(queue);
        return list;
    }


        //该种做法使用了多重循环来求解
    public static List<String> letterCombinations1(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        //初始化map结构
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        //判定特殊例子
        if(digits.length() == 0 ) return null;
        List<String> list = new LinkedList<>();
        list .add("");
        //枚举每一个数字
        for(Character num : digits.toCharArray()){
            //枚举每一数字对应的字符
            List<String> now = new LinkedList<>();
            for(Character ch :map.get(num).toCharArray() ){
                //枚举之前的字符串 然后依次添加进去
                // 遍历上一个状态的list 然后 对list的每一个字符串进行添加
                for(String s : list){
                    now.add(s+ch);
                }
//                int size = list.size();
//                for (int i =0;i <size;i++){
//                    StringBuilder temp = new StringBuilder(list.remove(i));
//                     String str = temp.append(ch).toString();
//                     list.add(str);
//                }
            }
            list = now;

        }
        return list;

    }


}
