package test;

import model.Play;
import model.RandomPlay;
import model.read;

public class PlayTest {
    /**
     * 对play 进行Test
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {

        String str = "E:\\javacode\\JavaCurriculumDesign\\MP3";
        read r = new read();
        String[] file = r.readFile(str);

        //打乱
        RandomPlay randomPlay = new RandomPlay();
        String[] fileAfter = randomPlay.getRandom(file);

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

            Play play = new Play();

            if("mp3".equals(substring)){
                play.playMp3(f); //这里的str 必须是随机化以后的名字
            }else if("wav".equals(substring)) {
                play.playWav(f);
            }
        }
    }
}
