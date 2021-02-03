package day10;

import java.math.BigInteger;

public class atoi {
    public static void main(String[] args) {
        solution("2147483648");

    }

    private static int  solution(String s) {
        char [] arr = s.toCharArray();
        //测试的情况是 没有数组，去掉签到空格以后，就到达末尾
        //第一步：去掉前导空格
        int n = arr.length;
        int i = 0;
        while (i < n && arr[i] ==' '){
            i++;
        }
        if( i == n){
            return 0;//说明去掉空格以后就达到末尾
        }

        //第二步：判断有没有符号
        char flag = '+';
        if(arr[i] == '-'){
            flag = '-';
            i++;//继续往后走
        }else if(arr[i] == '+'){
            i++;//也要往后跳一个
        }else if(!Character.isDigit(arr[i])){
            //其他符号
            return 0;
        }

        int res = 0;
        while (i < n && Character.isDigit(arr[i])){
            //表示一直往后走并且遇到的都是数字才可以进入循环
            //可以通过一个个那字符转成数字 然后一次次* 10的操作
            int digit = arr[i] -'0';
            //在遍历的时候就去判断
            //本来应该用ans * 10 + digit > Integer.MAX_VALUE
            //  但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            if(res >(Integer.MAX_VALUE-digit) /10 ){
                return flag == '+'?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            //应为下面要对res进行赋值操作，所以在具体的操作之前，
            // 需要先判断操作以后会不会出现数据溢出
            res = res *10+digit;
            i++;
        }

        if(flag == '-'){
            return -res;
        }
        return res;


    }


    /**
     * 代码错误，别看！！!
     * 但是怎么说，思路还是有的，屁！
     * 那是人家题说出来的思路，无语！！！！！
     * @param s
     * @return
     */
    public static int solution1(String s) {
        StringBuilder sb = new StringBuilder();
        //处理读到的前导字符空格
        char[] arr = new char[s.length()];
        int j = 0;
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(ch != ' '){
                arr[j++] = ch;
            }
        }
        //处理读到的正负号
        j = 0;
        char flag = '+';
        if(arr.length != 0 ){
            if(arr[0] == '-' ) {//取arr[0] 要考虑手机否存在
                flag = arr[0];
                j++;
            }
            if(arr[0] == '+'){
                j++;
            }
        }

        //处理读到的数字
        for(;j< arr.length;j++){
            if(arr[j] >= '0'&& arr[j] <= '9'){
                sb.append(arr[j]);
            }else {
                break;
            }
        }
        //判断这个数字是否超出范围
        if(sb.length() == 0){//处理没有读入字符的情况
            return 0;
        }

        int maxValue = Integer.MAX_VALUE;
        BigInteger max = new BigInteger(String.valueOf(maxValue));
        int minValue = Integer.MIN_VALUE;
        BigInteger min = new BigInteger(String.valueOf(minValue));
        if(flag == '+' ){
            BigInteger res = new BigInteger(sb.toString());
            if(res.compareTo(max) > 0){
                return maxValue;
            }else {
                return Integer.parseInt(sb.toString());
            }

        }else {
            sb.insert(0,'-');
            BigInteger res = new BigInteger(sb.toString());
            if(res.compareTo(min) < 0){
                return minValue;
            }else {
                return Integer.parseInt(sb.toString());
            }
        }

        //返回一个整型


    }
}
