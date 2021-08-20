import java.util.Deque;
import java.util.LinkedList;

//227.基本计算器II
public class calculate {
    public static void main(String[] args) {

//        System.out.println('1'-'0');

        System.out.println(calculate1("3+2*2"));

    }

    public  static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public  static int calculate1(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+' ; //用来保存数字之前的标记 默认第一个数字之前的标记是+
        int num = 0;
        for(int i = 0; i< arr.length;i++) {
            //如果是数字那么就带着当前的数字进入 但是我需要做到的是连续的数字可以进行运算的！
            //如果当前的是数字 -- 要处理的是连续最长的数字
            if (Character.isDigit(arr[i])) {
                num = num * 10 + arr[i] - '0';
            }
            //但是有一个问题就是如果最后一个是数字遇不到下一个符号之前的东西都拜拜了
            if (!Character.isDigit(arr[i]) && arr[i] != ' ' || i == arr.length-1) {
                //遇到了一个新的符号 把之前的数字处理一下
                switch (preSign) {
                    case '+': stack.push(num);break;
                    case '-':stack.push(-num);break;
                    case '*':stack.push(stack.pop() * num);break;
                    case '/': stack.push(stack.pop() / num); break;
                    default: break;
                }
                //然后更改符号 再次记录
                preSign = arr[i];
                num = 0;
            }
        }

        int res = 0;
        while (stack.size() != 0){
            res += stack.remove();
        }
        //最后返回的是栈顶的元素
        return res;
    }

}

