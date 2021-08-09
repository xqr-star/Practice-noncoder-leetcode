//剑指 Offer 43.1~n 整数中1出现的次数
public class countDigitOne {
    /**
     * 变量需要有
     * high 记录高位
     * cur 记录当前位
     * low 记录低位
     * digit 记录乘积因子
     * 判断当前位是否是1
     * 如果是0 那么当前位可能出现1得个数是  = 高位* digit个数
     * 如果是1  那么当前位得1 得个数是 = high*digit + low+1
     * 如果是其他 那么（ high+1）*digit
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int high = n/10;
        int cur = n%10;
        int low = 0;
        int digit = 1;
        int count = 0;

        //注意这个while 条件
        //最后依次循环得时候 high 其实是已经为0了 所以要些cur ！= 0
        //但是有可能第一次得cur == 0 所以 high ！=0也是一个条件
        while(high != 0 || cur != 0){
            if(cur==0){
                count += high*digit;
            }else if(cur ==1){
                count += high*digit + low+1;
            }else {
                count += (high+1)* digit;
            }
            low += cur*digit;
            cur = high %10;
            high = high/10;
            digit *= 10;
        }
        return  count;
    }
}
