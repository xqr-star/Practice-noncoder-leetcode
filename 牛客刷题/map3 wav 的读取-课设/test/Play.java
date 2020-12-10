package test;

import model.RandomPlay;
import model.read;

import java.util.Arrays;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件夹及其路径(输入quit 退出：)");

        String str = scanner.nextLine();

        //判断用户输入是否合法

        if ("E:\\javacode\\JavaCurriculumDesign\\MP3".equals(str)) {
            read r = new read();
            String[] file = r.readFile(str);

            //打乱
            RandomPlay randomPlay = new RandomPlay();
            String[] fileAfter = randomPlay.getRandom(file);
            System.out.println(Arrays.toString(fileAfter)); // 对打乱后的进行打印方便用户观看

            String substring = null;
            for(String f : fileAfter) {
                //对字符串进行截取后三个
                int length = f.length();
                if(length>=3){
                    substring = f.substring(length-3,length);
                    System.out.println(str);

                }else{
                    System.out.println("字符串长度不足截取");
                }

                model.Play play = new model.Play();

                if("mp3".equals(substring)){
                    play.playMp3(f); //这里的str 必须是随机化以后的名字
                }else if("wav".equals(substring)) {
                    play.playWav(f);
                }
            }
        } else {
            System.out.println("输入不合法");
        }
    }
}
