
//275. H 指数 II
public class hIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,5,6};
        System.out.println(hIndex(arr));
    }
    public static int hIndex(int[] citations) {
        //思路 ： 在数组中找到一个数字 h
        // 使得至少存在h个数字 大于等于h
        //check 函数
        //检查 mid 的值 和 right-mid+1  的个数是否一致
        int length = citations.length;
        int left = 0;
        int right = length-1;
                                        
        int mid = 0;
        int count = 0;
        if(length == 0 || citations[length-1] == 0) return 0;
        while(left < right){
            mid = (left+right)/2;
            count = length-mid; //论文个数
            // 表示的含义是 大于等于mid 的个数 <= mid 那么区间要往左边查找
            if(citations[mid] >= count) right = mid;
            else left = mid+1;
        }
        return length - left;

    }
}
