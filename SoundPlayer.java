import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {

    Map<String, Clip> sounds;

    String backGroundMusic;

    public SoundPlayer() {
        backGroundMusic = "ClassicalBackgroundMusic.wav";
        sounds = new HashMap<String, Clip>();
        addSound(backGroundMusic);
    }

    public void addSound(String relPath) {
        try {
            addSoundHelper(relPath);
        } catch (UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addSoundHelper(String relPath) throws
        UnsupportedAudioFileException, IOException, LineUnavailableException {

        Clip clip = AudioSystem.getClip();
        AudioInputStream audioStream = AudioSystem.
            getAudioInputStream(new File(relPath).getAbsoluteFile());

        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        sounds.put(relPath, clip);

    }

    public void playBackgroundMusic() {
        Clip clip = sounds.get(backGroundMusic);
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } else {
            System.out.println("The background music can't be played.");
        }
    }
}
