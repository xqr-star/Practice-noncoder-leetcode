package 便利蜂;

import java.util.Scanner;

// 90
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(";");
        String [] arr1 = null;
        String [] arr2 = null;
        for (String str : split){
            if(!str.equals("")){
                String [] arr = str.split(",");
                if (arr1 == null){
                    arr1 = arr;
                }else {
                    arr2 = arr;
                }
            }
        }



        if(arr2 == null){
            int[] array1 = new int[arr1.length];
            for(int i = 0; i< array1.length;i++){
                array1[i] = Integer.parseInt(arr1[i]);
            }
            System.out.println(array1[3]);
            return;
        }

        int[] array1 = new int[arr1.length];
        for(int i = 0; i< array1.length;i++){
            array1[i] = Integer.parseInt(arr1[i]);
        }



        int[] array2 = new int[arr2.length];
        for(int i = 0; i< array2.length;i++){
            array2[i] = Integer.parseInt(arr2[i]);
        }


        int[] res = new int[array1.length+array2.length];
        int index = 0;
        int left = 0;
        int right = 0;
        while (left < array1.length && right < array2.length){
            if(array1[left] <= array2[right]){
                res[index++] = array1[left];
                left++;
            }else {
                res[index++] = array1[right];
                right++;
            }
        }
        while (left < array1.length){
            res[index++] = array1[left];
            left++;
        }

        while (right < array2.length){
            res[index++] = array2[right];
            right++;
        }



        System.out.println(res[3]);



    }
}
