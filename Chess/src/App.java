

import java.util.Scanner;

//go pieces ◯ ●

public class App {

    static String[][] Board = {
            { "♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖" },
            { "♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙", },
            { "", "", "", "", "", "", "", "", },
            { "", "", "", "", "", "", "", "", },
            { "", "", "", "", "", "", "", "", },
            { "", "", "", "", "", "", "", "", },
            { "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", "♟︎", },
            { "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜" }
    };
    //8x8 2d array with pieces in place for chess.


    //Structures to compare to later. These will help us tell if a piece is white or black.
    static String[] white = { "♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖", "♙" };
    static String[] black = { "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜", "♟︎" };
    //We'll be able to do this by essentially asking if e.g. black[] contains("some piece")

    public static void main(String[] args) {

        Boolean flipper = true;
        //flipped back and forth to create checkerboard pattern

        System.out.println("   0  1  2  3  4  5  6  7");
        //A loop that will print out all rows
        for (int i = 0; i < Board.length; i++) {
            //A loop that will handle each column a member at a time.
            //inner loop will run for the length of the board for each outer loop.

            System.out.print(i + " ");

            for (int j = 0; j < Board[i].length; j++) {

                flipper = !flipper;
                //flippiing the flipper per column

                if (Board[i][j] == "") {
                    //printing out an empty space, 
                    //either black or white based on flipper
                    if (flipper) {
                        System.out.print("   ");
                    } else {
                        System.out.print("███");
                    }
                } 
                
                else {
                    //printing out a space with a piece, 
                    //black or white flanks based on flipper
                    if (flipper) {
                        System.out.print(" " + Board[i][j] + " ");
                    } else {
                        System.out.print("█" + Board[i][j] + "█");
                    }
                }
            }
            System.out.println();
            //Going to a newline after a row is completed.

            flipper = !flipper;
            //flippiing the flipper again so we have checkers instead of lines.
            //flipping it per row.
        }

        System.out.println();
        System.out.println();

        Boolean cont = true;
        int moveX, moveY;
        Scanner scn = new Scanner(System.in);

        while(cont){
            System.out.print("Please enter the X coordinate of a piece: ");
            moveX = scn.nextInt();
            System.out.println();
            System.out.print("Please enter the Y coordinate of a piece: ");
            moveY = scn.nextInt();
            System.out.println();

            switch(Board[moveY][moveX]){
                default:
                    System.out.println("The piece: " + Board[moveY][moveX]);
            }
        }
    }

}