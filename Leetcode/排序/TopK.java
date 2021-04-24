import java.util.Arrays;

public class TopK {
     //方式一：最直接方法，先将整体排序，再输出前k个元素，直接使用快排
//     public int[] getLeastNumbers(int[] arr, int k) {
//         quickSort(arr,0,arr.length-1);
//         int[] res = new int[k];
//         for(int i = 0; i < k;i++){
//             res[i] = arr[i];
//         }
//         return res;
//     }
//
//     public static void quickSort(int[] arr,int left,int right){
//         if(left >= right)return;
//         int i = left,j = right;
//         while(i < j){
//             while(i < j && arr[j] >= arr[left])j--;
//             while(i < j && arr[i] <= arr[left])i++;
//             swap(arr,i,j);
//         }
//         swap(arr,i,left);
//         quickSort(arr,left,i-1);
//         quickSort(arr,i+1,right);
//     }
//     public static void swap(int[] arr,int i,int j){
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//    方式二：快排的优化版本，也是效率最高的一个方法
//    因为我们只需要找到前K个数字，所以只需要去判断基准值partition结束后所在位置与k值的大小比，
//    如果k==i，那么就可以直接返回，如果k < i，说明前k个元素在左侧，那么就只需要对左半部分进行快排就好了，反之同理。
     public int[] getLeastNumbers(int[] arr, int k) {
         if(k >= arr.length)return arr;
         return quickSort(arr,0,arr.length-1,k);
     }
     public static int[] quickSort(int[] arr,int left,int right,int k){
         int i = left,j = right;
         while(i < j){
             while(i < j && arr[j] >= arr[left])j--;
             while(i < j && arr[i] <= arr[left])i++;
             swap(arr,i,j);
         }
         swap(arr,i,left);
         if(i > k)return quickSort(arr,left,i-1,k);
         if(i < k)return quickSort(arr,i+1,right,k);
         return Arrays.copyOf(arr,k);
     }
     public static void swap(int[] arr,int i,int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }

    //方法三：堆排
    // public int[] getLeastNumbers(int[] arr, int k) {
    //     if(k == 0)return new int[k];
    //     if(k >= arr.length) return arr;
    //     //1.建大堆，使得最大值在数组第一个位置
    //     createBigHeap(arr);
    //     //2.进行堆排
    //     for(int i = 0;i < arr.length-1;i++){
    //         int temp = arr[0];
    //         arr[0] = arr[arr.length-i-1];
    //         arr[arr.length-i-1] = temp;
    //         adJustDown(arr,0,arr.length-i-1);
    //     }

    //     //3.返回前k个数
    //     return Arrays.copyOf(arr,k);
    // }

    // //建大堆
    // public static void createBigHeap(int[] arr){
    //     int lastIndex = arr.length-1;
    //     int lastPIndex = (lastIndex-1)/2;
    //     int size = arr.length;
    //     while(lastPIndex >= 0){
    //         adJustDown(arr,lastPIndex,size);
    //         lastPIndex--;
    //     }
    // }
    // //向下调整
    // public static void adJustDown(int[] arr,int index,int size){
    //     int leftIndex = index*2+1;
    //     //1.判断当前位置是否为叶子节点
    //     while(leftIndex < size){
    //         //找子节点中最大的那个
    //         int maxIndex = leftIndex;
    //         int rightIndex = leftIndex + 1;
    //         if(rightIndex < size && arr[rightIndex] > arr[maxIndex]){
    //             maxIndex = rightIndex;
    //         }
    //         //判断最大值是否大于根节点，如果大于等于则直接返回
    //         if(arr[index] >= arr[maxIndex])break;
    //         //到这里说明是小于，所以与子节点进行交换
    //         int temp = arr[index];
    //         arr[index] = arr[maxIndex];
    //         arr[maxIndex] = temp;

    //         //将index设置为maxIndex
    //         index = maxIndex;
    //         leftIndex = index*2 + 1;
    //     }
    // }

    //方式四：堆的优化版，时间复杂度为O(nlogk)
    //步骤一：维护一个含有k个元素的大根堆
    //步骤二：将数组依次遍历，与大根堆的首元素（最大值）进行比较，如果比最大值小，则交换，并向下调整
    //如果没有则继续向后遍历。

//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(k == 0)return new int[k];
//        if(k >= arr.length)return arr;
//
//        //建一个含有k个元素的大根堆，也就是arr的前k个元素
//        int[] res = new int[k];
//        for(int i = 0;i < k;i++){
//            res[i] = arr[i];
//        }
//        createBigHeap(res);
//        for(int i = k;i < arr.length;i++){
//            if(arr[i] < res[0]){
//                res[0] = arr[i];
//                adJustDown(res,0,k);
//            }
//        }
//        return res;
//    }
//    //建大堆
//    public static void createBigHeap(int[] arr){
//        int lastIndex = arr.length-1;
//        int lastPIndex = (lastIndex-1)/2;
//        int size = arr.length;
//        while(lastPIndex >= 0){
//            adJustDown(arr,lastPIndex,size);
//            lastPIndex--;
//        }
//    }
//    //向下调整
//    public static void adJustDown(int[] arr,int index,int size){
//        int leftIndex = index*2+1;
//        //1.判断当前位置是否为叶子节点
//        while(leftIndex < size){
//            //找子节点中最大的那个
//            int maxIndex = leftIndex;
//            int rightIndex = leftIndex + 1;
//            if(rightIndex < size && arr[rightIndex] > arr[maxIndex]){
//                maxIndex = rightIndex;
//            }
//            //判断最大值是否大于根节点，如果大于等于则直接返回
//            if(arr[index] >= arr[maxIndex])break;
//            //到这里说明是小于，所以与子节点进行交换
//            int temp = arr[index];
//            arr[index] = arr[maxIndex];
//            arr[maxIndex] = temp;
//
//            //将index设置为maxIndex
//            index = maxIndex;
//            leftIndex = index*2 + 1;
//        }
//    }
}
