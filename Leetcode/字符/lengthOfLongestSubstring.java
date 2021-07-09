import java.util.HashSet;

//3.无重复字符的最长字串
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring( "pwwkew"));
    }


    /**
     * 暴力
     * @param s
     * @return
     */
    public  static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;
        //这里的这个哈希表其实就相当于是一个窗口
        //永远记录的是以i开头的不重复的字符
        HashSet<Character> set = new HashSet<>();
        int maxCount = 1;
        int count = 0;

        for(int i = 0; i < s.length();i++){
            //左指针往后移动的时候 对应的哈希表也需要更改
            //重写以当前的字符来当作一个哈希表进行计算
            if(i != 0) {
                set.clear();
            }
            for(int j = i; j <  s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    count++;
                }else {
                    break;
                }
            }
            //如果值正常的结束 也是需要更新count的
            //这里的情况可能是走完了 也可能是 breaj 跳出了都需要更新一下count
            maxCount = Math.max(maxCount,count);
            count = 0;
        }
        return maxCount;

    }

    /**
     * 双指针的做法
     */

    public  static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) return 0;
        //这里的这个哈希表其实就相当于是一个窗口
        //永远记录的是以i开头的不重复的字符
        HashSet<Character> set = new HashSet<>();
        int maxCount = 1;
        int right = 0; //这里是它的右窗口
        for(int i = 0; i < s.length();i++){


            //左指针往后移动的时候 对应的哈希表也需要更改
            if(i != 0) {
                set.remove(s.charAt(i-1));
            }

            //不断的去扩展它的右边界 -- 记录得到了当前的i对应的右边界
            while (right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            maxCount = Math.max(maxCount,set.size());


        }

        //返回哈希表的长度即可
        return maxCount;
    }




    /**
     * 暴力解法： 枚举每一个终点 然后依次往前判断  （ 为什么要往前走呢？）
     */




    /**
     * 出现的逻辑问题就是 如果一个字符在一个字符串中包含 但是你不知道值哪一个位置
     * 可能就会跳过很多的
     * error
     */
    public  static int lengthOfLongestSubstring1(String s) {
        if(s == null|| s.length() == 0 ) return 0;
        if(s.length() == 1) return 1;
        int maxCount = 1;
        int count = 1;
        int begin = 0;
        int end = 1;
        while(end  < s.length()){
            //首先得判断当前这个字符在不在字符串里面
            //如果不在 那么加入 count++ end 继续往后走
            //如果在  记录此时的count 然后  修改指针 begin end
            if(!s.substring(begin,end).contains(new String(String.valueOf(s.charAt(end))))){
//            if(!help(str,s.charAt(end))){
                count++;
                end++;
                if(count > maxCount){
                    maxCount = count;
                }
            }else {
                begin = end;
                end++;
                //这里~
                count = 1;
            }
        }
        return maxCount;
    }

    private boolean help(String str, char charAt) {
        //通过char 来new String
        String string = new String(String.valueOf(charAt));
        return str.contains(string);

    }


}
