package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

public class ComponentShape implements Observer {
    private Subject subject;
    private Arc arc;
    private int angle = 0;

    public ComponentShape(Subject subject, Arc arc) {
        this.subject = subject;
        this.arc = arc;
        this.arc.setFill(Color.AQUAMARINE);
        this.arc.setStartAngle(angle);
    }

    public void update(Subject st) {
        if(st == subject) {
            angle += 18;
            this.arc.setStartAngle(angle);
            if (angle == 360) {
                angle = 0;
            }
        }
    }
}
