//剑指 Offer 44. 数字序列中某一位的数字
public class findNthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit2(1000000000));
    }

    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public  static int findNthDigit2(int n) {
        int digit = 1;//记录位数
        long start = 1;
        long count = digit*start*9;
        while (n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit*start*9;
        }

        //这里的n 可以确定了是所有digit位数的数字里面的di n位
        //先确定这个第n位所在的数字
        long num = start + (n-1)/digit;


        //然后在确定是num的第几位 因为是从0 开始的所以要减去1
        n = (n-1) % digit;
        //所以确定是num的第n位
        char ch = Long.toString(num).charAt(n) ;
        return ch-'0';

    }
}
