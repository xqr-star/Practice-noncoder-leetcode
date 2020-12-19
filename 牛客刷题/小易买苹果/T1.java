import java.util.Scanner;

public class T1 {
    /*小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，
    只提供6个每袋和8个每袋的包装(包装不可拆分)。
    可是小易现在只想购买恰好n个苹果，
    小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，
    小易将不会购买。*/
    //本质其实还是在找规律
    // 被 6 8 除以的数字要么整数 要么组合处 一定得是一个偶数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(buyApple(num));

    }
    public static int buyApple(int num){
        //先处理所有的奇数  对于小于10 的偶数进行处理
        if(num %2 !=0  || num == 10 || num < 6) {
            return -1;
        }

        //之后处理可以被8 整除的
        if(num % 8 == 0) {
            return  num/8;
        }
        //在这处理不能被8整除的数字

        //====对已下的东西进行合并处理
        return num/8 + 1;
        //---
        //如果不能被8整除 那么余数 只有可能是 2 4 6 （因为我上已经对所有的奇数处理过滤了）
        /*if(num % 8 == 6) {
            return num/8 + 1;
        }
        if(num % 8 == 4) {  //往上借一个8  8 + 4 =12 / 6 = 2  然后再加个2
            return num/8 -1 + 2;
        }
        if(num % 8 == 2) {  //往上借两个8  8 + 8 + 2 = 18 / 6 =3 然后再加3
            return num/8 - 2 + 3;
        }*/
    }

}
