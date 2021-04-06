package model;

import java.util.*;

public class TimeServer implements Subject {
    private final long delay = 0;
    private final long period = 1000;
    private TimerTask task;
    private Timer timer;
    private int timeState;
    private List<Observer> observers = new ArrayList<>();

    public TimeServer() {
        this.timer = new Timer();
        task = new TimerTask() {
            public void run() {
                tick();
            }
        };
        timer.schedule(task, delay, period);
    }

    private void tick(){
        timeState++;
        notifyAllObservers();
    }

    public int getTimeState() {
        return timeState;
    }

    public void setTimeState(int timeState) {
        this.timeState = timeState;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
