import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MouseDrawDemo extends JFrame implements MouseListener {
	private int xcoord;
	private int ycoord;
	private boolean clicked = false;
//	private ArrayList<Point> points;
	
	
	public void mouseClicked(MouseEvent e) {
		xcoord = e.getX();
		ycoord = e.getY();
//		points.add(new Point(e.getX(), e.getY()));
		clicked = true;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
	}
	
	public static void main(String[] args) {
		MouseDrawDemo m = new MouseDrawDemo();
		m.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(clicked) {
//			for(Point point : points) {
//				g.fillOval(point.x, point.y, 30, 30);
//			}
			g.fillOval(xcoord, ycoord, 30, 30);
		}		
	}
}
