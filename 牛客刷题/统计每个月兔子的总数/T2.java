package day33;

public class T2 {
    public static void main(String[] args) {
        System.out.println(countWays(5));
    }

    /**
     * 同时注意 如果（a+b+c）% 100007 = (（a+b)%1000007 + c)& 10007
     * 两个数字相加也会溢出，数据溢出的问题需要仔细考虑
     * @param n
     * @return
     */
    public static int countWays(int n) {
        if(n == 1) return 1;
        if(n == 2 )return 2;
        if(n == 3) return 4;
        int a = 4;
        int b = 2;
        int c =1;
        int res = 0;
        for(int i = 4;i <=n;i++){
            res = ((a+b)% 1000000007+c)% 1000000007;
            c = b;
            b = a;
            a = res;
        }
        return res;
    }
    /**
     * 这种问题用递归必然会导致栈的溢出问题
     * @param n
     * @return
     */
    public static int countWays1(int n) {
        // write code here
        if(n == 1) return 1;
        if(n == 2 )return 2;
        if(n == 3) return 4;
        return ((countWays(n-1)+countWays(n-2))% 1000000007+countWays(n-3))% 1000000007;
    }
}
