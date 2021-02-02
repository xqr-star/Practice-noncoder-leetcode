package day10;

public class addBinary {

    public static void main(String[] args) {
        String a= "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101" ;
        String b ="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(solution(a,b));;

    }

    private static String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //从后往前走直接取每一个字符串的最后一位即可
        int i = a.length()-1;
        int j = b.length()-1;
        int sum = 0;
        int jinWei = 0;
        while (i >=0 && j>= 0){
            //获取a这一位的数字
            int temp1 = a.charAt(i--)-'0';
            int temp2 = b.charAt(j--)-'0';
            sum = temp1+temp2+jinWei;
            jinWei = sum/2;
            sb.append(sum %2);
        }

        //如果a还没有遍历完
        while (i >=0){
            sum = jinWei + a.charAt(i--)-'0';
            jinWei = sum/2;
            sb.append(sum %2);
        }

        //如果b没有遍历完

        while (j >=0){
            sum = jinWei + b.charAt(j--)-'0';
            jinWei = sum/2;
            sb.append(sum %2);
        }

        //如果两个同时遍历完，但是还有进位，那么加上进位
        if(jinWei != 0){
            sb.append(jinWei);
        }
        return sb.reverse().toString();
    }


    /**
     * 但是这个处理方式无法转换成int型
     * @param args
     */
    public static String solution1(String a, String b) {
        int num1 = Integer.valueOf(a);
        int num2 = Integer.valueOf(b);
        //处理数字的每一位
        //把他们放到String里面去，最后翻转String
        StringBuilder sb = new StringBuilder();
        int jinWei = 0;
        int res = 0;
        int temp1 = num1;
        int temp2 = num2;
        if(num1 == 0&& num2 ==0){
            return "0";
        }
        while(num1 != 0 && num2!= 0){
            temp1 = num1 % 10;
            temp2 = num2% 10;
            res = temp1 + temp2+jinWei;
            if(res >= 2){//如果位数加起来大于2
                sb.append(res %2);
                jinWei = res/2;
            }else{//没有大于2
                sb.append(res);
                jinWei = res/2;
            }
            //依次舍弃一位re
            num1 = num1/10;
            num2 = num2/10;
        }

        while(num1 != 0){//就处理进制和temp1
            temp1 = num1%10;
            res = jinWei+temp1;
            sb.append(res % 2);
            jinWei = res /2;
            num1 = num1 /10;
        }


        while(num2 != 0){//处理进制和temp2
            temp2 = num2 %10;
            res = jinWei+temp2;
            sb.append(res % 2);
            jinWei = res /2;
            num2 = num2 /10;
        }
        //处理最后的进制
        if(jinWei !=0){
            sb.append(jinWei);
        }
        return sb.reverse().toString();


    }
}
