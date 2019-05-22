package forfile;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * @author BORBER
 * @version 1.0.0
 * @ClassName PlayMusic.java
 * @Description TODO
 * @createTime 2019年05月22日 12:56
 */
public class PlayMusic {

    public static void play(String filepath){
        /**
         * @title play
         * @description 播放一次音乐
         * @author BORBER
         * @param: filepath
         * @updateTime 2019/5/22 13:45
         * @throws
         */

        File file = new File(filepath);
        AudioClip audioClip = null;
        try {
            audioClip = Applet.newAudioClip(file.toURL());
            audioClip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static void playloop(String filepath){

        /**
         * @title playloop
         * @description 循环播放音乐 考虑加入 时间变量来控制
         * @author BORBER
         * @param: filepath
         * @updateTime 2019/5/22 13:45
         * @throws
         */
        File file = new File(filepath);
        AudioClip audioClip = null;
        try {
            audioClip = Applet.newAudioClip(file.toURL());
            audioClip.loop();
            Thread.sleep(5000);
        } catch (MalformedURLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
