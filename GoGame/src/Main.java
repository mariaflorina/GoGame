import algorithm.Game;
import gui.WindowStart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int WIDTH = 1000;
        int HEIGHT = 800;
        Game game=new Game();
        new WindowStart(WIDTH, HEIGHT, "GoGame", game);
    }
}
