package code;

import java.util.Arrays;


public class T2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGray(3)));
    }
    /**
     * 递归的时候，永远想的是和上一次的差异比较的地方
     * 思路其实总体来说难度不大，但是中间数据的处理已经涉及什么时候调用上一次的递归，需要多加练习
     * @param n
     * @return
     */
    public  static String[] getGray(int n) {
        String[] str = null;
        if(n == 1){
            str = new String[]{"0","1"}; // new 数组的方式
        }
        else {
            //要对数组进行扩容 -- 怎么数组扩容
            //lastStr  获取的是上一次的数组
            String[] lastStr = getGray(n-1);
            str = new String[2 * lastStr.length]; // 表示的是数组的length 永远是上一次数组的二倍
            //取出上一次数组里面的每一个元素 -- 把它加上首位然后放到新的数组str里面
            for (int i = 0; i < lastStr.length; i++) {
                //上一次的前面加上0
                str[i] = "0" + lastStr[i];
                //上一次的前面加上1
                str[str.length-1 - i] = "1"+lastStr[i];
            }
        }
        return  str;
    }
}
