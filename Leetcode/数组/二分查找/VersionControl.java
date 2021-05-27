//278. 第一个错误的版本
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        //尽量少的调用一个函数那么其实本质就是搜索比较的次数尽量少 二分
        while(left < right){
            mid = left + (right-left)/2;
            if(isBadVersion(mid) == true){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
