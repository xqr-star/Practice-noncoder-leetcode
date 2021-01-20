package code;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb  = new StringBuilder();
        char ch = 'A';
        //sb.append(ch+21);
        //ch + 21 是一个整型 86 然后会直接把86当成一个两个字符放进去 字符串的长度就是2
       sb.append((char) (ch+21));
       //转成char 类似之后 86 对应的是v 字符串长度是1
        System.out.println(sb.toString().length());

    }
    //StringBuilder 和 String 的相互转换
    public static void main2(String[] args) {
        //String -- StringBUilder 通过new 传递参数
        String str = "hello";
        StringBuilder sb = new StringBuilder(str);
        sb.append("world");
        System.out.println(sb); // StringBuilder可以直接输出


        //String builder -- String  通过toString
        StringBuilder stringBuilder = new StringBuilder("123");
        System.out.println(stringBuilder.toString());


    }

    /*charAt (i) 字符串索引为i的字符
     */
    public static void main1(String[] args) {
        String str = "hello";
        System.out.println(str.charAt(0));
        char ch2 = str.charAt(4);
        System.out.println(ch2);
    }
}
