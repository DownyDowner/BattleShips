import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ocean {

    private static final int DIRECTION_TOP = 1;
    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_BOTTOM = 3;
    private static final int DIRECTION_LEFT = 4;

    private Cell[][] cells;
    private List<Boat> boats;
    private boolean allPlaced;
    private int nbSunkBoats;

    public Ocean() {
        cells = new Cell[Game.OCEAN_SIZE][Game.OCEAN_SIZE];
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            for (int j = 0; j < Game.OCEAN_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }

        boats = new ArrayList<>();
        boats.add(new Boat("Porte-avion", 5));
        boats.add(new Boat("Croiseur", 4));
        boats.add(new Boat("Contre torpilleur", 3));
        boats.add(new Boat("Sous-marin", 3));
        boats.add(new Boat("Torpilleur", 2));

        this.allPlaced = false;
        this.nbSunkBoats = 0;
    }

    public void placeShips() {
        Scanner scanner = new Scanner(System.in);
        for (Boat boat : boats) {
            printOcean();
            System.out.println("Placement du bateau " + boat.getName() + " (taille : " + boat.getSize() + ")");
            boolean placed = false;
            while (!placed) {
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
                placed = placeBoat(boat, line, column, direction);
                if (!placed) {
                    System.out.println("Placement invalide ! Réessayez.");
                }
            }
        }
        allPlaced = true;
    }

    public boolean placeBoat(Boat boat, int line, int column, int direction) {
        int size = boat.getSize();

        switch (direction) {
            case DIRECTION_TOP:
                try {
                    for (int i = 0; i < size; i++) {
                        if (cells[line - i][column].isOccupied()) {
                            return false;
                        }
                    }
                }catch (IndexOutOfBoundsException exception) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    cells[line - i][column].setOccupied(true);
                }
                break;

            case DIRECTION_RIGHT:
                try {
                    for (int i = 0; i < size; i++) {
                        if (cells[line][column + i].isOccupied()) {
                            return false;
                        }
                    }
                }catch (IndexOutOfBoundsException exception) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    cells[line][column + i].setOccupied(true);
                }
                break;

            case DIRECTION_BOTTOM:
                try {
                    for (int i = 0; i < size; i++) {
                        if (cells[line + i][column].isOccupied()) {
                            return false;
                        }
                    }
                }catch (IndexOutOfBoundsException exception) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    cells[line + i][column].setOccupied(true);
                }
                break;

            case DIRECTION_LEFT:
                try {
                    for (int i = 0; i < size; i++) {
                        if (cells[line][column - i].isOccupied()) {
                            return false;
                        }
                    }
                }catch (IndexOutOfBoundsException exception) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    cells[line][column - i].setOccupied(true);
                }
                break;

            default:
                return false;
        }
        boat.setPlaced(true);

        return true;
    }

    public void printOcean() {
        System.out.println("Océan :");
        System.out.print("  ");
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < Game.OCEAN_SIZE; j++) {
                System.out.print(cells[i][j].isHit() ? "X " : (cells[i][j].isOccupied() ? "O " : "- "));
            }
            System.out.println();
        }
    }
}
