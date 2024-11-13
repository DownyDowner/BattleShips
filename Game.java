import java.util.Random;

public class Game {
    public static final int OCEAN_SIZE = 10;
    public static final int NB_PLAYERS = 2;
    public static  final int NB_BOAT = 5;
    private State state;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(String name1, String name2) {
        state = new StartState();
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);

        Random random = new Random();
        double randomValue = random.nextDouble();
        int result = (int) Math.floor(randomValue * 2) + 1;
        this.currentPlayer = (result == 1) ? this.player1 : this.player2;
    }

    public void startGame() {
        state.start(this);
        state.placeShips(this);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOpponentPlayer() {
        return currentPlayer.equals(player1) ? player2 : player1;
    }

    public boolean isFinished() {
        boolean isFinished = player1.getOcean().getNbSunkBoats() >= NB_BOAT || player2.getOcean().getNbSunkBoats() >= NB_BOAT;
        if (isFinished) state.finish(this);
        return isFinished;
    }

    public void switchCurrentPlayer() {
        currentPlayer = getOpponentPlayer();
    }

    public void setState(State state) {
        this.state = state;
    }
}

