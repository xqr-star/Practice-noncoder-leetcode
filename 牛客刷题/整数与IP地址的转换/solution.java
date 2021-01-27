import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(ipToNum(str));
            String string = sc.nextLine();
            System.out.println(numToIp(string));

        }

    }

    private static Long ipToNum(String string) {
        //对字符串进行以.分割
        String[] arr = string.split("\\.");
        StringBuilder sbAll = new StringBuilder();
        for(String str : arr){
            StringBuilder sb = new StringBuilder();
            //对每一个str 转换成二进制 但是只能把int转换成str
            //先转换成int--但是会考虑溢出的可能
            long temp = Long.valueOf(str);
            //然后将int转换成2进制的字符串
            sb.append( Long.toBinaryString(temp)) ;
            while (sb.length() < 8){
                sb.insert(0,0);//往0下标插入0这个元素
            }
            sbAll.append(sb);
        }
        //最后以二进制的方式解读字符串转换成十进制的数字
        return Long.valueOf(sbAll.toString(),2);
    }

    private static String numToIp(String string) {
        //将字符串转换成Long
        Long old = Long.valueOf(string);

        //将long转换为二进制字符串
        String temp = Long.toBinaryString(old);
        StringBuilder sb = new StringBuilder(temp);
        while (sb.length() < 32){
            sb.insert(0,0);
        }
        //上一步已经转换成了32 个01
        //之后切分01转换成十进制

        StringBuilder sbNum = new StringBuilder();
        for(int i =0 ; i< 4 ;i++){
            String sub = sb.substring(i*8,i*8+8);
            //将截取出来的进行转成十进制
            sbNum.append(Long.valueOf(sub,2));
            if(i!=3) sbNum.append(".");
        }
        return sbNum.toString();

    }


}
