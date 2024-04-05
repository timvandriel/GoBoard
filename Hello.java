import java.util.Scanner;

public class Hello {

    static String[][] goBoard = new String[18][18];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        boolean turn = true;
        boolean cont = true;
        System.out.println("Welcome to the game of Go!");
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                goBoard[i][j] = "-|-";
            }
        }
        
        while (cont) {
        System.out.println("    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17");
        for (int i = 0; i < 18; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else {System.out.print(i + " ");}
            for (int j = 0; j < 18; j++) {
                System.out.print(goBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("\n"+ ((turn) ? "Black" : "White") + " player's turn.");
        System.out.println();
        System.out.println("Please enter an x coordinate: ");
        x = scanner.nextInt();
        System.out.println("Please enter a y coordinate: ");
        y = scanner.nextInt();
        if (goBoard[x][y].equals("-|-")) {
            if(turn){
                    goBoard[x][y] = "-●-";
                    turn = false;
                }else{
                
                    goBoard[x][y] = "-◯-";   
                    turn = true; 
                   }
            }
        }
    }
}
