package pachet1.tjts;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

public class Sound {

    private Clip clip;

    public Sound(String path) {
        try {
            AudioInputStream ais = getAudioInputStream(getClass().getResourceAsStream(path));

            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseFormat.getSampleRate(),16,baseFormat.getChannels(),
                    baseFormat.getChannels()*2,baseFormat.getSampleRate(),false);

            AudioInputStream dais = getAudioInputStream(decodeFormat, ais);

            clip = AudioSystem.getClip();
            clip.open(dais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if(clip==null) return;
        clip.stop();

        clip.setFramePosition(0);
        clip.start();
    }

    public void close() {
        stop();
        clip.close();
    }

    public void stop() {
        if(clip.isRunning()) clip.stop();
    }
}
