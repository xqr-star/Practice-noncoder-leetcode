import java.util.Deque;
import java.util.LinkedList;

//402. 移掉 K 位数字
//贪心+栈 （单调不降）
public class removeKdigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1234567890",9));

    }

    public  static String removeKdigits(String num, int k) {
        if (num == null) return null;
        if (num.length() == 0 || num.length() <= k) return "0";

        //构建一个双端队列 而不是简单的栈这样出的时候比较方法
        Deque<Character> deque = new LinkedList<>();
        char[] arr = num.toCharArray();
        int index =0 ;
        while  (index < arr.length && k > 0){
            //如果进来是空的
            if(deque.size() == 0 ) deque.addLast(arr[index++]);
            else{
                //说明不是空的 那么就可以进行比较了
                if(arr[index] < deque.peekLast()){ //如果当前遍历到的元素比栈顶小 栈顶元素出栈
                    deque.removeLast();
                    k--;
                }
                //如果不大于直接入队
                else deque.addLast(arr[index++]);
            }
        }

        //说明此时的栈已经是一个单调不降的
        while ( k > 0){
            deque.removeLast();
            k--;
        }
        //最后要把所有没有遍历到元素放进栈、
        while (index < arr.length){
            deque.addLast(arr[index++]);
        }

        StringBuilder sb  = new StringBuilder();
        while (deque.size() != 0 && deque.peekFirst() == '0') {
            //去除所有的开头0
            deque.removeFirst();
        }
        while (deque.size() != 0){
           sb.append(deque.removeFirst());
        }
        //如果处理完0以后是空的
        if(sb.toString().equals("")) return "0";
        return sb.toString();

    }
    public  static String removeKdigits1(String num, int k) {
        if(num == null) return null;
        if(num.length() == 0 || num.length() <= k) return "0";
        StringBuilder sb = new StringBuilder(num);

        while(k > 0){
            //从左向右遍历 找到使得数字开始减小的删除
            sb = remove(sb);
            //如果操作之后和之前没有变化就删除最尾部的元素
            k--;
        }

        //如果是以0来头 那么删除直到不以0开头结束
       while (sb.length() != 0 && sb.charAt(0) == '0'){
           sb.deleteCharAt(0);
       }
        //如果经过上述的操作之后，元素都删除光了那么就返回“0”即可
        if(sb.toString().equals("")) return "0";
        return sb.toString();

    }

    private  static StringBuilder remove(StringBuilder sb) {
        for(int i = 1; i< sb.length();i++){
            if(sb.charAt(i-1) > sb.charAt(i)){
                sb.deleteCharAt(i-1);
                //找到一个就结束了当此的删除
                break;
            }else if(i == sb.length()-1) {
                //表示并没有找到违背单调不降的元素
                sb.deleteCharAt(i);
            }
        }

        return sb;
    }
}
