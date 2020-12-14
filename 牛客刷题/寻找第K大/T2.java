package code;

public class T2 {

    /**
     *这种解法不够高效，它做到的是把整个数组排有序了，但因为我是寻找第K 大
     * 所以要么保证前面的只有有n-k 个比K 小，后面的有没有顺序不重要
     * 优化版的写错了
     */

    //参考

    /*public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, K);
    }

    public int findKth(int[] a, int low, int high, int k) {
        int part = partation(a, low, high);
        if (k == part - low + 1) return a[part];
        else if (k > part - low + 1) return findKth(a, part + 1, high, k - part + low - 1);
        else return findKth(a, low, part - 1, k);
    }*/

    //大的在前，小的在后
    /*public int partation(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] <= key) high--;
            a[low] = a[high];
            while (low < high && a[low] >= key) low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }*/


    // 优化版的是 快排 + 二分查找  待优化 hover 法


   /* public int findKth(int[] a, int n, int K) {
        // write code here
        int leftIndex = 0;
        int rightIndex = a.length-1;
        quickSortInternal(a,leftIndex,rightIndex,K);//每次排序的时候都要带着我的key 进行比较 判断我还要不要继续往下排序
        return a[K-1]; // 排序拍出来的数据是从小到大，倒着数的 第K 大 的注意索引
    }

    //排序执行的的是从大到小排
    private void quickSortInternal(int[] a, int leftIndex, int rightIndex,int k) {
        int size = rightIndex - leftIndex +1;
        if(size >= 1) {
            return;
        }
        //执行partition
        int partKey = partation(a,leftIndex,rightIndex); // partKey返回的是索引

        //类似二分查找的思路
        if(partKey == (k-1) ) {
            return;
        }else if(partKey > (k-1)) {
            quickSortInternal(a,leftIndex,partKey-1,k);
        }else if(partKey < (k-1)) {
            quickSortInternal(a,partKey+1,rightIndex,k);
        }

    }


    private int partation(int[] a, int leftIndex, int rightIndex) {
        int keyIndex = leftIndex; // 拿最左边的数字作为基准
        int key = a[leftIndex];//不是a[0]
         while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && a[rightIndex] <= key) {
                rightIndex --;
            }
             while (leftIndex < rightIndex && a[leftIndex] >= key) {
                 leftIndex ++;
             }

             //前面找到了比key 小的 后面找到了比key 大的 开始交换
             int temp = a[leftIndex];
             a[leftIndex] = a[rightIndex];
             a[rightIndex] = temp;
        }
         //right Index== left Index 的时候，找到了基准该在的位置
        int temp = a[leftIndex];
        a[leftIndex] = key;
        a[keyIndex] = temp;

        return  leftIndex;
    }
*/

    public int findKth(int[] a, int n, int K) {
        // write code here
        int leftIndex = 0;
        int rightIndex = a.length-1;
        quickSortInternal(a,leftIndex,rightIndex);
        return a[n-K]; // 排序拍出来的数据是从小到大，倒着数的
    }

    private static void quickSortInternal(int[] arr, int leftIndex, int rightIndex) {

        //以下位递归的出口
        int size = rightIndex - leftIndex + 1;
        if(size <= 1) {
            return;//也就是递归的出口
        }

        int key = partition(arr,leftIndex,rightIndex);

        //分别对左右区间进行quickSort
        quickSortInternal(arr,leftIndex,key-1);
        quickSortInternal(arr,key+1,rightIndex);

    }

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        int keyIndex = leftIndex;
        int key = arr[leftIndex]; // 以第一个元素作为基准//不是arr[0]

        // 左右下标一起寻找的方法
        while (leftIndex < rightIndex){
            while(leftIndex < rightIndex && arr[rightIndex] >= key ) {
                rightIndex -- ;
            }
            while(leftIndex < rightIndex  && arr[leftIndex] <= key ) {
                leftIndex ++;
            }
            //左边找到了比基准值大的 ， 右边找到了比基准值小的 就执行交换的功能
            int temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;
        }

        //从头到尾i而我都没有动过key 的位置 当两个相遇的时候，我就可以交换了
        // 6 5 8 4 9
        //5 4 9
        int temp = arr[leftIndex];
        arr[leftIndex] = key;
        arr[keyIndex] = temp;

        //最后返回的应该是基准所在的下标

        return leftIndex;
    }


}
