package model;

public interface Subject {
    public void notifyAllObservers();
    public void attach(Observer obs);
    public void detach(Observer obs);
    public int getTimeState();
}
