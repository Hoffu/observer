package model;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ComponentText implements Observer {
    public Text circle;
    private Subject subject;

    public ComponentText(Subject subject, Text circle, boolean check) {
        this.subject = subject;
        this.circle = circle;
        if(check) {
            this.circle.setFont(Font.font("Calibri", 30));
            this.circle.setFill(Color.DARKCYAN);
        }
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
