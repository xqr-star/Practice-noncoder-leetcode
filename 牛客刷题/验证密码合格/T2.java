import java.util.*;

/**
 * 密码验证合格
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            boolean flag = isPassword(str);
            if(flag == true){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean isPassword(String str){
        int length = str.length();
        boolean count = isDifferernt(str);
        boolean mul = isMul(str);
        if(length >  8 && count == true && mul == false){
            return true;
        }
        return false;
    }

    //判断字串是否重复 -- 这个处理的是只要有重复的子字符串
    //但是要求是长度超过2 的子字符串
    //Xqr1*11--true
    //Xqr1*1  -- false
    private static boolean isMul(String str) {
       for(int i =0;i < str.length()-3;i++){
           //每次截取前三个 --然后判断其他字符串里面是否包含
           String temp = str.substring(i,i+3);//截取前三个
           //从第二个开始截取的原因  5555    555   555 包含了
           if(str.substring(i+1).contains(temp)){
               return  true;
           }
       }
       return false;
    }

    //int count = 0;//包括大写 +1//保罗小写+1//包括数字+1//包括其他+1
    //但是这样势必是要遍历所有
    //所有将他们当作一类处理
    private static boolean isDifferernt(String str) {
        Map<Integer,Boolean> map = new HashMap<>();
       for(int i =0; i< str.length();i++){
           char ch = str.charAt(i);
           if( ch >= 'A' && ch <= 'Z'){
               map.put(1,true);
           } else if (ch >= 'a' && ch <= 'z') {
               map.put(2,true);
           }else if(ch >='0' && ch <= '9'){
               map.put(3,true);
           }else {//特殊字符
               map.put(4,true);
           }
       }
       //最后判断map的大小
        if(map.size() >= 3){
            return true;
        }
        return false;

    }
}
