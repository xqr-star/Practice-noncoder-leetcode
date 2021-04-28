package String;

//459. 重复的子字符串
public class repeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));

    }

    /**
     * 如果一个字符串S 包含一个重复的字符串m 那么将这个 S 多次的进行旋转操作 变成S
     * 而所有的旋转结果是包含在 S+S 这个字符串里面的
     * 如果去掉 S+S 的头尾元素  还可以包含S 这个字符串说明这个字符串是有重复字串的
     * 关于这个题的具体证明 这里真的是理解不了 后续载学习看看吧
     * @param s
     * @return
     */
    public  static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        String subString = str.substring(1, str.length() - 1);
        return subString.contains(s);
    }


    //错误的 测试用例见上面的例子
    //不能说找第一个重复的数字来截取字串
    public static boolean repeatedSubstringPattern1(String s) {
        //首先找到从0 开始第一个重复的字母的下标
        //然后截取 没有重复的前半部分
        //然后字符串s 的长度 进行校验  长度限定时一部分一部分校验 是不是等于这个字符 如果不相等那么就不是
        //在这个里面可以考虑使用  是否s的长度是 字串的整数倍 如果不是 就不用校验了
        if(s == null || s.equals("")) return false;
        if(s.length() == 1) return false;
        char ch = s.charAt(0);
        int length = s.length();
        int i = 1;
        for( ;i< length;i++){
            if(s.charAt(i)== ch){
                break;
            }
        }
        if(i == length) return false;
        String subString  = s.substring(0,i);
        int subLength = subString.length();
        //首先对长度是不是整数倍进行判断
        if(length % subLength != 0) return false;

        //然后进行校验
        while(i < length-subLength+1){
            String temp = s.substring(i,i+subLength);
            if(!temp.equals(subString)) return  false;
            i += subLength;
        }
        return true;
    }
}
