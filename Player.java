public class Player {
    private String login;
    private Ocean ocean;

    public Player(String login) {
        this.login = login;
        this.ocean = new Ocean();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Ocean getOcean() {
        return ocean;
    }
}
