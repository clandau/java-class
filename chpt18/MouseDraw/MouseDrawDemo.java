import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MouseDrawDemo extends JFrame implements MouseListener {
	//hold the X,Y coordinates of the click location
	private int xCoord;
	private int yCoord;
	//hold the X,Y coordinates to offset the circle so that it is drawn in the middle of the 
	//click location 
	private int xOffset = 3;
	private int yOffset = 3;
	
	public void mouseClicked(MouseEvent e) {
		xCoord = e.getX();
		yCoord = e.getY();
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public MouseDrawDemo() {
		super();
		setSize(600,400);
		setTitle("Mouse Draw Demo");
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
	}

	public static void main(String[] args) {
		MouseDrawDemo m = new MouseDrawDemo();
		m.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.CYAN);
		g.fillOval(xCoord-xOffset, yCoord-yOffset, 6, 6);	
	}
}
