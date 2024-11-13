import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue au jeu !");
        System.out.print("Joueur 1, veuillez entrer votre nom : ");
        String name1 = scanner.nextLine();

        System.out.print("Joueur 2, veuillez entrer votre nom : ");
        String name2 = scanner.nextLine();

        Game game = new Game(name1, name2);

        game.startGame();

        for (int i = 0; i < Game.NB_PLAYERS; i++) {
            System.out.println("Placement des navires pour " + game.getCurrentPlayer().getLogin());
            placeShips(scanner, game.getCurrentPlayer().getOcean());
            game.switchCurrentPlayer();
        }

        game.setState(new AttackState());
        System.out.println("Phase de bataille commence !");
        while (!game.isFinished()) {
            Player opponent = game.getOpponentPlayer();
            System.out.println(game.getCurrentPlayer().getLogin() + ", à toi de jouer !");

            opponent.getOcean().printOceanOpponent();
            game.getCurrentPlayer().getOcean().printOceanCurrentPlayer();
            System.out.println("Vous avez coulé " + opponent.getOcean().getNbSunkBoats() + " bateau(x) de votre adversaire.");

            boolean attackDone = false;
            while (!attackDone) {
                try {
                    System.out.print("Entrez le n° de la ligne : ");
                    int line = scanner.nextInt();
                    System.out.print("Entrez le n° de la colonne : ");
                    int column = scanner.nextInt();
                    attackDone = opponent.getOcean().attack(line, column);
                } catch (InputMismatchException e) {
                    System.out.println("Entrée invalide ! Assurez-vous d'entrer un entier.");
                    scanner.nextLine();
                }
            }

            if (!game.isFinished()) game.switchCurrentPlayer();
        }
        System.out.println(game.getCurrentPlayer().getLogin() + " a gagné!");
    }

    private static void placeShips(Scanner scanner, Ocean ocean) {
        for (Boat boat : ocean.getBoats()) {
            ocean.printOceanCurrentPlayer();
            System.out.println("Placement du bateau " + boat.getName() + " (taille : " + boat.getSize() + ")");
            boolean placed = false;
            while (!placed) {
                try {
                    System.out.print("Entrez le n° de la ligne : ");
                    int line = scanner.nextInt();
                    System.out.print("Entrez le n° de la colonne : ");
                    int column = scanner.nextInt();
                    System.out.println("Direction : ");
                    System.out.println("\t1: Haut");
                    System.out.println("\t2: Droite");
                    System.out.println("\t3: Bas");
                    System.out.println("\t4: Gauche");
                    int direction = scanner.nextInt();
                    placed = ocean.placeBoat(boat, line, column, direction);
                } catch (InputMismatchException exception) {
                    System.out.println("Entrée invalide ! Assurez-vous d'entrer un entier.");
                    scanner.nextLine();
                }

                if (!placed) {
                    System.out.println("Placement invalide ! Réessayez.");
                }
            }
        }
    }
}
