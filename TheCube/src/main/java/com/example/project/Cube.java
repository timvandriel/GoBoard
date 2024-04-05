/*Tim Van Driel
 * CSCI152
 * March 1st, 2021
 * Cube Assignment
 * This program represents a Rubiks cube and can perform 12 different moves on the cube.
 * Program can be run with command line inputs for moves or with user input. Faces of cube 
 * are: O (Red), 1 (Blue), 2 (Orange), 3 (Green) are the side faces, and 4 (Yellow) is the 
 * bottom face, and 5 (White) is the top face.
 */
package com.example.project;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Cube {

	//A Cube in the correct format for the ultimate submission
	static String[][] myCube = 
				    {
				        {
				            "r", "r", "r",
				            "r", "r", "r",
				            "r", "r", "r",
				        },	{
				            "b", "b", "b",
				            "b", "b", "b",
				            "b", "b", "b",
				        },	{
				            "o", "o", "o",
				            "o", "o", "o",
				            "o", "o", "o",
				        },	{
				            "g", "g", "g", 
				            "g", "g", "g",
				            "g", "g", "g",
				        },	{
				            "y", "y", "y",
				            "y", "y", "y",
				            "y", "y", "y",
				        },	{
				            "w", "w", "w",
				            "w", "w", "w",
				            "w", "w", "w",
				        },
				    };
	
						
	//A Cube with numbers to test rotation.
	static String[][] numCube = 
				    {
				        {
				            "r1", "r2", "r3",
				            "r4", "r5", "r6",
				            "r7", "r8", "r9",
				        },	{
				            "b1", "b2", "b3",
				            "b4", "b5", "b6",
				            "b7", "b8", "b9",
				        },	{
				            "o1", "o2", "o3",
				            "o4", "o5", "o6",
				            "o7", "o8", "o9",
				        },	{
				            "g1", "g2", "g3", 
				            "g4", "g5", "g6",
				            "g7", "g8", "g9",
				        },	{
				            "y1", "y2", "y3",
				            "y4", "y5", "y6",
				            "y7", "y8", "y9",
				        },	{
				            "w1", "w2", "w3",
				            "w4", "w5", "w6",
				            "w7", "w8", "w9",
				        },
				    };
	

	static void rotateFace(String[][] Cube, int face){
	        String Temp = null;
	        Temp = Cube[face][0];
	        Cube[face][0] = Cube[face][6];
	        Cube[face][6] = Cube[face][8];
	        Cube[face][8] = Cube[face][2];
	        Cube[face][2] = Temp;
	        Temp = Cube[face][1];
	        Cube[face][1] = Cube[face][3];
	        Cube[face][3] = Cube[face][7];
	        Cube[face][7] = Cube[face][5];
	        Cube[face][5] = Temp;

		/*
		 * 		1 -> 2 -> 3
		 * 		/\       \/
		 * 		4    5    6
		 * 		/\       \/
		 * 		7 <- 8 <- 9
		 * 	 Clockwise Rotation
		 *
		 */

	} 

	static void moveU(String[][] Cube){
		//Method for specified moveU 
		rotateFace(Cube, 5);
		String[] temp = new String[3];
		System.arraycopy(Cube[3], 0, temp, 0, 3);  // Store the top row of face 3 in temp
		
		// Shift the top row values from faces 0, 1, and 2 to faces 3, 0, and 1 respectively
		System.arraycopy(Cube[0], 0, Cube[3], 0, 3);
		System.arraycopy(Cube[1], 0, Cube[0], 0, 3);
		System.arraycopy(Cube[2], 0, Cube[1], 0, 3);
		
		// Assign the values from the temporary array to the top row of face 2
		System.arraycopy(temp, 0, Cube[2], 0, 3);
	}

	static void moveD(String[][] Cube){
		//Method for specified moveD
		String[] temp = new String[3];
		rotateFace(Cube, 4);
		System.arraycopy(Cube[3], 6, temp, 0, 3);  // Store the bottom row of face 3 in temp
		System.arraycopy(Cube[2], 6, Cube[3], 6, 3); // Shift the bottom row values from face 2 to face 3
		System.arraycopy(Cube[1], 6, Cube[2], 6, 3); // Shift the bottom row values from face 1 to face 2
		System.arraycopy(Cube[0], 6, Cube[1], 6, 3); // Shift the bottom row values from face 0 to face 1
		System.arraycopy(temp, 0, Cube[0], 6, 3); // Assign the values from the temporary array to the bottom row of face 0
	}
	static void moveR(String[][] Cube){
		//Method for specified moveR
		rotateFace(Cube, 1);
		// create temporary arrays to store values from the involved faces
		String[] temp0 = new String[3];
		String[] temp5 = new String[3];
		String[] temp2 = new String[3];
		String[] temp4 = new String[3];
		// create array to hold indices of the values to be moved for each face
		int[] indices = {2, 5, 8};
		int[] indices2 = {0,3,6};
		// store the values from the specified indices of the involved faces in the temporary arrays
		for (int i = 0; i < indices.length; i++){
			temp0[i] = Cube[0][indices[i]];
			temp5[i] = Cube[5][indices[i]];
			temp2[i] = Cube[2][indices2[i]];
			temp4[i] = Cube[4][indices[i]];
		}
		// move the values from the temporary arrays to the specified indices of the involved faces
		for (int i = 0; i < indices.length; i++){
			Cube[0][indices[i]] = temp4[i];
			Cube[5][indices[i]] = temp0[i];
			Cube[2][indices2[i]] = temp5[i];
			Cube[4][indices[i]] = temp2[i];
		}
	}
	static void moveL(String[][] Cube){
		//Method for specified moveL
		rotateFace(Cube, 3);
		// create temporary arrays to store values from the involved faces
		String[] temp0 = new String[3];
		String[] temp5 = new String[3];
		String[] temp2 = new String[3];
		String[] temp4 = new String[3];
		// create array to hold indices of the values to be moved for each face
		int[] indices = {0, 3, 6};
		int[] indices2 = {2, 5, 8};
		// store the values from the specified indices of the involved faces in the temporary arrays
		for (int i = 0; i < indices.length; i++){
			temp0[i] = Cube[0][indices[i]];
			temp5[i] = Cube[5][indices[i]];
			temp2[i] = Cube[2][indices2[i]];
			temp4[i] = Cube[4][indices[i]];
		}
		// move the values from the temporary arrays to the specified indices of the involved faces
		for (int i = 0; i < indices.length; i++){
			Cube[0][indices[i]] = temp5[i];
			Cube[4][indices[i]] = temp0[i];
			Cube[2][indices2[i]] = temp4[i];
			Cube[5][indices[i]] = temp2[i];
		}
	}
	static void moveF(String[][] Cube){
		//Method for specified moveF
		rotateFace(Cube,0);
		// create temporary arrays to store values from the involved faces
		String[] temp5 = new String[3];
		String[] temp1 = new String[3];
		String[] temp3 = new String[3];
		String[] temp4 = new String[3];
		// create array to hold indices of the values to be moved for each face
		int[] indices5 = {6, 7, 8};
		int[] indices1 = {0, 3, 6};
		int[] indices3 = {2, 5, 8};
		int[] indices4 = {0, 1, 2};
		// store the values from the specified indices of the involved faces in the temporary arrays
		for (int i = 0; i < indices5.length; i++){
			temp5[i] = Cube[5][indices5[i]];
			temp1[i] = Cube[1][indices1[i]];
			temp3[i] = Cube[3][indices3[i]];
			temp4[i] = Cube[4][indices4[i]];
		}
		// move the values from the temporary arrays to the specified indices of the involved faces
		for (int i = 0; i < indices5.length; i++){
			Cube[5][indices5[i]] = temp3[i];
			Cube[1][indices1[i]] = temp5[i];
			Cube[3][indices3[i]] = temp4[i];
			Cube[4][indices4[i]] = temp1[i];
		}
	}
	static void moveB(String[][] Cube){
		//Method for specified moveB
		rotateFace(Cube, 2);
		// create temporary arrays to store values from the involved faces
		String[] temp5 = new String[3];
		String[] temp1 = new String[3];
		String[] temp3 = new String[3];
		String[] temp4 = new String[3];
		// create array to hold indices of the values to be moved for each face
		int[] indices5 = {0, 1, 2};
		int[] indices1 = {2, 5, 8};
		int[] indices3 = {0, 3, 6};
		int[] indices4 = {6, 7, 8};
		// store the values from the specified indices of the involved faces in the temporary arrays
		for (int i = 0; i < indices5.length; i++){
			temp5[i] = Cube[5][indices5[i]];
			temp1[i] = Cube[1][indices1[i]];
			temp3[i] = Cube[3][indices3[i]];
			temp4[i] = Cube[4][indices4[i]];
		}
		// move the values from the temporary arrays to the specified indices of the involved faces
		for (int i = 0; i < indices5.length; i++){
			Cube[5][indices5[i]] = temp1[i];
			Cube[1][indices1[i]] = temp4[i];
			Cube[3][indices3[i]] = temp5[i];
			Cube[4][indices4[i]] = temp3[i];
		}
	}
	static void moveUprime(String[][] Cube){
		//Method for specified moveUprime. Calling moveU 3 times is the same as calling moveUprime once.
		moveU(Cube);
		moveU(Cube);
		moveU(Cube);
	}
	static void moveDprime(String[][] Cube){
		//Method for specified moveDprime. Calling moveD 3 times is the same as calling moveDprime once.
		moveD(Cube);
		moveD(Cube);
		moveD(Cube);
	}
	static void moveRprime(String[][] Cube){
		//Method for specified moveRprime. Calling moveR 3 times is the same as calling moveRprime once.
		moveR(Cube);
		moveR(Cube);
		moveR(Cube);
	}
	static void moveLprime(String[][] Cube){
		//Method for specified moveLprime. Calling moveL 3 times is the same as calling moveLprime once.
		moveL(Cube);
		moveL(Cube);
		moveL(Cube);
	}
	static void moveFprime(String[][] Cube){
		//Method for specified moveFprime. Calling moveF 3 times is the same as calling moveFprime once.
		moveF(Cube);
		moveF(Cube);
		moveF(Cube);
	}
	static void moveBprime(String[][] Cube){
		//Method for specified moveBprime. Calling moveB 3 times is the same as calling moveBprime once.
		moveB(Cube);
		moveB(Cube);
		moveB(Cube);
	}
	static ArrayList<String> cubeRandomizer(String[][] Cube){
		//Method to randomize the cube
		Random rand = new Random(); // create a new random object
		ArrayList<String> randMoves = new ArrayList<String>();; // create an array to store the moves
		for (int i = 0; i < 5; i++){
			int random = rand.nextInt(12); // generate a random number between 0 and 11
			switch(random){ // use the random number to select a move and add it to the moves array
				case 0:
					moveU(Cube);
					randMoves.add( "U'");
					break;
				case 1:
					moveD(Cube);
					randMoves.add("D'");
					break;
				case 2:
					moveR(Cube);
					randMoves.add("R'");
					break;
				case 3:
					moveL(Cube);
					randMoves.add("L'");
					break;
				case 4:
					moveF(Cube);
					randMoves.add("F'");
					break;
				case 5:
					moveB(Cube);
					randMoves.add("B'");
					break;
				case 6:
					moveUprime(Cube);
					randMoves.add("U");
					break;
				case 7:
					moveDprime(Cube);
					randMoves.add("D");
					break;
				case 8:
					moveRprime(Cube);
					randMoves.add("R");
					break;
				case 9:
					moveLprime(Cube);
					randMoves.add("L");
					break;
				case 10:
					moveFprime(Cube);
					randMoves.add("F");
					break;
				case 11:
					moveBprime(Cube);
					randMoves.add("B");
					break;
			}
		}
		return randMoves;
	}
	static void solveCube(ArrayList<String> pastMoves){
		//Method to print out moves opposite to user input and reversed to solve the cube
		for(int i = pastMoves.size() - 1; i >= 0; i--){
			System.out.print(pastMoves.get(i) + " ");
		}
		System.out.println();
	}
	


	static void printCube(String[][] theCube) {
		//Method to print the cube
		for (int x = 0; x < 6; x++){
	        	int z = -1;
	        	for (int y = 0; y < 3; y++){
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.print("|"); 
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.print("|");  
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.println("");    
	                
	            	}
	        	System.out.println("");    
		}
	}
	
		public static void main(final String[] args) {
			Scanner scanner = new Scanner(System.in); // create a new scanner object
			ArrayList<String> moves = new ArrayList<String>(); // create an array list to store the moves
			// check if the user entered any arguments
			if (args.length > 0) { 
				// loop through the arguments
				for (int i = 0; i < args.length; i++){ 
					// use the arguments to select a move and add it to the moves array
					switch(args[i].toUpperCase()){ 
						case "U":
							moves.add("U'");
							moveU(myCube);
							break;
						case "D":
							moves.add("D'");
							moveD(myCube);
							break;
						case "R":
							moves.add("R'");
							moveR(myCube);
							break;
						case "L":
							moves.add("L'");
							moveL(myCube);
							break;
						case "F":
							moves.add("F'");
							moveF(myCube);
							break;
						case "B":
							moves.add("B'");
							moveB(myCube);
							break;
						case "U'":
							moves.add("U");
							moveUprime(myCube);
							break;
						case "D'":
							moves.add("D");
							moveDprime(myCube);
							break;
						case "R'":
							moves.add("R");
							moveRprime(myCube);
							break;
						case "L'":
							moves.add("L");
							moveLprime(myCube);
							break;
						case "F'":
							moves.add("F");
							moveFprime(myCube);
							break;
						case "B'":
							moves.add("B");
							moveBprime(myCube);
							break;
						default:
							System.out.println("Invalid move. Try running program again.");
							break;
						}
					}
				System.out.println("Here is the cube after the moves you entered:");
				printCube(myCube);
				System.out.println("In order to solve you would enter these moves in order:");
				solveCube(moves);
				}
			// if the user did not enter any arguments, prompt user for input
			else{ 
				System.out.println("Would you like to randomize the cube? (y/n)"); // prompt user to randomize the cube
				String response = scanner.nextLine(); 
				// if the user enters "y", randomize the cube
				if (response.equals("y")){ 
					moves = cubeRandomizer(myCube);
					System.out.println("");
					System.out.println("Here is the cube after randomizing:");
					printCube(myCube);
					System.out.println("In order to solve you would enter these moves in order:");
					solveCube(moves);
					System.out.println("");
				}
				// if the user enters "n", prompt the user to enter moves
				else if (response.equals("n")){ 
					printCube(myCube);
					System.out.println("");
					System.out.println("Enter moves to manipulate the cube or enter 'q' to quit: ");
					System.out.println("");
				}
				// run program with cube in solved state anyways
				else{
					printCube(myCube);
					System.out.println("");
					System.out.println("Invalid input. Running program with cube in solved state.");
					System.out.println("");}
				String move = ""; // create a string to store the user's move
				// loop until the user enters "q"
				while (!move.equals("q")){ 
					System.out.println("Enter a move (U, D, R, L, F, B, U', D', R', L', F', B', q to quit): ");
					move = scanner.nextLine(); // get the user's move
					// use the user's move to select a move and add or remove it to the moves arraylist
					switch(move.toUpperCase()){
						case "U":
							if (moves.isEmpty()){
								moves.add("U'");
							}
							else if (moves.get(moves.size() - 1).equals("U")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("U'");
							}
							moveU(myCube);
							break;
						case "D":
							if (moves.isEmpty()){
								moves.add("D'");
							}
							else if (moves.get(moves.size() - 1).equals("D")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("D'");
							}
							moveD(myCube);
							break;
						case "R":
							if (moves.isEmpty()){
								moves.add("R'");
							}
							else if (moves.get(moves.size() - 1).equals("R")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("R'");
							}
							moveR(myCube);
							break;
						case "L":
							if (moves.isEmpty()){
								moves.add("L'");
							}
							else if (moves.get(moves.size() - 1).equals("L")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("L'");
							}
							moveL(myCube);
							break;
						case "F":
							if (moves.isEmpty()){
								moves.add("F'");
							}
							else if (moves.get(moves.size() - 1).equals("F")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("F'");
							}
							moveF(myCube);
							break;
						case "B":
							if (moves.isEmpty()){
								moves.add("B'");
							}
							else if (moves.get(moves.size() - 1).equals("B")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("B'");
							}
							moveB(myCube);
							break;
						case "U'":
							if (moves.isEmpty()){
								moves.add("U");
							}
							else if (moves.get(moves.size() - 1).equals("U'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("U");
							}
							moveUprime(myCube);
							break;
						case "D'":
							if (moves.isEmpty()){
								moves.add("D");
							}
							else if (moves.get(moves.size() - 1).equals("D'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("D");
							}
							moveDprime(myCube);
							break;
						case "R'":
							if (moves.isEmpty()){
								moves.add("R");
							}
							else if (moves.get(moves.size() - 1).equals("R'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("R");
							}
							moveRprime(myCube);
							break;
						case "L'":
							if (moves.isEmpty()){
								moves.add("L");
							}
							else if (moves.get(moves.size() - 1).equals("L'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("L");
							}
							moveLprime(myCube);
							break;
						case "F'":
							if (moves.isEmpty()){
								moves.add("F");
							}
							else if (moves.get(moves.size() - 1).equals("F'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("F");
							}
							moveFprime(myCube);
							break;
						case "B'":
							if (moves.isEmpty()){
								moves.add("B");
							}
							else if (moves.get(moves.size() - 1).equals("B'")){
								moves.remove(moves.size() - 1);
							}
							else {
								moves.add("B");
							}
							moveBprime(myCube);
							break;
						case "Q":
							System.out.println("Quitting program.");
							break;
					}
					System.out.println("");
					printCube(myCube);
					System.out.println("");
					if (moves.size() == 0){
						System.out.println("Cube is in a solved state, no recommended moves left. You may continue or press q to quit.");
						System.out.println("");
					}
					else{
						System.out.println("In order to solve you would enter these moves in order:");
						solveCube(moves);
						System.out.println("");
					}
				}
			}
		}
	}



