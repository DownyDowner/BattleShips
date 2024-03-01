public class Cell {
    private boolean isOccupied;
    private boolean isHit;
    private Boat boat;

    public Cell() {
        this.isOccupied = false;
        this.isHit = false;
        boat = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void placeBoat(Boat boat) {
        isOccupied = true;
        boat.placed();
        this.boat = boat;
    }

    public boolean isHit() {
        return isHit;
    }

    public void hit() {
        isHit = true;
        if (boat != null ) boat.hit();
    }

    public Boat getBoat() {
        return boat;
    }
}
