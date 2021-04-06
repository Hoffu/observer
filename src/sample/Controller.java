package sample;

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
    public Label status;
    public Button button;
    public Text circle;
    public MediaView media;
    public TextField startTimeInput;
    public Arc circleShape;
    private TimeServer timeServer;
    private boolean powerUp = true;
    private ComponentText componentText;
    private ComponentMusic componentMusic;
    private ComponentShape componentShape;
    private int startTime = 10;

    public void initialize() {
        timeServer = new TimeServer();
        componentText = new ComponentText(timeServer, circle);
        componentMusic = new ComponentMusic(timeServer, media, startTime);
        componentShape = new ComponentShape(timeServer, circleShape);
    }

    public void powerUpClicked(ActionEvent actionEvent) {
        if (powerUp) {
            if (tryParseInt(startTimeInput.getText())) {
                componentMusic.setStartTime(Integer.parseInt(startTimeInput.getText()));
            }
            powerUp = false;
            button.setText("Stop");
            status.setText("Активен");
            timeServer.attach(componentText);
            timeServer.attach(componentMusic);
            timeServer.attach(componentShape);
        } else {
            powerUp = true;
            button.setText("Start");
            status.setText("Неактивен");
            timeServer.detach(componentText);
            timeServer.detach(componentMusic);
            timeServer.detach(componentShape);
            componentMusic.stopPlayer();
        }
    }

    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
