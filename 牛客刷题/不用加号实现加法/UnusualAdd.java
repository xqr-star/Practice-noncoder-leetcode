package code;

public class UnusualAdd {
    public int addAB(int A, int B) {
        // write code here

        //先计算不带进位的
        int num1 = A ^ B;
        int num2 = (A & B)<< 1;

        if(num2 == 0 ){
            return num1;
        }
        return addAB(num1,num2);
    }
}
