package day08;

public class plusOne {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        plusOne(arr);
    }
    /*8
    这下面写
     */
    public  static int[] plusOne(int[] digits) {
        for(int i = digits.length-1 ;i >=0;i--){
            digits[i] ++;//自++
            if(digits[i] / 10 == 0){ //看他有没有进位
                return digits;
            }
            //如果有进位的话 那么不返回上面继续++
            digits[i] = digits[i]%10;
        }
        //如果还不返回
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }
}
