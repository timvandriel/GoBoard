import game.Board;
import game.Player;
import java.util.Scanner;

// Go class
public class Go {
    static Board board = new Board(); // Create a new board
    static Player player1 = new Player("Player 1", "●"); // Create a new player with the name "Player 1" and the piece "●"
    static Player player2 = new Player("Player 2", "◯"); // Create a new player with the name "Player 2" and the piece "◯"
    static Player currentPlayer = player1; // Set the current player to player1
    static Scanner scanner = new Scanner(System.in); // Create a new scanner object
    static boolean cont = true; // Create a boolean variable to control the game loop
    static boolean lastPlayerPassed = false; // Create a boolean variable to check if the last player passed their turn
    public static void main(String[] args) {
        while (cont) { // Start the game loop
            board.printBoard(); // Print the board
            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
            System.out.println("Enter the row and column number separated by a space. Enter '-1 -1' to pass your turn.");
            int x = scanner.nextInt(); // Read the row number from the user
            int y = scanner.nextInt();  // Read the column number from the user
    
            // Check if the player has chosen to pass their turn
            if (x == -1 && y == -1) {
                if (lastPlayerPassed) {
                    cont = false;  // End the game if both players have passed consecutively
                    System.out.println("Both players have passed their turn. Game over.");
                    // Calculate the final score
                    int player1Score = board.calculateScore(player1.getPiece(), board.getWhiteStonesCaptured());
                    double player2Score = board.calculateScore(player2.getPiece(), board.getBlackStonesCaptured()) + 6.5;
                    // Print the final score
                    System.out.println(player1.getName() + " scored " + player1Score + " points.");
                    System.out.println(player2.getName() + " scored " + player2Score + " points.");
                } else {
                    lastPlayerPassed = true; // Set the pass flag if a player passes their turn
                }
            } else if (board.validMove(x, y, currentPlayer.getPiece())) { // Check if the move is valid
                board.setPiece(x, y, currentPlayer.getPiece()); // Set the piece on the board
                board.checkAllStones(); // Check for captured stones
                lastPlayerPassed = false;  // Reset the pass flag if a player makes a valid move
            } else { // Print an error message if the move is invalid
                System.out.println("Invalid move");
                continue;
            }
    
            // Switch the current player
                    if (currentPlayer == player1) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
        }
    }
}
    
