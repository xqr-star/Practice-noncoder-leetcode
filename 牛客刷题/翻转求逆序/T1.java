import java.util.Scanner;

public class T1 {
    //翻转求逆序数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //初始化数组
        for (int i =0;i <  n;i++){
            arr[i] = i+1;
        }
        int count = sc.nextInt();
        while (count > 0){
            int fromIndex = sc.nextInt()-1;
            int endIndex = sc.nextInt()-1;
            while (fromIndex < endIndex){
                int temp = arr[fromIndex];
                arr[fromIndex] = arr[endIndex];
                arr[endIndex] = temp;
                fromIndex++;
                endIndex--;
            }
            count--;
        }
        //寻找数组中的逆序对的数量
        //性能不佳的的算法暴力
        for(int i = 0; i < n-1;i++){
            for(int j = i+1;j < n;j++){
                if(arr[i]  > arr[j]){
                    count++;
                    System.out.printf("%d %d",arr[i],arr[j]);
                }
                System.out.println();
            }
        }
        System.out.println(count);
    }

}
