package code;

/**
 * 构建乘积数组
 */

import java.util.Arrays;

public class T2 {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(a));
        int[] B = multiply(a);
        System.out.println(Arrays.toString(B));
    }

    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] b = new int[length];


        for(int i = 0 ; i< A.length;i++) {
            b[i] = constructNum(i,A); // 传进去的i 表示不要乘那个i
        }
        return b;
    }

    public static int constructNum(int i, int[] a){
        int num = 1;
        //遍历A数组
        for(int j =0; j < a.length;j++) {
            if( j == i ){
                continue;
            }
            num *= a[j];
        }
        return num;
    }

}
