package day39;

//二维数组的打印
public class 二维数组的打印 {
    public static void main(String[] args) {
        int n = 4;
        int[] [] arr = new int[n][n];
        int count =1;
        for(int i =0 ;i < n;i++){
            for(int j = 0;j < n ;j ++){
                arr[i][j] = count++;
            }
        }
        arrayPrint(arr,n);
    }
    public static int[] arrayPrint(int[][] arr, int n) {
        int [] res = new int[n*n];
        // write code here
        //起点的坐标
        int startX = 0;
        int startY = n-1;
        int index = 0;
        while(startX <= n-1 && startY >= 0){
            //这里确定是是每一行的起始坐标
            int tempX = startX;
            int tempY = startY;
            //这里开始将每一个斜对角线上的数据进行打印
            while (tempX <= n-1 && tempY <= n-1){
                res[index++] = arr[tempX][tempY];
                tempX++;
                tempY++;
            }
            //这里开始对对角线的定点元素进行更新
            if(startY>0){
                startY--;
            }else {
                startX++;
            }
        }
        return res;
    }

}
