package algorithm;
//剑指 Offer 10- I. 斐波那契数列

/**
 * 此题的关键之处
 * 1 递归会使得栈溢出
 * 2 由于 0<= n <= 100 所以一定会出现int 数据存储不下的问题
 * 所以需要对越界进行处理
 * 但是处理的时候 一定要在第一次 c 计算出现越界的地方处理
 * 如果只是在返回的时候处理 还是无法解决越界的情况
 */
public class fib {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }
    public  static int fib(int n) {
        //栈溢出了说明不能用递归写 那就用while循环写
        // if(n== 1 || n == 2){
        //     return 1;
        // }else if(n == 3) {
        //     return 2;
        // }else{
        //     return fib(n-1)+fib(n-2);
        // }

        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        //这个思想属于不断迭代的思想
        //为什么不在return的时候取余操作
        //因为这样做会使得中间过程的运算c 就以及出现了问题
        int a = 1;
        int b = 1;
        int c = 0;
        int count =  n-2;
        while(count > 0){
            c = (a+b) % 1000000007;
            a = b;
            b = c;
            count --;
        }
        return c;
    }
}
