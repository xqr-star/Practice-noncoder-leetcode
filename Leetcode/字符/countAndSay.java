
//38.外观数列
public class countAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public  static String countAndSay(int n) {
        String str = "1";
        if(n == 1) {
            return str;
        }
        //n-1 次操作
        for(int i = 0 ; i < n-1 ;i ++){

            StringBuilder sb = new StringBuilder("");
            for(int j = 0 ;j < str.length();j++) {
                int k = j;
                while (k < str.length() && str.charAt(j) == str.charAt(k)) k++;
                sb.append(k - j).append(str.charAt(j));
                j = k - 1;
            }

            str = sb.toString();
        }
        return str;
    }
    public  static  String countAndSay1(int n) {
        String str = "1";
        if(n == 1) {
            return str;
        }

        while(n- 1 >0){

            //得到上一个字符串然后对字符进行统计
            //肯定会涉及到拼接的操作

            StringBuilder sb = new StringBuilder("");

            //遍历上一个字符串 需要两个指针 count
            int slow = 0;
            int fast = 0;
            int count = 0;
            int length = str.length();
            while(fast < length){
                if(str.charAt(slow) == str.charAt(fast)){
                    count++;
                    fast++;
                }else{
                    //遇到了不相等的 就把之前的相等的加入进去
                    //那如果一直相等 ，你怎么办 ？ 忽略了这个情况
                    //先把之前的加进去 然后置空重新走
                    sb.append(count);
                    sb.append(str.charAt(slow));
                    slow = fast;
                    count = 0;
                }
            }
            //少考虑了一种情况如果全都相等 根本就没有加入进去
            if(count!= 0){
                sb.append(count);
                sb.append(str.charAt(slow));
            }

            str = sb.toString();
            n--;
        }
        return str;

    }
}
