package observer;

import java.util.HashSet;
import java.util.Set;

public class ScoreboardServer implements Observable {

    private Set<Observer> observers;
    private String score;

    @Override
    public void registerObserver(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        getObservers().remove(observer);
    }

    @Override
    public void notifyObservers() {
        getObservers().forEach(observer -> observer.update(score));
    }

    public Set<Observer> getObservers() {
        if (observers == null) {
            observers = new HashSet<>();
        }
        return observers;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
