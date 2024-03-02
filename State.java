interface State {
    void start(Game game);
    void placeShips(Game game);
    void attack(Game game);
    void finish(Game game);
}

class StartState implements State {
    @Override
    public void start(Game game) {
        System.out.println("Le jeu démarre...");
    }

    @Override
    public void placeShips(Game game) {
        System.out.println("Transition vers la phase de placement des navires.");
        game.setState(new PlaceShipsState());
    }

    @Override
    public void attack(Game game) {
        System.out.println("Impossible d'attaquer. Le jeu n'a pas encore démarré.");
    }

    @Override
    public void finish(Game game) {
        System.out.println("Impossible de terminer. Le jeu n'a pas encore démarré.");
    }
}

class PlaceShipsState implements State {
    @Override
    public void start(Game game) {
        System.out.println("Impossible de démarrer. Les navires sont déjà placés.");
    }

    @Override
    public void placeShips(Game game) {
        System.out.println("Les navires sont déjà placés.");
    }

    @Override
    public void attack(Game game) {
        System.out.println("Transition vers la phase de bataille en cours.");
        game.setState(new AttackState());
    }

    @Override
    public void finish(Game game) {
        System.out.println("Impossible de terminer. Les navires ne sont pas tous placés.");
    }
}

class AttackState implements State {
    @Override
    public void start(Game game) {
        System.out.println("Impossible de démarrer. Le jeu est déjà en cours.");
    }

    @Override
    public void placeShips(Game game) {
        System.out.println("Impossible de placer des navires. Le jeu est en cours.");
    }

    @Override
    public void attack(Game game) {
        System.out.println("Phase de bataille en cours.");
    }

    @Override
    public void finish(Game game) {
        System.out.println("La bataille est finie.");
        game.setState(new FinishState());
    }
}

class FinishState implements State {
    @Override
    public void start(Game game) {
        System.out.println("Impossible de démarrer. La partie est déjà terminée.");
    }

    @Override
    public void placeShips(Game game) {
        System.out.println("Impossible de placer des navires. La partie est terminée.");
    }

    @Override
    public void attack(Game game) {
        System.out.println("Impossible d'attaquer. La partie est terminée.");
    }

    @Override
    public void finish(Game game) {
        System.out.println("La partie est terminée.");
    }
}
