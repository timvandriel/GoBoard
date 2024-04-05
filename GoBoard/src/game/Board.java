package game;

public class Board {
    private String[][] grid;

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
        grid[x][y] = piece;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
    }
}
