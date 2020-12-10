package test;

import model.RandomPlay;
import model.read;

import java.util.Arrays;

/**
 * 测试是否打乱了文件
 */
public class RandomTest {
    public static void main(String[] args) throws Exception {
        String str = "E:\\javacode\\JavaCurriculumDesign\\MP3";
        read r = new read();
        String[] file = r.readFile(str);

        RandomPlay randomPlay = new RandomPlay();
        randomPlay.getRandom(file);

        System.out.println(Arrays.toString(file));

    }
}
