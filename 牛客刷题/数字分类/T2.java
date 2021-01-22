import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] arr = new int[num];
        //数据录入
        for(int i = 0; i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        //数据处理
        int a1 = 0; int a2= 0; int a3 = 0; int a4 = 0; int a5 = -1;
        double a6 = 0;
        int flag = 1;

        for(int e : arr){
            if(e %10 == 0){
                a1 += e;
            }else if( e % 5 ==1 ){
                a2 += e*flag;
                flag = -flag;
            }else if( e % 5 == 2){
                a3++;
            }else if(e % 5 == 3){
                a6 += e;
                a4 ++;
            }else{
                if(e> a5){
                    a5 = e;
                }
            }
        }

        //没有考虑入股哦出现a4 或者 a6 都是 0 的情况
        //会出现new 传进去的参数 无穷大或者0

//        //保留小数位数
//        BigDecimal b = new BigDecimal(a6/a4);
//        //这里必须用double
//        a6= b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.print(a1 > 0?a1+" ":"N ");
        System.out.print(a2 !=0?a2+" ":"N ");
        //注意这里不能用大于0来判断 正负交替相加，可能会出现小于0的情况
        //但一定不出出现 == 0 的情况，因为数字大小都不一样
        //所以如果还是等于0 就说明是a2 的逻辑就没有满足的数字
        System.out.print(a3>0?a3+" ":"N ");
        if(a4 > 0){
            System.out.printf("%.1f",a6/a4);
        }else {
            System.out.printf("N ");
        }

        System.out.print(a5>0?a5:"N");

    }
}

