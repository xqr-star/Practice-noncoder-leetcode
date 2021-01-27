public class 进制转换 {
    //整数转换字符串
    public static void main1(String[] args) {
        int  a = 101;
        //将整数转换为2进制的字符
        System.out.println(Integer.toString(a,2)); //1100101
        System.out.println(Integer.toBinaryString(a));

        //将整数转换为8进制的字符
        System.out.println(Integer.toString(a,8));//145
        System.out.println(Integer.toOctalString(a));
        //将整数转换为16进制的字符
        System.out.println(Integer.toString(a,16));//65
        System.out.println(Integer.toHexString(a));

    }

    //字符串转成整数
    public static void main(String[] args) {


        //表示用radix 进制的方式解读里面的字符串
        // 最后返回的是一个十进制的整数
        System.out.println(Integer.valueOf("101",2)); // 5
        System.out.println(Integer.valueOf("101",8));//65
        System.out.println(Integer.valueOf("101",16));//257



    }
}
