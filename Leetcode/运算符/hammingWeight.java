//剑指 Offer 15. 二进制中1的个数
public class hammingWeight {
    public static void main(String[] args) {

    }


    public static int hammingWeight(int n) {
      int count = 0;
      for(int i = 0; i < 32;i++){
         if ((n & (1<< i)) != 0){
             count++;
         }
      }
      return count;
    }
}
