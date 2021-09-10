package String;

//14. 最长公共前缀
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] strs) {
        //先假设最长的公共前缀是第一个字符串
        String longest = "";
        if(strs == null || strs.length == 0) return longest;
        longest = strs[0];

        //每一个都和当前的最长公共前缀进行 获取公共字符 然后更新的操作
        //如果这个之间出现了没有公共前缀的情况 那么返回false
        for(int i = 1; i < strs.length;i++){

            for(int j = 0; j < longest.length();j++){
                //找到最长公共的
                //如果另一个字符串还没有遍历完 并且他们两个还不相同 那么可以更新公共的了
                if(j < strs[i].length() && longest.charAt(j) != strs[i].charAt(j)){
                    longest = longest.substring(0,j);
                }
                //如果遍历完了短字符串的所有
                if(j >= strs[i].length()){
                    longest = longest.substring(0,j);
                }
            }

            if(longest.equals("")) return "";
        }
        return longest.toString();
    }
}
