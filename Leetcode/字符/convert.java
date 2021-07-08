//6. Z 字形变换
public class convert {
    public static void main(String[] args) {
        String s = "AB";
        System.out.println(convert(s, 1));
    }



    public  static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < numRows;i++){
            if( i == 0 || i == numRows -1) {
                for(int j = i; j < s.length();j += 2 *(numRows -1 )){
                    sb.append(s.charAt(j));
                }
            }else{
                for(int j = i , k = 2* (numRows -1)-i; j < s.length() ||   k < s.length();j += 2 *(numRows -1 ), k+= 2 *(numRows -1 )){
                    if (j < s.length ()) sb.append(s.charAt(j));
                    if (k < s.length()) sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();

    }
    public  static String convert1(String s, int numRows) {
        //注意特判 如果只有一行就不用后续了 否则  i = num -2 会溢出
        if(numRows == 1) return s;

        //也就是需要行数个临时的字符串
        StringBuilder[] str = new StringBuilder[numRows];
        for (int m = 0 ;m < numRows;m++){
            str[m] = new StringBuilder();
        }
        //依次遍历字符串里面的每一个字符
        //然后从上倒下的加入每一个字符串里面去
        int i = 0;
        boolean flag = false;
        for(char ch : s.toCharArray()){
            str[i].append(ch);
            if(i == 0 || i == numRows -1) flag = !flag;
            i += flag? 1:-1;

        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j< numRows;j++){
            sb.append(str[j]);
        }
        return sb.toString();

    }
}
