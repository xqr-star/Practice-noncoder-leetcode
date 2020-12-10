package model;

import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Play {

    //这里的str 必须是随机化以后的名字
    //写两个方法
    public void playMp3(String str){
        try {
            //声明一个File对象
            File mp3 = new File("MP3\\"+str);

            //创建一个输入流
            FileInputStream fileInputStream = new FileInputStream(mp3);

            //创建一个缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //创建播放器对象，把文件的缓冲流传入进去 //调用播放方法进行播放
            new Player(bufferedInputStream).play(); //匿名对象 这里的play方法是包里面的
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playWav(String str) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = null;
        AudioFormat audioFormat = null;
        SourceDataLine sourceDataLine = null;
        DataLine.Info dataLine_info = null;

        File wavfile = new File("MP3\\"+str);
        audioInputStream = AudioSystem.getAudioInputStream(wavfile);
         //audioInputStream=AudioSystem.getAudioInputStream(new URL(wavfile));
        audioFormat = audioInputStream.getFormat();
        dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);

        //读Wav文件
        byte[] b = new byte[1024];
        int len = 0;

        sourceDataLine.open(audioFormat, 1024);

        while ((len = audioInputStream.read(b)) >= 0) {
            sourceDataLine.write(b, 0, len);
        }
        audioInputStream.close();

        sourceDataLine.drain();
        sourceDataLine.close();
    }
}
