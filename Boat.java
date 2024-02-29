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
}
