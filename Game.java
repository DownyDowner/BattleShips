import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final int OCEAN_SIZE = 10;
    public static final int NB_PLAYERS = 2;
    public static  final int NB_BOAT = 5;
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

    public void makeGame() {
        state.start();
        placeShips();
        attack();
        state.finish();
    }

    private void placeShips() {
        state.placeShips();
        for (int i = 0; i < NB_PLAYERS; i++) {
            performShipPlacement();
            switchCurrentPlayer();
        }
    }

    private void performShipPlacement() {
        System.out.println("Placement des navires pour " + currentPlayer.getLogin());
        currentPlayer.getOcean().placeShips();
    }

    private void attack() {
        state.attack();
        Scanner scanner = new Scanner(System.in);
        while (!isFinished()) {
            System.out.println(currentPlayer + " à toi de jouer!");
            currentPlayer.getOcean().printOcean();
            Player opponent = (currentPlayer.equals(player1)) ? player2 : player1;
            boolean attackDone = false;
            while (!attackDone) {
                System.out.print("Entrez le n° de la ligne : ");
                int line = scanner.nextInt();
                System.out.print("Entrez le n° de la colonne : ");
                int column = scanner.nextInt();
                attackDone = opponent.getOcean().attack(line, column);
            }
            if (!isFinished()) switchCurrentPlayer();
        }
        System.out.println(currentPlayer.getLogin() + " a gagné");
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
    }

    private boolean isFinished() {
        return player1.getOcean().getNbSunkBoats() >= NB_BOAT || player2.getOcean().getNbSunkBoats() >= NB_BOAT;
    }
}
