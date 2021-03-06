package 模拟笔试试卷;

import java.util.Scanner;

public class sequenceStr {


    /**
     * 最好的做法是记录尾巴下标
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        int maxLength = 0;
        int endIndex = 0;
        for(int i  =0;i < str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                count++;
                if(count > maxLength){
                    maxLength = count;
                    endIndex = i;
                }
            }else{ // 如果不是数字
                count =0;
            }
        }
        //substring 是小写的
        System.out.println(str.substring(endIndex-maxLength+1,endIndex+1));
    }
    /**
     * 连续最长的数字串
     * abcd12345ed125ss123456789
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLength = 0;//用来记录连续最长的字符串的长度
        int count = 0;//用来记录当前数字字符串的长度
        int fromIndex = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                //用来记录数字的个数
                count++;
                if(count > maxLength){
                    maxLength = count;
                    fromIndex = i-count+1;
                }
            }else {
                count = 0;
                //为什么不在遇到不是数字的时候采取比较个数呢
                //有一个逻辑问题就是 如果全部都是数字的话，那么语句根本走不到这里去
                //所以根本没有办法做到数字的更新
                /*if(count > maxLength){
                    maxLength = count;
                    fromIndex = i-count;
                }*/
            }
        }

        //subString 确实是一个[ ) 的区间，
        //对于[ )的区间 区间里面的个数 是 end -begin -1;
        // [ ] 的区间 里面的个数是 end - begin +1;
        // 在这样的情况下[16,25)
        System.out.println(str.substring(fromIndex,fromIndex+maxLength));
        //这个是越界的，不成立
        //System.out.println(str.charAt(25));



    }
}
