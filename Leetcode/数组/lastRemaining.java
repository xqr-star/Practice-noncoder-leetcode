
//剑指 Offer 62. 圆圈中最后剩下的数字
public class lastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }


    //通过反推 可以得出哟啊删除的哪个数字 在之前数组的哪一个位置上

    /**
     * 最后结束的时候 要删除的数字的是index=0 size = 1
     * 上一次的时候 要删除的数字的index = (上一个index + m) & 当前的数组长度
     * @param n
     * @param m
     * @return
     */
    public  static int lastRemaining(int n, int m) {
        //初始的状态 res = 0
        int res = 0;

        //删除了 n-1 个数字所以递推n-1次
        for(int i = 2; i<= n;i++){
            res = (res +m)%i;
        }

        //因为 我们假设的数组里面的数字是和下标一一对应的
        //也就是说数字的排列是从0开始的 所以下标是3 自然对应的数字也是3
        return res;
    }

    /**
     * error 以下的是错的！
     * @param n
     * @param m
     * @return
     */
    public  static int lastRemaining1(int n, int m) {
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = i;
        }
        int startIndex = 0;
        int count = 0;//当前遍历到了数字里面的第几个
        int sum = n-1;//需要总共删除的次数
        while(sum > 0){
            while(count  <m-1 ){ //不断的去找第三个数字
                if(startIndex == n){
                    startIndex = 0;
                }
                if(arr[startIndex] != -1){
                    count++;
                }
                startIndex++;
            }
            if(startIndex == n){
                startIndex = 0;
            }
            arr[startIndex] = -1;
            count = 0;
            startIndex ++;
            if(startIndex > n-1){
                startIndex = 0;
            }
            //总的删除的轮次
            sum--;
        }

        //最后遍历一遍找出不是-1 的那一给数字返回
        for(int num : arr){
            if(num != -1){
                return num;
            }
        }
        return -1;
    }
}
