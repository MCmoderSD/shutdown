package functions;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class player {
    Clip clip;

    public void play(URL url) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}