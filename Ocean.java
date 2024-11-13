import java.util.ArrayList;
import java.util.List;

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

    public List<Boat> getBoats() {
        return boats;
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
                    cells[line - i][column].placeBoat(boat);
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
                    cells[line][column + i].placeBoat(boat);
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
                    cells[line + i][column].placeBoat(boat);
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
                    cells[line][column - i].placeBoat(boat);
                }
                break;

            default:
                return false;
        }

        return true;
    }

    public boolean attack(int line, int column) {
        try {
            if (cells[line][column].isHit()) {
                System.out.println("La case a déjà été attaquée.");
                return false;
            }else {
                if (cells[line][column].isOccupied()) {
                    System.out.println("Touché! ");
                    cells[line][column].hit();
                    Boat boat = cells[line][column].getBoat();
                    if(boat.getNbLives() <= 0) {
                        System.out.println("Le " + boat.getName() + " est coulé.");
                        nbSunkBoats++;
                    }
                }else {
                    System.out.println("Manqué...");
                    cells[line][column].hit();
                }
                return true;
            }
        }catch (IndexOutOfBoundsException exception) {
            System.out.println("Hors des limites.");
            return false;
        }
    }

    public void printOceanCurrentPlayer() {
        System.out.println("Voici votre océan :");
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

    public void printOceanOpponent() {
        System.out.println("Voici l'océan de votre adversaire :");
        System.out.print("  ");
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < Game.OCEAN_SIZE; j++) {
                System.out.print(cells[i][j].isHit() ? "X " : "- ");
            }
            System.out.println();
        }
    }

    public int getNbSunkBoats() {
        return nbSunkBoats;
    }
}
