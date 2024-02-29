public class Ocean {
    private Cell[][] cells;
    private boolean allPlaced;
    private int nbSunkBoats;

    public Ocean() {
        for (int i = 0; i < Game.OCEAN_SIZE; i++) {
            for (int j = 0; j < Game.OCEAN_SIZE; j++) {
                this.cells[i][j] = new Cell();
            }
        }
        this.allPlaced = false;
        this.nbSunkBoats = 0;
    }
}
