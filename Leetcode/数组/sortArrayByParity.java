package day07;

public class sortArrayByParity {
    public static void main(String[] args) {
        solution(new int[]{3,1,2,4});

    }
    public static int[] solution(int[] A) {
        int left =0;
        int right = A.length-1;
        while(left <= right){
            //找偶数
            while(left <= right && A[right] % 2 != 0){
                right --;
            }//跳出循环说明是偶数

            //找奇数
            while(left <= right && A[left] % 2 == 0){
                left ++;
            }//跳出说明是奇数

            //将两个数字进行交换
            if(left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                //这里不用进行++ -- 到上面的时候自己会进行迭代的
            }
        }
        return A;

    }
}
