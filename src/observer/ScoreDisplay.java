package observer;

public class ScoreDisplay implements Observer {

    private String score = "0 - 0";

    @Override
    public void update(String score) {
        this.score = score;
        System.out.println("GOAL! Score is: " + score);
    }

    public String getDisplayCurrentScore() {
        return score;
    }
}
