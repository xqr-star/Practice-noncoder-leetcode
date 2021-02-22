package Stack;

import java.util.Deque;
import java.util.LinkedList;

//20. 有效的括号
public class isValid {
    /**
     * 遇到左括号进栈，
     * 遇到右括号首先判断栈是不是空的，如果是空的，说明根本就无法比较 直接返回false
     * 然后进行是否匹配的判断 如果匹配继续往后走 不匹配直接返回false
     * 最后遍历完所有的元素以后，考虑栈是不是空的
     * 空的则是所有的左括号都成功匹配到了
     * 不空就说明有左括号没有被匹配，返回false
     *
     * @return
     */
    public static void main(String[] args) {
        String s = "([}}])";
        isValid(s);
    }
    public static boolean isValid(String s) {
        //Deque 的实现类是LinkedList，本质上还是一个线性表
        Deque<Character> stack = new LinkedList<>();
        //为了高效判断，如果字符的个数是奇数肯定不匹配
        if(s.length() % 2 != 0) return false;
        for(char ch: s.toCharArray()){
            if(ch == '('|| ch == '['|| ch=='{'){
                stack.push(ch);//遇到左括号一律进栈
            }else if(!stack.isEmpty()){ //考虑是否可以进行出栈
                if(ch == ')'&& stack.peek() == '(') {
                    stack.pop();
                }else if(ch == ']'&& stack.peek() == '['){
                    stack.pop();
                }else if(ch == '}'&& stack.peek() == '{'){
                    stack.pop();
                }else  break;//这里说明括号不匹配
            }else {  //进去了上面的elseif下面当然不会进去，我为什么这么傻的可爱？
                //如果栈为空了那么就返回或者出现任意不匹的就返回
                return false; // }}}}
            }
        }
        //最后出来以后栈应该是空的
        //但如果不为空 {（ 那就是一直在进栈
        return  stack.isEmpty();


    }
}
