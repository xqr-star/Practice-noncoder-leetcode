//273.整数转换英文表示
public class numberToWords {
    static String[] small = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] decade = new String[]{"","","Twenty","Thirty","Forty","fifty","Seventy","Sixty","Seventy","Eighty","Ninety"};
    static String[] big = new String[]{"","Thousand","Million","Billion"};


    public static void main(String[] args) {
        System.out.println(numberToWords(100000));
    }

    public  static String numberToWords(int num) {


        //要切分成每三个数字是一组的
        //然后把这个数字传给一个函数
        //函数返回一个处理的结果
        //最后实现字符串的拼接

        if(num == 0) return small[0];
        int[] part = new int[4];
        int i = 0;
        while(num != 0){
            part[i++] = num % 1000;
            num /= 1000;
        }
        StringBuilder res = new StringBuilder();
        for(i = 3; i >= 0; i--){
            if(part[i] != 0){
                StringBuilder temp = getString(part[i]);
                res.append(temp);
                res.append(big[i]).append(" ");
            }
        }
        return res.toString().trim();
    }
    public  static StringBuilder getString(int num){
        StringBuilder sb = new StringBuilder();
        if(num >= 100){
            sb.append(small[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if(num == 0) return sb;
        if(num > 0 && num <= 19){
            sb.append(small[num]).append(" ");
        }else {
            sb.append(decade[num / 10]).append(" ");
            num %= 10 ;
            if (num != 0) sb.append(small[num]).append(" ");
        }
        return sb;
    }
}
