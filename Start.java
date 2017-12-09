// Start.java
// Final Project CS201
// Aiko Genius Statue (Section A), Tiansheng Sun (Section B)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Start extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	JLabel title;
	JLabel welcome;
	JButton start;
	
	public Start() {
		
		start = new JButton("Start Game!");
		start.setFont(new Font("TimesRoman", Font.ITALIC|Font.BOLD, 40)); // set text
		start.addMouseListener(this);
		title = new JLabel("Haunted Midd: The Survival XVII");
		title.setFont(new Font("TimesRoman", Font.ITALIC|Font.BOLD, 20)); // set text
		title.setHorizontalAlignment(JLabel.CENTER);
		welcome = new JLabel("<html> Welcome to the Haunted Midd! Are you ready?<html>");
		welcome.setFont(new Font("TimesRoman", Font.BOLD, 20)); // set text
    	welcome.setOpaque(true);
    	welcome.setBackground(Color.black);
    	welcome.setForeground(Color.white);
    	welcome.setHorizontalAlignment(JLabel.CENTER);
    	start.setForeground(Color.lightGray);
    	start.setBackground(Color.darkGray);
		setLayout(new GridLayout(3,1));
		add(title);
		add(welcome);
		add(start);
	}	
	public void addNextActionListener(ActionListener listener) {
        start.addActionListener(listener);
    }

	public void mouseEntered(MouseEvent b) {
		((JButton) b.getSource()).setForeground(Color.white);
	}
	public void mouseExited(MouseEvent b) {
		((JButton) b.getSource()).setForeground(Color.black);
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
