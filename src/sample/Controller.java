package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import model.ComponentMusic;
import model.ComponentShape;
import model.ComponentText;
import model.TimeServer;

public class Controller {
    public Text status;
    public Text circle;
    public MediaView media;
    public TextField startTimeInput;
    public Arc circleShape;
    public Button musicButton;
    public Button animationButton;
    public Button textButton1;
    private TimeServer timeServer;
    private boolean powerUp = true;
    private boolean textButton = true;
    private boolean music = true;
    private boolean animation = true;
    private ComponentText componentText;
    private ComponentMusic componentMusic;
    private ComponentShape componentShape;
    private int startTime = 30;

    public void initialize() {
        timeServer = new TimeServer();
        timeServer.attach(new ComponentText(timeServer, status, false));
        componentText = new ComponentText(timeServer, circle, true);
        componentMusic = new ComponentMusic(timeServer, media, startTime);
        componentShape = new ComponentShape(timeServer, circleShape);
    }

    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void animationButtonClicked(ActionEvent actionEvent) {
        if (animation) {
            animation = false;
            animationButton.setText("Stop");
            timeServer.attach(componentShape);
        } else {
            animation = true;
            animationButton.setText("Start");
            timeServer.detach(componentShape);
        }
    }

    public void musicButtonClicked(ActionEvent actionEvent) {
        if (music) {
            if (tryParseInt(startTimeInput.getText())) {
                componentMusic.setStartTime(Integer.parseInt(startTimeInput.getText()));
            }
            music = false;
            musicButton.setText("Stop");
            timeServer.attach(componentMusic);
        } else {
            music = true;
            musicButton.setText("Start");
            timeServer.detach(componentMusic);
            componentMusic.stopPlayer();
        }
    }

    public void textButtonClicked(ActionEvent actionEvent) {
        if (textButton) {
            textButton = false;
            textButton1.setText("Stop");
            timeServer.attach(componentText);
        } else {
            textButton = true;
            textButton1.setText("Start");
            timeServer.detach(componentText);
        }
    }
}
