import game.Board;
import game.Player;
import java.util.Scanner;

public class Go {
    static Board board = new Board();
    public static void main(String[] args) {
        board.printBoard();
        Player player1 = new Player("Player 1", "●");
    }
}
