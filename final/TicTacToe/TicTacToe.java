import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Implements a simple 3x3 tic-tac-toe game. Two players alternate 
 * clicking buttons to make their moves. A player wins if he fills in an entire
 * row, column, or diagonal.  
 * @author Courtney Landau
 *
 */
public class TicTacToe extends JFrame implements ActionListener {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	private JPanel instructionPanel;
	private JPanel buttonPanel;
	private JPanel resetButtonPanel;
	private JLabel instructions = new JLabel();
	private JButton[] button = new JButton[9];
	private JButton resetButton;
	
	private int moves = 0;
	private boolean gameInPlay = false;
	private int player = 1;
	//arrays to hold player's move count to help determine a winner
	private int[] playerOneScore = {0,0,0,0,0,0,0,0};
	private int[] playerTwoScore = {0,0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		TicTacToe toeBoard = new TicTacToe();
		toeBoard.setVisible(true);
	}
	
	public TicTacToe() {
		for (int i=0; i<8; i++) {
			playerOneScore[i] = 0;
			playerTwoScore[i] = 0;
		}
		setTitle("Tic Tac Toe Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		
		//panel for North region of border layout that contains text game
		//messages
		instructionPanel = new JPanel();
		instructionPanel.setLayout(new FlowLayout());
		JPanel formatNorthPanel = new JPanel();
		formatNorthPanel.setBorder(new EmptyBorder(10,10,10,10));
		instructions.setText("New Game | Turn: Player 1");
		instructions.setFont(new Font("Ariel", Font.PLAIN, 16));
		instructionPanel.add(instructions);
		formatNorthPanel.add(instructionPanel);
		add(formatNorthPanel, BorderLayout.NORTH);
		
		//panel for tic tac toe buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3, 0, 0));
		JPanel formatCenterPanel = new JPanel();
		
		//add buttons
		for (int i=0; i < 9; i++) {
			button[i] = new JButton();
			button[i].putClientProperty("index", i);
			button[i].setPreferredSize(new Dimension(50, 50));
			button[i].setFont(new Font("Arial", Font.PLAIN, 40));
			button[i].addActionListener(this);
			buttonPanel.add(button[i]);
		}
		formatCenterPanel.add(buttonPanel);
		add(formatCenterPanel, BorderLayout.CENTER);
		
		resetButtonPanel = new JPanel();
		resetButton = new JButton("Reset game");
		resetButton.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//reset scores
						for (int i=0; i< playerOneScore.length; i++) {
							playerOneScore[i] = 0;
							playerTwoScore[i] = 0;
						}
						//clear Xs and Os from buttons
						for (JButton buttonIndex : button) {
							buttonIndex.setText("");
						}
						//start a new game
						player = 1;
						moves = 0;
						gameInPlay = true;
						instructions.setText("New game | Turn: Player 1");
					}
				});
		resetButtonPanel.add(resetButton);
		add(resetButtonPanel, BorderLayout.SOUTH);
		
		gameInPlay = true;
	}
	
	/**
	 * paint method to place text and graphics on screen
	 */
//	public void paint(Graphics g) {
//		super.paint(g);
//	}
	
	public void actionPerformed(ActionEvent e) {
		if(gameInPlay) {
			JButton j = (JButton)e.getSource();
			int index = (int)j.getClientProperty("index");
			if (button[index].getText() != "X" && button[index].getText() != "O") {
				moves++;
				if (player == 1) {
					button[index].setText("X");
					incrementScore(index);
					if (checkWin()) {
						instructions.setText("Player 1 wins!");
						gameInPlay = false;
					}
					else if(moves == button.length) {
						instructions.setText("Draw");
						gameInPlay = false;
					}
					else {
						player = 2;
						instructions.setText("Turn: Player 2");
					}
				}
				else if (player == 2) {
					button[index].setText("O");
					incrementScore(index);
					if(checkWin()) {
						instructions.setText("Player 2 wins!");
						gameInPlay = false;
					}
					else {
						player = 1;
						instructions.setText("Turn: Player 1");
					}
				}
			}
		}
	}
		
	/**
	 * Each row, column and diagonal of the game board is represented
	 * in each scores array for each player.  This function contains the logic
	 * to determine which rows, columns, and/or diagonals to be incremented
	 * based on the location that was selected for the move. It increments
	 * the score inside each player's own scores array. 
	 */
	private void incrementScore(int index) {
		//if first row, increment first row
		if(index == 0 || index == 1 || index == 2) {
			if(player == 1) playerOneScore[0]++;
			else if(player == 2) playerTwoScore[0]++;
		}
		//increment second row
		else if(index == 3 || index == 4 || index == 5) {
			if(player == 1) playerOneScore[1]++;
			else if(player == 2) playerTwoScore[1]++;
		}
		//increment third row
		else if(index == 6 || index == 7 || index == 8) {
			if(player == 1) playerOneScore[2]++;
			else if(player == 2) playerTwoScore[2]++;
		}
		//increment columns
		if(index == 0 || index == 3 || index == 6) {
			if(player == 1) playerOneScore[3]++;
			else if(player == 2) playerTwoScore[3]++;
		}
		else if(index == 1 || index == 4 || index == 7) {
			if(player == 1) playerOneScore[4]++;
			else if(player == 2) playerTwoScore[4]++;
		}
		else if(index == 2 || index == 5 || index == 8) {
			if(player == 1) playerOneScore[5]++;
			else if(player == 2) playerTwoScore[5]++;
		}
		//increment diagonals
		if (index == 4) {
			if(player == 1) {
				playerOneScore[6]++;
				playerOneScore[7]++;
			}
			else if(player == 2) {
				playerTwoScore[6]++;
				playerTwoScore[7]++;
			}
		}
		else if(index == 0 || index == 8) {
			if(player == 1) playerOneScore[6]++;
			else if(player == 2) playerTwoScore[6]++;
		}
		else if(index == 2 || index == 6) {
			if(player == 1) playerOneScore[7]++;
			else if(player == 2) playerTwoScore[7]++;
		}
	}
	
	/**
	 * method to check if move resulted in a win. returns true if 
	 * that move has won the game. It works by checking the scores array
	 * of the player who moved to see if any of the rows, columns, or diagonals
	 * are completed by one player. if so, it returns true. 
	 */
	private boolean checkWin() {
		if(player == 1) {
			for(int score : playerOneScore) {
				if (score == 3) return true;
			}
		}
		if(player == 2) {
			for(int score : playerTwoScore) {
				if(score == 3) return true;
			}
		}
		return false;
	}
}
