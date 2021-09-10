package String;
//468. 验证IP地址
public class validIPAddress {
    public static void main(String[] args) {
        String ip = "192.0.0.1";
        System.out.println(validIPAddress(ip));
    }
    public static String validIPAddress(String IP) {

        //首先需要根据 包含. 还是： 来确定是往 ipv4上判断还是ipv6上判断
        if(IP.contains(".")){
            //用来判断是不是ipv4
            if(isIpv4(IP)){
                return  "IPv4";
            }
        }else {
            //用来判断是不是ipv6
            if(isIpv6(IP)){
                return "IPv6";
            }
        }
        return "Neither";

    }

    private static boolean isIpv6(String ip) {
        String[] arr = ip.split(":");

        //处理如果：的数量不是7个
        if(ip.lastIndexOf(":" ) == ip.length()-1) return false;
        //不满足8位是不合法的
        if(arr.length != 8 ) return false;
        for(String str : arr){
            //多过4位是不允许的
            if(str.length() == 0 || str.length() > 4) return false;
            //里面的字符0-9 a-e A-E
            for(int i = 0; i < str.length();i++){
                //如果包含英文字母
                if (str.charAt(i)  >= '0' && str.charAt(i) <=  '9') {
                }else if(str.charAt(i)  >= 'a' && str.charAt(i) <=  'f'){
                }else if(str.charAt(i)  >= 'A' && str.charAt(i) <=  'F'){
                }else  return false;
            }
        }

        return true;
    }

    private static boolean isIpv4(String ip) {
        //首先根据 .分割 字符串
        String[] arr = ip.split("\\.");
        //判断最后一个.的位置
        if(ip.lastIndexOf(".") == ip.length()-1) return false;

        //不满足4位
        if(arr.length != 4) return false;
        //然后对每一个数组里面的元素进行判定数据范围 以及不可以包含出来数字以外的任何元素
        for(String str : arr){
            //需要判断每一个被分割的数字里面的元素长度
            if(str.length() == 0 || str.length()> 3) return false;
            //但是在这里面需要判断一下是不是以0开头的 但是并不是说不可以是0
            if(str.length() > 1 && str.charAt(0) == '0') return false;

            //并且判断里面的每一个字符都不是字母
            for(int i = 0; i < str.length();i++){
                //如果包含英文字母、
                //如果出现了除数字以外的任何都是错误的
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return false;
                }
            }
            //数据范围的判定
            int num = Integer.parseInt(str);
            if(num < 0 || num > 255) return false;
        }

        return true;
    }
}
