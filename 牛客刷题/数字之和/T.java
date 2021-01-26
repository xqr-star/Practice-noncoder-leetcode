import java.util.Scanner;

public class T {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            //BigInteger bigInteger = new BigInteger(String.valueOf(num));
            System.out.print(numberSum(num)+" ");

            int num2 = num* num;

            System.out.print(numberSum(num2));
            System.out.println();
        }

    }


    public static int numberSum(int num){
        int sum =0;
        if(num <= 9){
            return num;
        }else{
            //获取每一位
            sum += numberSum(num % 10);
            num = num /10;
            sum += numberSum(num);
        }
        return sum;
    }
}

