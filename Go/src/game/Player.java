package game;

public class Player {
    private String name;
    private String piece;
    private int score;

    public Player(String name, String piece) {
        this.name = name;
        this.piece = piece;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public String getPiece() {
        return piece;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
