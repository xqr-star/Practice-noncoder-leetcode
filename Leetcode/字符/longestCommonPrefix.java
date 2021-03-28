package String;

//14. 最长公共前缀
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(solution1(str));
    }
    public  static String solution1(String[] strs) {
        //以第一个字符串作为基准参考
        //然后依次遍历之后的每一个字符串，对公共字符串进行迭代更新操作
        //两两找出公共的前缀

        //先判定特例
        if(strs.length == 0){
            return "";
        }
        //假定最长的公共前缀就是第一个字符串
        String res = strs[0];//str本身就支持subString的操作
        for(int i = 1; i< strs.length;i++){
            int j = 0;
            for(;j < res.length() && j < strs[i].length();j++){
                //如果相等的话，就把他们尾插进去
                if(res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            //由于subString 是new了一个新的对象 所以这里要进行把res 重新赋值的操作 fouze
            //String的不可改变特性就会被违背
            res = res.substring(0,j);
            //如果在这期间出现了 res == null 那么就直接结束
            if(res .equals("")){
                return  res;
            }
        }
        return res;
    }
}
