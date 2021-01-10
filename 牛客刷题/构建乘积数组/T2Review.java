package code;

public class T2Review {
    public int[] multiply(int[] A) {
        int [] b = new int[A.length];

        b[0] = 1;
        //先计算下半部分--对应的是前半部分让
        for(int i =1;i < A.length;i++){
            b[i] = b[i-1] * A[i-1];
        }

        //然后计算上半部分 -- 对应的是后半部分
        int temp = 1;
        //length-1 不用再计算后面了已经结束了
        for(int j = A.length-2 ; j >=0;j--){ //0的值必须要包含
            temp  *= A[j+1];
            b[j] *= temp;
        }
        return b;
    }

}
