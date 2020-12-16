package code;

/**
 * 给定一个int数组A和它的大小n，对于这组数能组成的任意两个数组，
 * 若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 请设计一种高效的算法返回A中存在的逆序对个数。
 */
public class AntiOrder {
    public int count(int[] A, int n) {
        //先对给定的数组的大小进行判断
       if(A.length <= 1) {
           return 0;
       }
//       }else if(n > 500) {
//           // 还没有处理个数如果比500大的时候应该怎么办
//       }
       int low = 0;
       int high = A.length;
       // 如果不是数组中只有一个元素的话，那就对数组进行拆分
        return mergerInternal(A,low,high);// 返回拆分之后的逆序对的个数
    }

    /**
     * [low,high)
     * @param a
     * @param low
     * @param high
     * @return 逆序对的个数
     */
    private int mergerInternal(int[] a, int low, int high) {
        int length = high -low;
        if(length <= 1) {
            return 0; //表明的是如果数组里面只有一个元素，那么逆序对的个数是0
        }


        //通过调整传进去的参数，把数组进行拆分 -- 拆分的时候怎么统计逆序对的个数
        int mid = (low + high)/2;
        int leftCount = mergerInternal(a,low,mid); // 统计分割的左边数组中逆序对个个数
        int rightCount = mergerInternal(a,mid,high); // 统计分割的右边数组中逆序对个个数
        int newMergeCount = merge(a,low,mid,high); // 统计合并之后新的数组中的逆序对的个数

        return leftCount + rightCount + newMergeCount;
    }
    //具体的统计逆序对的操作时在merge里面做的
    private int merge(int[] arr,int low,int mid,int high) {
        int count = 0 ; //统计逆序对的个数
        int i= low;
        int j = mid; // 注意这里可不是j = mid
        int[] extra = new int[high - low];
        int k = 0;

        while (i < mid && j < high){
            if(arr[i] <= arr[j]) {
                extra[k++] = arr[i++];
            }else {
                //arr[i] > arr[j] 对于有序的来说 当我最小的数字比你最小的数字还要大的时候，就可以说明什么
                //s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                count += mid-i;
                extra[k++] = arr[j++];
            }
        }

        //剩下的元素都搬过来
        while (i < mid) {
            // 那就把第一个有序数组的元素都放到额外数组后面去
            extra[k++] = arr[i++];
        }
        while (j < high) {
            //那就把第二个有序数组整个放到额外数组里面去
            extra[k++] = arr[j++];
        }

        // 最后把数组放回去
        for(int t = 0;t <high - low; t++) {
            arr[low + t] = extra[t];
        }
        return count;
    }


}
