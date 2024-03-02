public class Boat {
    private String name;
    private int nbLives;
    private int size;
    private boolean isPlaced;

    public Boat(String name, int size) {
        this.name = name;
        this.size = size;
        this.nbLives = size;
        this.isPlaced = false;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void placed() {
        isPlaced = true;
    }

    public void hit() {
        nbLives--;
    }

    public int getNbLives() {
        return nbLives;
    }
}
