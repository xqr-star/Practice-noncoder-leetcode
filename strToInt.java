//剑指 Offer 67. 把字符串转换成整数
public class strToInt {

    public static void main(String[] args) {
        System.out.println(strToInt("2147483648"));
    }
    /**
     * 如果开头是空格 那么就略过
     * 然后紧接着必须是是符号位  如果不是 那么返回0
     * 之后截取所有的字符位
     *
     * 然后对组成的数字进行范围的判定
     * @param str
     * @return
     */
    public  static int strToInt(String str) {

        int sign = 1;
        int res = 0;
        int bound = Integer.MAX_VALUE/10;



        if(str == null) return 0;
       //去除空格 之后判断字符
        str = str.trim();
        if (str.length() == 0) return 0;



        int index = 0;
        char ch = str.charAt(index);
        //第一个非空格如果是字符直接返回0
        if(ch >= 'a' && ch <= 'z'){
            return 0;
        }
        if(ch =='-'){
            sign = -1;//表示是一个负数
            index++;
        }
        if(ch == '+') index++;
        for(int i = index;i < str.length();i++){
            char temp = str.charAt(i);
            if(temp < '0'||temp > '9') break;
            //在这里需要处理一些越界的情况！！
            //如果还没有乘以10 已经比大 说明会越界
            if(res > bound || res == bound && temp > '7'){
                return  sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res =  (temp-'0') + ( res * 10);
        }
        return  res*sign;


        //不可以向int变量直接复制成最小的数字
//        int num = -2147483648;



        //字符串拼接的方法确实会写出很多的问题 所以直接用 *10 然后+的方式

//        while (sb.length() < 10){
//            //在某一个指定的位置+0
//            sb.append("0",0,1);
//        }
//        str = sb.toString();
//        //特殊范围
//        if(flag && str.compareTo("2147483648") >= 0){
//           return Integer.MIN_VALUE;
//        }
//        if(str.compareTo("2147483647") >0){
//            str = "2147483647";
//        }
//        //正数最多是2147483647 负数 -2147483648
//        int res = Integer.parseInt(str);
//        if (flag) {
//            res = -res;
//        }
    }
}
