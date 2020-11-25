import java.util.Scanner;

//Scanner 底层原理不太知道
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt(); //初始空瓶子的个数
            if(num >=2) System.out.println(countBottle(num));
        }

    }
    public static int countBottle(int num) {
        int count = 0;
        while (num >= 2) {
            if (num >= 3) {
                int temp = num / 3;//这是我可以换的汽水数字
                count = count + temp;
                //处理剩下瓶子的数量 = 本身除以三之后还剩下的和 我换到的汽水瓶子的数量
                //这才是下一次再去换瓶子的数量
                num = temp + (num % 3);
            } else {
                //可以借一个瓶子喝完再还回去 //(num = 2)
                count++;
                num = 0;//程序运行失败的原因是我用 num 作为循环的条件，但是去没有更改num 的值，自然会陷入死循环
            }
        }
        //跳出循环这里说明只有一个空瓶子了什么也做不了
       return count;
    }

//import java.util.Scanner;
//public class Main{


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt(); //初始空瓶子的个数
            int count = 0;
            int n = num;
            while (num >= 2) {
                if (num >= 3) {
                    int temp = num / 3;//这是我可以换的汽水数字
                    count = count + temp;
                    //处理剩下瓶子的数量 = 本身除以三之后还剩下的和 我换到的汽水瓶子的数量
                    //这才是下一次再去换瓶子的数量
                    num = temp + (num % 3);
                } else {
                    count++;
                    num = 0;//得处理这里不然怎么成功。
                }
            }
            if (n >= 2) {
                System.out.println(count);
                //处理的是如果输入不合法，还会打印count的发生
            }

        }

    }
}