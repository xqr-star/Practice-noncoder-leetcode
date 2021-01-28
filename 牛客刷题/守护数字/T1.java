import java.util.Scanner;

//判断守护数字
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            boolean flag = isShouXing(num);
            if(flag == true){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
    public static boolean isShouXing(int num ){
        int mul = num * num;
        int temp = mul % 10;
        if( num < 10) { //
            return num== temp;
        }
        //走到下面默认的是有两位数字，但是一位数字的情况也要处理
        mul = mul /10;
        temp += (mul%10)*10;
        return temp == num;
    }


    /*
    代码更加精简
     */
    public static boolean isShouXing2(int num ){
        //转换成字符串
        int temp = num * num;
        if(String.valueOf(temp).endsWith(String.valueOf(num)))
            return true;
        return false;
    }
}


