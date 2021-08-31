package 深信服;

//数据解密  百分之60%
//改成原地逆置的
public class Test2 {
    public static void main(String[] args) {
//        System.out.println('a'-0); //97
//        System.out.println('A'-0); //65

        System.out.println(dec("zzz", -1, 1));
    }
    public  static String dec (String str, int up_chr_offset, int low_chr_offset) {
        // write code here

        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) >='A' && str.charAt(i) <= 'Z'){
                sb = toMoveUpper(sb,i,low_chr_offset);//注意这里的参数表示的是加密的过程 现在要解密取反
            }else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                sb = toMoveLower(sb,i,up_chr_offset);
            }
        }
        return sb.toString();
    }

    private static StringBuilder toMoveUpper(StringBuilder sb, int i, int low_chr_offset) {
        int offSet = -low_chr_offset;
        Character ch = sb.charAt(i);
        int newIndex =(ch-'A'+offSet) % 26 + 65;
        char newChar = (char)(newIndex);
        String newString = Character.toString(newChar);
        sb.replace(i,i+1,newString);
        return sb;
    }

    private  static StringBuilder toMoveLower(StringBuilder sb, int i, int up_chr_offset) {
        int offSet = -up_chr_offset;
        Character ch = sb.charAt(i);
        int newIndex =(ch-'a'+offSet) % 26 + 97;
        char newChar = (char)(newIndex);
        String newString = Character.toString(newChar);
        sb.replace(i,i+1,newString);
        return sb;
    }
}
