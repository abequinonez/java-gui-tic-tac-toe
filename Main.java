/**
	This file, Main.java, along with TicTacToeFrame.java, implements a GUI-based
	tic-tac-toe game. The program opens a java frame to host the game board.
	Players, X and O, take turns making moves by clicking on empty squares.
	If the square is available, it will be filled with the mark of the current
	player. After each successful move, the program will check if the game is 
	over or has been tied. If the game is won or tied, a button for starting a 
	new game will become available.
*/
import javax.swing.JFrame;

/**
	This program acts as a driver for the TicTacToeFrame class. The frame
	will run until the user closes it.
*/
public class Main {
	public static void main(String[] args) {
		TicTacToeFrame frame = new TicTacToeFrame();
		frame.setTitle("Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}