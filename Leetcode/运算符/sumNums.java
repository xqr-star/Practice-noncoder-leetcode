//剑指 Offer 64. 求1+2+…+n
public class sumNums {


    /**
     * 利用
     * 1+2+..+n = n(n+1) / 2
     * @param n
     * @return
     */
    public int sumNums(int n) {
        int sum = 0;
        int A = n;
        int B = n+1;
        boolean flag ;

        flag = ((B & 1) >0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (sum += A) > 0;
        A <<= 1;
        B >>= 1;

        return sum >> 1; //除以2
    }

    public int sumNums1(int n) {
        //递归
        //控制当n-1小于0 也就是n <1 的时候 后面的语句不要再用了
        //使用逻辑运算符的短路特性
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums1(n-1)) > 0;
        return sum;
    }
}
