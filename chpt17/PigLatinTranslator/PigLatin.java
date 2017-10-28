import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * a simple pig Latin translator GUI in swing. 
 * Allows a user to enter text and click a button which 
 * translates it to Pig Latin. 
 * @author Courtney
 */

public class PigLatin extends JFrame implements ActionListener {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;
	public static final int NUMBER_OF_ROWS = 3;
	public static final int NUMBER_OF_DIGITS = 60;
	public static final Color pigPink = Color.decode("#FFB6C1");
	
	private JTextArea input;
	private JTextArea output;
	private JButton translateButton;
	private JButton clearButton;

	public static void main(String[] args) {
		PigLatin translator = new PigLatin();
		translator.setVisible(true);
	}
	
	public PigLatin() {
		setTitle("Pig latin translator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		textPanel.setBackground(pigPink);
		input = new JTextArea("Enter \ntext here", NUMBER_OF_ROWS, NUMBER_OF_DIGITS);
		textPanel.add(input);
		translateButton = new JButton("Click to translate");
		
		translateButton.addActionListener(this);
		textPanel.add(translateButton);
		clearButton = new JButton("Clear text");
		
		//anonymous function for clear button action listener
		clearButton.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						input.setText(" ");
						output.setText(" ");
					}
				});
		textPanel.add(clearButton);
		output = new JTextArea("", NUMBER_OF_ROWS, NUMBER_OF_DIGITS);
		textPanel.add(output);
		
		add(textPanel);	
	}
	
	public void actionPerformed(ActionEvent e) {
		String textEntered = input.getText();
		String finishedLine = "";
		Scanner scan = new Scanner(textEntered);
		while (scan.hasNext()) {
			finishedLine += translate(scan.next()) + " ";
		}	
		output.setText(finishedLine);
		scan.close();
	}
	
	/**
	 * Takes a String word of text and returns a string of that
	 * word translated into Pig Latin. 
	 * @param text
	 */
	public String translate(String text) {
		char firstLetter = text.charAt(0);
		if (firstLetter == 'a' || firstLetter == 'A' || firstLetter == 'e' || 
				firstLetter == 'E' || firstLetter == 'i' || firstLetter == 'I' || 
						firstLetter == 'o' || firstLetter == 'O' || firstLetter == 'u' || 
						firstLetter == 'u') {
			return text + "way";
		}
		else {
			return text.substring(1) + Character.toLowerCase(firstLetter) + "ay";
		}
	}
}
