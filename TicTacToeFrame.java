import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.util.Arrays;
import java.util.ArrayList;

/**
	A TicTacToeFrame and game that inherits from the JFrame class.
*/
public class TicTacToeFrame extends JFrame {
	private static final int FRAME_WIDTH = 640;
	private static final int FRAME_HEIGHT = 480;

	private JButton button1, button2, button3;
	private JButton button4, button5, button6;
	private JButton button7, button8, button9;
	private JButton newGameButton;
	private JPanel buttonPanel, bottomPanel;
	private JLabel display;

	private int choice;
	private boolean playerx, gameOver, tie, available;
	private char[][] score;
	private char player;
	private ArrayList<Integer> positions;

	/**
		Constructs a TicTacToeFrame along with all of the necessary components.
		Also calls the newGame() method that initiates a new game.
	*/
	public TicTacToeFrame() {
		createButtons();
		createButtonPanel();
		createLabel();
		createNewGameButton();
		createBottomPanel();
		createMainPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		newGame();
	}

	/**
		Creates the 9 buttons that will be used in the game. Also adds an
		ActionListener to each button.
	*/
	private void createButtons() {
		button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 1;
				makeMove();
			}
		});
		button2 = new JButton();
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 2;
				makeMove();
			}
		});
		button3 = new JButton();
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 3;
				makeMove();
			}
		});
		button4 = new JButton();
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 4;
				makeMove();
			}
		});
		button5 = new JButton();
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 5;
				makeMove();
			}
		});
		button6 = new JButton();
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 6;
				makeMove();
			}
		});
		button7 = new JButton();
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 7;
				makeMove();
			}
		});
		button8 = new JButton();
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 8;
				makeMove();
			}
		});
		button9 = new JButton();
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				choice = 9;
				makeMove();
			}
		});
	}

	/**
		Creates a panel for containing the 9 buttons.
	*/
	private void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		buttonPanel.add(button7);
		buttonPanel.add(button8);
		buttonPanel.add(button9);
	}

	/**
		Creates a display label that appears at the bottom of the frame.
	*/
	private void createLabel() {
		display = new JLabel();
		display.setFont(new Font("Arial", Font.BOLD, 22));
		display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	/**
		Creates a new game button that is used for initiating a new game.
		The button only appears when the game is over. It becomes hidden
		again when the button is clicked.
	*/
	private void createNewGameButton() {
		newGameButton = new JButton("New Game");
		newGameButton.setVisible(false);
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				newGame();
				newGameButton.setVisible(false);
			}
		});
	}

	/**
		Creates a panel for containing both the new game button and the 
		display label at the bottom of the frame.
	*/
	private void createBottomPanel() {
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		display.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottomPanel.add(newGameButton);
		bottomPanel.add(display);
	}

	/**
		Creates a main panel for containing the two other panels.
	*/
	private void createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(3, 3));
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(mainPanel);
	}

	/**
		Initiates a new game. Resets all corresponding variables, arrays, 
		and text.
	*/
	private void newGame() {
		clearButtonText();
		playerx = true; 
		gameOver = false; 
		tie = false;
		available = true;
		score = new char[3][3];
		positions = getAvailablePos();
		display.setText("Player X, please click on an empty square.");
	}

	/**
		Clears the text of the 9 buttons contained in the button panel.
	*/
	private void clearButtonText() {
		button1.setText("");
		button2.setText("");
		button3.setText("");
		button4.setText("");
		button5.setText("");
		button6.setText("");
		button7.setText("");
		button8.setText("");
		button9.setText("");
	}

	/**
		Creates and returns the positions array list.
		@return the positions array list
	*/
	private ArrayList<Integer> getAvailablePos() {
	    positions = new ArrayList<Integer>();
	    positions.add(1);
	    positions.add(2);
	    positions.add(3);
	    positions.add(4);
	    positions.add(5);
	    positions.add(6);
	    positions.add(7);
	    positions.add(8);
	    positions.add(9);

	    return positions;
	}

	/**
		The method called by clicking on one of the 9 buttons in the 
		button panel. Checks whether the game is over or tied before
		taking any corresponding action.
	*/
	private void makeMove() {
		if (!gameOver && !tie) {
			getSpot();
		}
		if (gameOver || tie) {
			printResults();
			newGameButton.setVisible(true);
		}
	}

	/**
		Calls appropriate methods if a position is available. Otherwise
		alerts the player that the position is not available.
	*/
	private void getSpot() {
		player = getPlayer();
		if (spotAvailable()) {
			available = true;
			changeButtonText();
			gameOver = isGameOver();
			tie = isTie();
			if (!gameOver && !tie) {
				decidePlayer();
				player = getPlayer();
				display.setText("Player " + player + ", please click on an empty square.");
			}
		}
		else {
			available = false;
			display.setText("Sorry, that position is not available.");
		}
	}

	/**
		Assigns either 'X' or 'O' to the variable player based on the value
		of the boolean variable playerx.
		@return the char variable player
	*/
	private char getPlayer() {
		if (playerx) {
			player = 'X';
		}
		else {
			player = 'O';
		}

		return player;
	}

	/**
		Checks if the position chosen by the player is available.
		@return true if the position is available, false otherwise
	*/
	private boolean spotAvailable() {
		for (int i = 0; i < positions.size(); i++) {
			if (choice == positions.get(i)) {
				positions.remove(i);
				addToScore();
				return true;
			}
		}

		return false;
	}

	/**
		Depending on the current player, adds either an 'X' or an 'O' to
		the score array in the appropriate position.
	*/
	private void addToScore() {
        if (choice == 1) {
            score[0][0] = player;
        }
        else if (choice == 2) {
            score[0][1] = player;
        }
        else if (choice == 3) {
            score[0][2] = player;
        }
        else if (choice == 4) {
            score[1][0] = player;
        }
        else if (choice == 5) {
            score[1][1] = player;
        }
        else if (choice == 6) {
            score[1][2] = player;
        }
        else if (choice == 7) {
            score[2][0] = player;
        }
        else if (choice == 8) {
            score[2][1] = player;
        }
        else if (choice == 9) {
            score[2][2] = player;
        }
    }

    /**
		Places a red 'X' or an orange 'O' on the button that was clicked on
		if the position is available.
    */
    private void changeButtonText() {
    	if (choice == 1) {
    		button1.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button1.setForeground(Color.RED);
    		}
    		else {
    			button1.setForeground(Color.ORANGE);
    		}
    		button1.setText(String.valueOf(player));
    	}
    	else if (choice == 2) {
    		button2.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button2.setForeground(Color.RED);
    		}
    		else {
    			button2.setForeground(Color.ORANGE);
    		}
    		button2.setText(String.valueOf(player));
    	}
    	else if (choice == 3) {
    		button3.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button3.setForeground(Color.RED);
    		}
    		else {
    			button3.setForeground(Color.ORANGE);
    		}
    		button3.setText(String.valueOf(player));
    	}
    	else if (choice == 4) {
    		button4.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button4.setForeground(Color.RED);
    		}
    		else {
    			button4.setForeground(Color.ORANGE);
    		}
    		button4.setText(String.valueOf(player));
    	} 	
    	else if (choice == 5) {
    		button5.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button5.setForeground(Color.RED);
    		}
    		else {
    			button5.setForeground(Color.ORANGE);
    		}
    		button5.setText(String.valueOf(player));
    	}
    	else if (choice == 6) {
    		button6.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button6.setForeground(Color.RED);
    		}
    		else {
    			button6.setForeground(Color.ORANGE);
    		}
    		button6.setText(String.valueOf(player));
    	}
    	else if (choice == 7) {
    		button7.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button7.setForeground(Color.RED);
    		}
    		else {
    			button7.setForeground(Color.ORANGE);
    		}
    		button7.setText(String.valueOf(player));
    	}
    	else if (choice == 8) {
    		button8.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button8.setForeground(Color.RED);
    		}
    		else {
    			button8.setForeground(Color.ORANGE);
    		}
    		button8.setText(String.valueOf(player));
    	}
    	else if (choice == 9) {
    		button9.setFont(new Font("Arial", Font.BOLD, 60));
    		if (player == 'X') {
    			button9.setForeground(Color.RED);
    		}
    		else {
    			button9.setForeground(Color.ORANGE);
    		}
    		button9.setText(String.valueOf(player));
    	}
    }

    /**
		Checks if the game has been won by either player.
		@return true if the game has been won, false otherwise
    */
    private boolean isGameOver() {
		if (score[0][0] == player && score[0][1] == player && score[0][2] == player) {
			return true;
		}
		else if (score[1][0] == player && score[1][1] == player && score[1][2] == player) {
			return true;
		}
		else if (score[2][0] == player && score[2][1] == player && score[2][2] == player) {
			return true;
		}
		else if (score[0][0] == player && score[1][0] == player && score[2][0] == player) {
			return true;
		}
		else if (score[0][1] == player && score[1][1] == player && score[2][1] == player) {
			return true;
		}
		else if (score[0][2] == player && score[1][2] == player && score[2][2] == player) {
			return true;
		}
		else if (score[0][0] == player && score[1][1] == player && score[2][2] == player) {
			return true;
		}
		else if (score[0][2] == player && score[1][1] == player && score[2][0] == player) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
		Checks if the game has been tied.
		@return true if the game has been tied, false otherwise
	*/
	private boolean isTie() {
        if (positions.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
		Alternates between players by assigning either true or false to 
		the boolean variable playerx.
		@return the boolean variable playerx
    */
	private boolean decidePlayer() {
			if (playerx) {
				playerx = false;
			}
			else {
				playerx = true;
			}

		return playerx;
	}    

	/**
		Prints the results of the game, either declaring the winner or 
		declaring a tie.
	*/
    private void printResults() {
		if (gameOver) {
			display.setText("Player " + player + " wins!");
		}
		else {
			display.setText("It's a tie!");
		}
	}
}
