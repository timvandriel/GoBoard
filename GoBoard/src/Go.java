package GoBoard.GoBoard.src;

import java.util.Scanner;

public class Go {
// game pieces "●", "◯"
    static String[][] goBoard = new String[9][9];
    static boolean[][] lives = new boolean[9][9];
    static boolean[][] territory = new boolean[9][9];
    static boolean[][] beenChecked = new boolean[9][9];
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        boolean turn = true;
        boolean cont = true;
        System.out.println("Welcome to the game of Go!");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8) {
                    goBoard[i][j] = "|";
                }
                else {
                    goBoard[i][j] = "|-";
                }
            }
        }

        while (cont) {
            System.out.println("  0 1 2 3 4 5 6 7 8");
            for (int i = 0; i < 9; i++) {
                if (i < 9) {
                    System.out.print(i + " ");
                }
                for (int j = 0; j < 9; j++) {
                    System.out.print(goBoard[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            if (turn) {
                System.out.println("It is black's turn.");
            } else {
                System.out.println("It is white's turn");
            }
            System.out.println();
            System.out.println("Please enter an x coordinate: ");
            x = scanner.nextInt();
            if (x > 9 || x < 0) {
                System.out.println("Please enter a valid move: ");
                x = scanner.nextInt();
            }
            System.out.println("Please enter a y coordinate: ");
            y = scanner.nextInt();
            if (y > 9 || y < 0){
                System.out.println("Please enter a valid move: ");
                y = scanner.nextInt();
            }
            if (goBoard[x][y].equals("|-")) {
                if (turn) {
                    goBoard[x][y] = "●-";
                    turn = false;
                } 
                else {
                    goBoard[x][y] = "◯-";
                    turn = true;
                }
            }
            else if (goBoard[x][y].equals("|")) {
                if (turn){
                    goBoard[x][y] = "●";
                    turn = false;
                }
                else {
                    goBoard[x][y] = "◯";
                    turn = true;
                }
            }
            else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }
}