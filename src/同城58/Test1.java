package 同城58;

//整型数字 重复将每位数字相加 直到最终的结果是个位数字
public class Test1 {
    public static void main(String[] args) {
        System.out.println(digitsRecursive(123456));
    }
    public static int digitsRecursive (int num) {
        // write code here
        int res = num;
        int temp = 0;
        while (res / 10 != 0 ){
            while (res != 0){
                temp += res %10;
                res=  res /10;
            }
            res = temp;
            temp = 0;
        }
        return res;
    }
}
