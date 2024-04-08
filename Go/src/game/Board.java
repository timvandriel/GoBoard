package game;
import java.util.ArrayList;
import java.util.List;

// Board clas that handles the game board and methods to manipulate it
public class Board {
    private String[][] grid;
    static boolean[][] beenChecked = new boolean[9][9];
    static String[][] goBoard = new String[9][9];
    static int blackStonesCaptured = 0;
    static int whiteStonesCaptured = 0;
    /**
     * Constructor for the Board class. Initializes the game board
     * with a hash pattern
     */
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
    /**
     * Prints the game board to the console
     */
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
    /**
     * Prints the go board to the console
     */
    public void printGoBoard() {
        System.out.print("  ");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 9; j++) {
                System.out.print(goBoard[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * Returns the number of black stones captured
     */
    public int getBlackStonesCaptured() {
        return blackStonesCaptured;
    }
    /**
     * Returns the number of white stones captured
     */
    public int getWhiteStonesCaptured() {
        return whiteStonesCaptured;
    }
    /**
     * Checks if a move is valid
     * @param x the x-coordinate of the move
     * @param y the y-coordinate of the move
     * @param piece the piece to be placed
     * @return true if the move is valid, false otherwise
     */
    public boolean validMove(int x, int y, String piece) {
        if (x <= -1 || x >= 9 || y <= -1 || y >= 9) {
            return false;
        }
        else if (grid[x][y] != "|-" && grid[x][y] != "|") {
            return false;
        }
        else if (checkLiberties(x, y, piece)==false){
            return false;
        }
        else {
            return true;
        }
    }
    /**
     * Sets a piece on the board
     * @param x the x-coordinate of the move
     * @param y the y-coordinate of the move
     * @param piece the piece to be placed
     */
    public void setPiece(int x, int y, String piece) {
        if (validMove(x, y, piece)) {
            if (y == 8) {
                grid[x][y] = piece;
            }
            else {
                grid[x][y] = piece + "-";
        }
        goBoard[x][y] = piece;}
            
        else {
            System.out.println("Invalid move");
        }
    }
    /**
     * Gets the piece at a given position
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     */
    public void getPiece(int x, int y) {
        System.out.println(grid[x][y]);
    }
    /**
     * Removes a piece from the board
     * @param x the x-coordinate of the piece
     * @param y the y-coordinate of the piece
     */
    public void removePiece(int x, int y) {
        if (y == 8) {
            grid[x][y] = "|";
        }
        else {
            grid[x][y] = "|-";
        }
        goBoard[x][y] = null;
    }
    /**
     * Checks if a group of stones has any liberties
     * @param x the x-coordinate of the group
     * @param y the y-coordinate of the group
     * @param piece the piece to be checked
     * @return true if the group has liberties, false otherwise
     */
    public boolean checkLiberties(int x, int y, String piece){
        if (x <= -1 || x >= 9 || y <= -1 || y >= 9 || beenChecked[x][y]) {
            return false;
        }
        if (goBoard[x][y] == null) {
            return true;
        }
        if (goBoard[x][y] != piece) {
            return false;
        }
        beenChecked[x][y] = true;
        return checkLiberties(x-1, y, piece) || checkLiberties(x+1, y, piece) || 
        checkLiberties(x, y-1, piece) || checkLiberties(x, y+1, piece);
    }
    /**
     * Resets the beenChecked array
     */
    public void resetBeenChecked() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                beenChecked[i][j] = false;
            }
        }
    }
    /**
     * Gets a group of stones
     * @param x the x-coordinate of the group
     * @param y the y-coordinate of the group
     * @param piece the piece to be checked
     * @return a list of points representing the group
     */
    public List<Point> getGroup(int x, int y, String piece) {
    // Create a list to hold the points in the group
    List<Point> group = new ArrayList<>();
    if (goBoard[x][y] != null && goBoard[x][y].equals(piece)) {
        group.add(new Point(x, y));
    }
    // Check if the cell is out of bounds or has already been checked
    if (x < 0 || x >= 9 || y < 0 || y >= 9 || beenChecked[x][y]) {
        return group;
    }
    // If the cell contains a stone of the same color, add it to the group and check the adjacent cells
    if (goBoard[x][y] != null && goBoard[x][y].equals(piece)) {
        group.add(new Point(x, y));
        beenChecked[x][y] = true;
        group.addAll(getGroup(x - 1, y, piece));
        group.addAll(getGroup(x + 1, y, piece));
        group.addAll(getGroup(x, y - 1, piece));
        group.addAll(getGroup(x, y + 1, piece));
    }
    return group;
    }
    /**
     * Checks all the stones on the board and removes any groups that have no liberties
     */
    public void checkAllStones(){
        // Create a list to hold the groups of stones to be removed
        List<List<Point>> groupsToRemove = new ArrayList<>();
        // Traverse the entire board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the cell contains a stone
                if (goBoard[i][j] != null) {
                    // Reset the beenChecked array
                    resetBeenChecked();
                    // Check if the group of stones has any liberties
                    if (!checkLiberties(i, j, goBoard[i][j])) {
                        // If the group has no liberties, add it to the list of groups to be removed
                        groupsToRemove.add(getGroup(i, j, goBoard[i][j]));
                    }
                }
            }
        }
        // Remove all the groups of stones that should be captured
        for (List<Point> group : groupsToRemove) {
            String piece = goBoard[group.get(0).x][group.get(0).y];
            if (piece == "●") {
                blackStonesCaptured += group.size();
            }
            else if (piece == "◯") {
                whiteStonesCaptured += group.size();
            }

            for (Point point : group) {
                removePiece(point.x, point.y);
            }
        }
    }
    /**
     * Calculates the score for a given player
     * @param piece the player's piece
     * @param stonesCaptured the number of stones captured by the player
     * @return the player's score
     */
    public int calculateScore(String piece, int stonesCaptured){
        int score = stonesCaptured;
        boolean[][] visited = new boolean[9][9];  // Keeps track of the spots we've already counted
        // Iterate over every spot on the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If the spot is empty and we haven't visited it yet
                if (goBoard[i][j] == null && !visited[i][j]) {
                    // Use a flood fill algorithm to find all contiguous empty spots
                    List<Point> territory = new ArrayList<>();
                    floodFill(i, j, visited, territory);
                    // Check if all the spots on the border of the territory are occupied by the player's stones
                    if (isTerritorySurroundedBy(territory, piece)) {
                        score += territory.size();
                    }
                }
            }
        }
        return score;
    }
    /**
     * Recursively finds all contiguous empty spots on the board
     * @param x the x-coordinate of the spot
     * @param y the y-coordinate of the spot
     * @param visited a 2D array that keeps track of the spots we've already visited
     * @param territory a list that holds the contiguous empty spots
     */
    private void floodFill(int x, int y, boolean[][] visited, List<Point> territory) {
        // Check if the point is inside the board and has not been visited yet
        if (x >= 0 && x < 9 && y >= 0 && y < 9 && !visited[x][y]) {
            visited[x][y] = true;  // Mark the point as visited
            // If the point is empty, add it to the territory and visit its neighbors
            if (goBoard[x][y] == null) {
                territory.add(new Point(x, y));
                floodFill(x - 1, y, visited, territory);  // Left
                floodFill(x + 1, y, visited, territory);  // Right
                floodFill(x, y - 1, visited, territory);  // Up
                floodFill(x, y + 1, visited, territory);  // Down
            }
        }
    }
    /**
     * Checks if a territory is surrounded by the player's stones
     * @param territory a list of points representing the territory
     * @param piece the player's piece
     * @return true if the territory is surrounded by the player's stones, false otherwise
     */
    private boolean isTerritorySurroundedBy(List<Point> territory, String piece){
        for (Point point : territory) {
            int x = point.x;
            int y = point.y;
            // Check the four neighboring points to see if any of them are not occupied by the player's stones
            if ((x > 0 && goBoard[x - 1][y] != null && !goBoard[x - 1][y].equals(piece)) ||  // Left
                (x < 8 && goBoard[x + 1][y] != null && !goBoard[x + 1][y].equals(piece)) ||  // Right
                (y > 0 && goBoard[x][y - 1] != null && !goBoard[x][y - 1].equals(piece)) ||  // Up
                (y < 8 && goBoard[x][y + 1] != null && !goBoard[x][y + 1].equals(piece))) {  // Down
                return false;
            }
        }
        return true;
    }
}
class Point{
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}