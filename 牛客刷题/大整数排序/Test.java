package day30;

public class Test {
    //关于字符串的compareTo 的使用

    public static void main(String[] args) {


        //默认比较第一个字符的大小
        System.out.println("5111".compareTo("4111113"));// 1

        //如果第一个相同才继续往后比较
        System.out.println("51111".compareTo("51112"));// -1



    }
    private static void bubble(int[] arr) {
        //无序区间 [i ,arr.length]
        //有序区间[0,i)
        for(int i = 0; i < arr.length-1;i++){ //多少个数字需要比较
            for(int j =0 ;j< arr.length-1 - i;j++){
                if(arr[j]>(arr[j+1]) ){ //表示前面的数字大
                    //执行交换的逻辑
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        //对数字进行输出
        for(int i: arr){
            System.out.println(i);
        }
    }
}
