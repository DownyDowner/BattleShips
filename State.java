public final class State {
     public final void start() {
         System.out.println("Le jeu démarre...");
     }

    public final void placeShips() {
         System.out.println("Phase de placement des navires.");
    }

    public final void attack() {
        System.out.println("Phase de bataille en cours.");
    }

    public final void finish() {
        System.out.println("La partie est terminée.");
    }
}