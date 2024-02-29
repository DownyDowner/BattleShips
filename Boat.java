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

    public void setName(String name) {
        this.name = name;
    }

    public int getNbLives() {
        return nbLives;
    }

    public void setNbLives(int nbLives) {
        this.nbLives = nbLives;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }
}
