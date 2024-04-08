package game;

// Player class
public class Player {
    private String name;
    private String piece;
    private int score;

    /**
     * Constructor for the Player class
     * @param name
     * @param piece
     */
    public Player(String name, String piece) {
        this.name = name;
        this.piece = piece;
        this.score = 0;
    }
    /**
     * Getter for the name of the player
     // @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for the piece of the player
     * @return piece
     */
    public String getPiece() {
        return piece;
    }
    /**
     * Getter for the score of the player
     * @return score
     */
    public int getScore() {
        return score;
    }
    /**
     * Setter for the score of the player
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
