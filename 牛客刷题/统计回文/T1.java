package code;

import java.util.Scanner;

public class T1 {
    /**
     * 统计回文
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String oldA = sc.nextLine();
        String b = sc.nextLine();
        int count = 0;
        //把字符串b 往 a 里面插入
       for(int i = 0 ; i <= oldA.length();i++) {
           StringBuffer a = new StringBuffer(oldA);//这个保证之前的插入不影响下一次 恢复到原始的a
           a.insert(i,b);  // 在字符串中插入字符串 StringBuffer insert(int index,String str)
           //每一次插入的时候a 都会更改，这样的话，原始字符串不能保持不变
           //判断是否是回文结构
           Boolean flag= isHuiWen(a);
           if(flag == true) {
               count++;
               System.out.println(a); //输出对应的回文结构

           }
       }
        System.out.println(count);
    }

    /**
     * 调用reverse 方法
     * 原来的字符串也被改变了
     */
    private static Boolean isHuiWen(StringBuffer a) {
        String  rawA = new String(a);
        String  reverseA = new String(a.reverse());

        //为什么下面的不能用，因为StringBuffer 没有重写equals 方法
        //只有String 重写了equals方法
        //StringBuffer rawA = new StringBuffer(a);
        // String  reverseA = new String(a.reverse()); if(rawA . equals (a.reverse() ) )

        if(reverseA.equals(rawA)) {
            return true;
        }
        return false;
    }


//    public static boolean isHuiWen(StringBuffer str){
//        int i = 0;
//        int j = str.length()-1;
//        while (i <= j) {
//           if(str.charAt(i) == str.charAt(j)) {
//               i++; j--;
//           }else {
//               return false;
//           }
//        }
//        return true;
//    }

}
