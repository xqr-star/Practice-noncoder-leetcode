package code;

public class T1 {
    /**
     * 实现加法不用加号
     * @param args
     */
    public static void main(String[] args) {

        int a = 11;
        int b = 29;
        int  sum = addAB(a,b);
        System.out.println(sum);

    }

    private static int addAB(int A, int B) {

        //两个数字按位异或--得到没有计算进制的数字
        int  手动计算无进制 = A ^ B;

        // 两个数字按位与得到需要进制的数字 同时将这个数字左移一位
        int 进制 = (A & B) << 1;

        // 加起来  A+ B=  手动计算无进制+ 进制 (这些都是二进制）

        //之后继续进行先异或 后 进制 的运算
        if(进制 == 0) {
            return 手动计算无进制;
        }

        return addAB(手动计算无进制 ,进制);

    }


}
