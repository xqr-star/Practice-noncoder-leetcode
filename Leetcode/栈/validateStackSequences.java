import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer 31. 栈的压入、弹出序列
public class validateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] poped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, poped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        //先把元素放进去 直到和出栈的第一个匹配为止
        for (int num : pushed){
            //一直压栈
            stack.push(num);
            //每压入一个元素之后 判断这个元素是不是当前要出栈的元素
            while (!stack.isEmpty() && popped[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();

    }
}
