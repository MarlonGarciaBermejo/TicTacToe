public class Player {

    private String player1;             //instance variable for player 1
    private String player2;             //instance variable for player 2   

    public Player(String player1, String player2) {      //Constructor
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {        //Getters and setters for player 1 and 2
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }
}
