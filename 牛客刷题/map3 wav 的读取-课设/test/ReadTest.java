package test;

import model.read;

/**
 * 测试read
 */
public class ReadTest {
    public static void main(String[] args) throws Exception {
        String str = "E:\\javacode\\JavaCurriculumDesign\\MP3";
        read r = new read();
        r.readFile(str);
    }
}
