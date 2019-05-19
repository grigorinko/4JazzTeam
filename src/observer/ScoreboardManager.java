package observer;

public class ScoreboardManager {
    public static void main(String[] args) {
        ScoreboardServer scoreboardServer = new ScoreboardServer();

        ScoreDisplay scoreDisplay = new ScoreDisplay();
        scoreboardServer.registerObserver(scoreDisplay);

        AudioNotification audioNotification = new AudioNotification();
        scoreboardServer.registerObserver(audioNotification);

        scoreboardServer.setScore("0 - 1");
        scoreboardServer.notifyObservers();

        scoreboardServer.setScore("0 - 2");
        scoreboardServer.notifyObservers();
    }
}
