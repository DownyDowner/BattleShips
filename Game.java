import java.util.Random;

public class Game {
    public static final int OCEAN_SIZE = 10;
    private State state;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(String name1, String name2) {
        state = new AwaitingState();
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);

        Random random = new Random();
        double randomValue = random.nextDouble();
        int result = (int) Math.floor(randomValue * 2) + 1;
        this.currentPlayer = (result == 1) ? this.player1 : this.player2;
    }
}
