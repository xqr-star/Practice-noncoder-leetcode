package String;

public class replaceSpace {
    /**
     * 从头到尾实现一个字符串的遍历操作，如果匹配每一个字符
     * 然后记录下所有空格的位置，不是空格的直接拼接，是空格的就替换拼接成其他的
     * 时间复杂度是o(n) 空间复杂的也是o(n)
     *
     */
    public String replaceSpace2(String s) {
        //情况一 ： 字符串长度为0
        if(s.length() == 0) return s;
        StringBuilder res = new StringBuilder();

       for(char ch : s.toCharArray()){
           if(ch == ' '){
               res.append("%20");
           }else {
               res.append(ch);
           }
       }
       return res.toString();

    }
    /**
     * 抖机灵版本
     * 合理使用api
     */
    public String replaceSpace3(String s) {
        return s.replaceAll(" ","%20");
    }
    /**
     * 不太推荐但是api可以看一看
     * 用数组构造字符串
     * 由于是把一个字符变成三个字符所以
     * 构造一个数组长度是源字符串长度的三倍
     */
    public String replaceSpace4(String s) {
        int length = s.length();
        int[] res = new int[3*length];
        int size = 0;
        for(int i =0 ;i <length;i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                res[size++] = '%';
                res[size++] ='2';
                res[size++] = '0';
            }else {
                res[size++] = ch;
            }
        }
        String newStr = new String(res,0,size); //注意这里的参数值用了size个 而不是实际的数组的长度
        //因为你的构造的3倍数组可能填充不满。
        return newStr;

    }
    /**
     * 忽略了一种情况就是
     * 如果字符串里面全是空格怎么办？
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        //情况一 ： 字符串长度为0
        if(s.length() == 0) return s;
        String[] arr = s.split(" ");
        //情况二：字符串里面没有空格所以不用替换
        if(arr.length == 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < arr.length;i++){
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append("%20");
            }
        }
        return sb.toString();
    }
}
