import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final int OCEAN_SIZE = 10;
    public static final int NB_PLAYERS = 2;
    private State state;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(String name1, String name2) {
        state = new State();
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);

        Random random = new Random();
        double randomValue = random.nextDouble();
        int result = (int) Math.floor(randomValue * 2) + 1;
        this.currentPlayer = (result == 1) ? this.player1 : this.player2;
    }

    public void start() {
        state.start();
        placeShips();
        // playGame();
    }

    private void placeShips() {
        state.placeShips();
        for (int i = 0; i < NB_PLAYERS; i++) {
            performShipPlacement();
            switchCurrentPlayer();
        }
    }

    private void performShipPlacement() {
        state.placeShips();
        System.out.println("Placement des navires pour " + currentPlayer.getLogin());
        currentPlayer.getOcean().placeShips();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
    }
}
