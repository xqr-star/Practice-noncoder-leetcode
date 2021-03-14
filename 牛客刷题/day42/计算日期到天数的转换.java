package day42;

import java.util.Scanner;

/**
 * 难度低 关键是想到用一个数组来存储每一个月份对应的日期
 */

public class 计算日期到天数的转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            //首先对输入的字符进行校验
            if(year<=0 ||month <=0||month >12||day <=0 ||day>31){
                System.out.println("-1");
            }else{
                int res = method(year,month,day);
                System.out.println(res);
            }

        }

    }

    //首先先判断以下这个年是闰年还是什么年
    //如果是闰年 那么是二月有29天 如果不是就还是28天
    private static int method(int year, int month, int day) {
        int[] monthCalculator = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeap(year)){
            monthCalculator[1] = 29;
        }
        int sum = 0;
        //不能从当月计算
        //因为有可能当月还没满
        month--;
        while (month >= 1){
            sum += monthCalculator[month-1]; // 比如刚开始是六月 arr5
            month--;
        }
        sum += day;
        return sum;
    }
    //一般的,能被4整除的年份是闰年,不能被4整除的年份是平年
    //如果是世纪年(也就是整百年),就只有能被400整除才是闰年,否则就是平年.
    private static boolean isLeap(int year) {
        //能被4整除但不能被100 整除
        //或者是能被400整除
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ){
            return true;
        }
        return false;
    }
}
