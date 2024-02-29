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
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        for (Boat boat : boats) {
            System.out.println("Placement du bateau " + boat.getName() + " (taille : " + boat.getSize() + ")");
            boolean placed = false;
            while (!placed) {
                System.out.print("Entrez la coordonnée x : ");
                int x = scanner.nextInt();
                System.out.print("Entrez la coordonnée y : ");
                int y = scanner.nextInt();
                System.out.print("Direction (1: Haut, 2: Droite, 3: Bas, 4: Gauche) : ");
                int direction = scanner.nextInt();
                placed = placeBoat(boat, x, y, direction);
                if (!placed) {
                    System.out.println("Placement invalide ! Réessayez.");
                }
            }
            printOcean();
        }
        allPlaced = true;
    }

    public boolean placeBoat(Boat boat, int x, int y, int direction) {
        int size = boat.getSize();

        switch (direction) {
            case DIRECTION_TOP:
                if (x - size + 1 < 0) {
                    return false;
                }
                for (int i = x; i > x - size; i--) {
                    if (cells[i][y].isOccupied()) {
                        return false;
                    }
                }
                for (int i = x; i > x - size; i--) {
                    cells[i][y].setOccupied(true);
                }
                break;

            case DIRECTION_RIGHT:
                if (y + size > Game.OCEAN_SIZE) {
                    return false;
                }
                for (int i = y; i < y + size; i++) {
                    if (cells[x][i].isOccupied()) {
                        return false;
                    }
                }
                for (int i = y; i < y + size; i++) {
                    cells[x][i].setOccupied(true);
                }
                break;

            case DIRECTION_BOTTOM:
                if (x + size > Game.OCEAN_SIZE) {
                    return false;
                }
                for (int i = x; i < x + size; i++) {
                    if (cells[i][y].isOccupied()) {
                        return false;
                    }
                }
                for (int i = x; i < x + size; i++) {
                    cells[i][y].setOccupied(true);
                }
                break;

            case DIRECTION_LEFT:
                if (y - size + 1 < 0) {
                    return false;
                }
                for (int i = y; i > y - size; i--) {
                    if (cells[x][i].isOccupied()) {
                        return false;
                    }
                }
                for (int i = y; i > y - size; i--) {
                    cells[x][i].setOccupied(true);
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
                if (cells[i][j].isHit()) {
                    System.out.print("X ");
                }else {
                    if (cells[i][j].isOccupied()) {
                        System.out.print("O ");
                    }else{
                        System.out.print("- ");
                    }
                }
            }
            System.out.println();
        }
    }
}
