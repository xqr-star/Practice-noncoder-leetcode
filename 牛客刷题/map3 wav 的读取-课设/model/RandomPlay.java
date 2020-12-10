package model;

import java.util.Random;

//获取随机的音频
public class RandomPlay {

    //files 是文件名数组

    //文件随机化 -- 对文件名随机化
    public String[] getRandom(String [] files) {
        shuffle(files);
        return  files;  //返回随机文件 然后
    }

    public void shuffle (String[] arr) {
        Random rand = new Random();
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }

    public void swap(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }





}
