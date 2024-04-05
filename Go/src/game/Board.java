package game;

public class Board {
    private String[][] grid;
    static boolean[][] lives = new boolean[9][9];
    static boolean[][] territory = new boolean[9][9];
    static boolean[][] beenChecked = new boolean[9][9];
    static String[][] goBoard = new String[9][9];
    static String[][] goBoard2 = {
        {null, null, "-●-", "-●-", null, null, null, null, null},
        {null, "-●-", "-◯-", "-◯-", "-●-", null, null, null, null},
        {null, "-●-", "-◯-", null, "-◯-", "-●-", null, null, null},
        {null, "-●-", "-◯-", "-◯-", "-◯-", "-●-", null, null, null},
        {null, "-●-", "-◯-", null, "-◯-", "-●-", null, null, null},
        {null, null, "-●-", "-◯-", "-◯-", "-●-", null, null, null},
        {null, null, null, "-●-", "-●-", null, null, null, null},
        {null, null, null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null, null, null}
    };
    // game pieces "●", "◯"

    public Board() {
        grid = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8) {
                    grid[i][j] = "|";
                }
                else {
                    grid[i][j] = "|-";
                }
            }
        }
    }
    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    public void setPiece(int x, int y, String piece) {
        if (x < 0 || x > 8 || y < 0 || y > 8) {
            System.out.println("Invalid move");
            return;
        }
        else if (grid[x][y] != "|-" || grid[x][y] != "|") {
            System.out.println("Invalid move");
            return;
        }
        grid[x][y] = piece;
    }

    public void getPiece(int x, int y) {
        System.out.println(grid[x][y]);
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.setPiece(0, 9, "●-");
        board.printBoard();

    }
}