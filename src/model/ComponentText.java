package model;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ComponentText implements Observer {
    public Text circle;
    private Subject subject;

    public ComponentText(Subject subject, Text circle) {
        this.subject = subject;
        this.circle = circle;
        circle.setFont(Font.font("Calibri", 30));
        circle.setEffect(new GaussianBlur(4));
    }

    public void set(Subject st) {
        subject.attach(this);
    }

    public void update(Subject st) {
        if(st == subject) {
            circle.setText("Прошло " + st.getTimeState() + " с");
        }
    }
}
