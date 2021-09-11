package 同城58;

//找出最后一个指定的数

public class Test2 {
    public static void main(String[] args) {
//        int[] arr = new int[]{9,9,1,2,3,4,5,6,7};
//        int[] arr = new int[]{1,1,2};
        int[] arr = new int[]{1,1};
//        int[] arr = new int[]{1,1,2,2};

        System.out.println(solution(arr));
    }

    public  static int solution (int[] source) {
        // write code here
        int res = -1;
        if(source == null) return -1;
        if(source.length == 0) return -1;
        if(source.length == 1) return source[0];

        int left = 0;
        int right = 1;
        while (right < source.length){
            if(source[left] != source[right]){
                res = source[left];
            }
            while (right < source.length && source[left] == source[right]){
                right++;
            }
            left = right;
            right = right + 1;
        }

        if(left == source.length -1) res = source[left];
        return res;


    }
}
