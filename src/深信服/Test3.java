package 深信服;
//字符串过滤

public class Test3 {
    public static void main(String[] args) {
        System.out.println(get_substr("222BCC111CB"));
    }
    public static String get_substr (String st) {
        // write code here

        //用来记录上一次的字符串长度 如果字符串长度不再发生变化了那么久停止
        int lengthLast = st.length();
        String str  = toGet(st);
        int lengthNew = str.length();

        while (lengthNew != lengthLast){
            str  = toGet(str);
            lengthLast = lengthNew;
            lengthNew = str.length();
        }
        return  str;
    }

    private  static String toGet(String st) {
        StringBuilder sb = new StringBuilder(st);
        String temp ;
        int left = 0;
        int right = 0;
        while (right < st.length()){
            int count = 0;
            while (right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
                right++;
                count++;
            }
            if(count >= 3){
                //替换成.
                for(int i = left ; i < right;i++){
                    sb.replace(i,i+1,".");
                }
            }
            left = right;
        }

        //最后去除所有的.
        for(int i = 0; i < sb.length();i++){
            if(sb.charAt(i) == '.'){
                sb.deleteCharAt(i);
            }
        }

        return sb.toString();
    }
}
