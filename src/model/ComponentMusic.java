package model;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class ComponentMusic implements Observer {
    public MediaView mediaView;
    private Subject subject;
    private int startTime;

    public ComponentMusic(Subject subject, MediaView mediaView, int startTime) {
        this.subject = subject;
        this.mediaView = mediaView;
        this.startTime = startTime;
        Media media = new Media(new File("C:\\Users\\Hoffu\\Downloads\\Yakui The Maid - Continium.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        this.mediaView.setMediaPlayer(mediaPlayer);
    }

    public void set(Subject st) {
        subject.attach(this);
    }

    public void update(Subject st) {
        if(st == subject && st.getTimeState() >= startTime) {
            mediaView.getMediaPlayer().play();
        }
    }

    public void setStartTime(int value) {
        startTime = value;
    }

    public void stopPlayer() {
        mediaView.getMediaPlayer().pause();
    }
}
