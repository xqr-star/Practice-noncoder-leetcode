package day32;

public class T2 {
    public static void main(String[] args) {
        countNumberOf2s(12);
    }

    private static int countNumberOf2s(int n) {
        //要依次就算这个数字 各个位 十位 百位 千位。。。的2的个数
        int count = 0; //用来存放最终2的个数
        //需要知道 低位 、 当前位 、 高位
        int low = 0;
        int current = 0;
        int high = 0;
        int flag = 1;//标记个位数1 十位数10 百位100
        while (n/flag != 0){

            //获取低位
            low = n - (n/flag) * flag;
            //获取当前位（% 10 可以获取末尾 然后每次变换那个num）
            current = (n/flag) % 10;
            //获取高位--连续舍去两位就可以获取高位
            high = (n/flag) /10;


            //依次处理每一位
            if(current < 2 ){
                count += high* flag;//得知道当前位是个位？十位？百位？
            }else if (current == 2){
                count += high* flag+(low+1); //计算地位，但是低位的数字虽然是low 但是从0开始哟啊多加1
            }else {
                count += (high+1)*flag;
            }
            flag *= 10;
        }
        return count;

    }





/*    这样的情况 对于n相对较小可以，但是如果n特别的大，时间将会很大。

    所以，需要优化进行求解，我们可以计算各个位置的2数字的个数；
    例如：xxxx2 仅仅是个位数字是2的情况 2的高位是0~1999 所以2000*1 2的后面没有低位
    同理 计算百位为2的情况：12209
    当百位是2的时候，还是有200-299，1200-1299,2200-2299，..11200-11299 有12*100个数，低位有200-209 10个数 所以当百位=2的时候 是
 */
//    高位数*100+低位数+1；
//    当百位数<2的时候：包括百位的数以及后面的数都不需要考虑，直接：高位数*100；
//    当百位数>2的时候：包括这个百位数 有（高位数+1）*100;
//    这只是仅仅百位是2的情况，所以之后需要求解的是 十位，千位，万位 为2的情形与百位相一致；

//    代码：
//    int count = 0;
//    int low = 0;
//    int high = 0;
//    int cur = 0;
//    int flag = 1;
//        while(n/flag!=0)
//    {
//        low = n-(n/flag)*flag;
//        cur = (n/flag)%10;
//        high = n/(flag*10);
//        if(cur == 1 || cur == 0)
//            count += high*flag;
//        if(cur == 2)
//            count += high*flag + low +1;
//        if(cur > 2)
//            count += (high+1)*flag;
//        flag *= 10;
//    }
//        return count;
//}
//
//分析的时候有一点注意：是单独的某一位是2，例如百位为2，千位为2，不一起考虑同时为2；



/**
 * 解法效率低
 * @param n
 * @return
 */
   /* public static int countNumberOf2s(int n) {
        // write code here
        if(n ==0 || n == 1)  return 0;
        int count = 0;
        for(int i= 2;i <= n;i+= 10){
            int temp = i;
            while(temp !=0 ){
                if(temp % 2 ==0) count++;//个位数是2
                temp = temp/10;
            }
        }
        return count;
    }*/
}
