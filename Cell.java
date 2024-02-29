public class Cell {
    private boolean isOccupied;
    private boolean isHit;

    public Cell() {
        this.isOccupied = false;
        this.isHit = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
