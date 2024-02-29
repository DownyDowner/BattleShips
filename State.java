interface State {
    void start();
    void placeShips();
    void attack();
    void finish();
    String toString();
}

class AwaitingState implements State {
    @Override
    public void start() {
        System.out.println("Le jeu est en attente de démarrage.");
    }

    @Override
    public void placeShips() {
        System.out.println("Impossible de placer les navires pour l'instant. Le jeu n'a pas encore démarré.");
    }

    @Override
    public void attack() {
        System.out.println("Impossible d'attaquer pour l'instant. Le jeu n'a pas encore démarré.");
    }

    @Override
    public void finish() {
        System.out.println("Le jeu n'est pas encore terminé.");
    }

    @Override
    public String toString() {
        return "La partie est en Attente";
    }
}

class SetupState implements State {
    @Override
    public void start() {
        System.out.println("Le jeu a déjà démarré.");
    }

    @Override
    public void placeShips() {
        System.out.println("Placement des navires...");
    }

    @Override
    public void attack() {
        System.out.println("Impossible d'attaquer pour l'instant. Les navires sont en train d'être placés.");
    }

    @Override
    public void finish() {
        System.out.println("Le jeu n'est pas encore terminé.");
    }

    @Override
    public String toString() {
        return "La partie est en préparation";
    }
}

class InBattleState implements State {
    @Override
    public void start() {
        System.out.println("Le jeu a déjà démarré.");
    }

    @Override
    public void placeShips() {
        System.out.println("Les navires sont déjà placés. Le jeu est en cours.");
    }

    @Override
    public void attack() {
        System.out.println("En bataille");
    }

    @Override
    public void finish() {
        System.out.println("Le jeu n'est pas encore terminé.");
    }

    @Override
    public String toString() {
        return "En bataille";
    }
}

class FinishedState implements State {
    @Override
    public void start() {
        System.out.println("Le jeu est déjà terminé.");
    }

    @Override
    public void placeShips() {
        System.out.println("Le jeu est déjà terminé.");
    }

    @Override
    public void attack() {
        System.out.println("Le jeu est déjà terminé.");
    }

    @Override
    public void finish() {
        System.out.println("Le jeu est déjà terminé.");
    }

    @Override
    public String toString() {
        return "La partie est terminée";
    }
}