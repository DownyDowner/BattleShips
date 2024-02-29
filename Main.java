import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue au jeu !");
        System.out.println("Joueur 1, veuillez entrer votre nom :");
        String name1 = scanner.nextLine();

        System.out.println("Joueur 2, veuillez entrer votre nom :");
        String name2 = scanner.nextLine();

        Game game = new Game(name1, name2);
        game.start();
    }
}
