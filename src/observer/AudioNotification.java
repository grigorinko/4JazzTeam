package observer;

public class AudioNotification implements Observer {
    @Override
    public void update(String score) {
        cryLoud(score);
    }

    private void cryLoud(String score) {
        System.out.println("**Crying loud** " + score);
    }
}
