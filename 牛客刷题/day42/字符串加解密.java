package day42;

import java.util.Scanner;

/**
 * 关键的问题就是不会把下标从最后一个变换到第一个上面去
 * 数学规律就是
 * 1.计算出到起始下标有多少个数字
 * 用当前的数字减去起始的下标 +1  是为了计算出中间有多少个数字
 * 2.上一步的结果取模  取模的数字 是 开始下标到结束下标一共有多少个数字
 * 3.第二步的结果加上起始下标
 *
 *  ch = (char) ((ch -65+1)%26 +65);
 */
public class 字符串加解密 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine();
            System.out.println(encrypt(str1));
            String str2 = sc.nextLine();
            System.out.println(unEncrypt(str2));


        }
    }

    //解密
    private static String unEncrypt(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)){ //让数字减去1
               if(ch == '0'){
                   sb.append('9');
               }else {
                   sb.append((char) (ch - 1));
               }
            }else if(Character.isLetter(ch)){
                if(ch >= 'a' && ch <= 'z'){ //先转换成大写再减去1
                    ch = Character.toUpperCase(ch);
                    if(ch == 'A'){
                        sb.append('Z');
                    }else {
                        sb.append((char) (ch -1) );
                    }
                }else {
                    ch = Character.toLowerCase(ch);
                    if (ch == 'a') {
                        sb.append('z');
                    }else {
                        sb.append((char) (ch -1));
                    }
                }
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //加密的过程
    private static String encrypt(String str) {

        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            //加1
            // 数组的变换下标的方式
            //index % arr.length
            if (Character.isDigit(ch)){//如果是数字
                //先计算出到基准一共相隔了多少个数字 然后再% 总个数
                // + 其起始的基准
                ch = (char) ((ch -48+ 1)%10  +48);
            }else if (Character.isLetter(ch)){ //如果是字母
                //然后还是要变化下标
                if(ch >= 'a'&& ch <= 'z'){
                    ch = Character.toUpperCase(ch);
                    ch = (char) ((ch -65+1)%26 +65);
                }else {
                    ch = Character.toLowerCase(ch);
                    ch = (char) ( (ch -97+1) % 26 + 97);
                }

            }else {

            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
