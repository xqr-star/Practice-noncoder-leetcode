//171.Excel表列序号
public class titleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
    public static int titleToNumber(String columnTitle) {
        int num = 0;
        int jinzhi = 1;
        for(int i = columnTitle.length()-1;i >= 0; i--){
            num += (columnTitle.charAt(i)-'A'+1) * (jinzhi);
            jinzhi *= 26;
        }
        return  num;
    }
}
