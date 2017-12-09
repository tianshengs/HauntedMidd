// Failure.java
// Final Project CS201
// Aiko Genius Statue (Section A), Tiansheng Sun (Section B)

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

// failure panel
class Failure extends JPanel{
	
	private static final long serialVersionUID = 1L;
		int finalQuestions;
		JLabel badnews;
		JLabel finalScenarios;
		JButton restart1; 
	
	public Failure() {
		finalScenarios = new JLabel();
		finalScenarios.setFont(new Font("TimesRoman", Font.BOLD, 30)); // set text
    	finalScenarios.setOpaque(true);
    	finalScenarios.setBackground(Color.magenta);
    	finalScenarios.setHorizontalAlignment(JLabel.LEFT);
		drawFailure();
	}
	
	public Failure drawFailure() {
		badnews = new JLabel();
    	badnews.setFont(new Font("Serif", Font.BOLD, 35)); // set text
        badnews.setVerticalAlignment(JLabel.CENTER);
        badnews.setHorizontalAlignment(JLabel.CENTER);
        badnews.setOpaque(true); 
        badnews.setForeground(Color.red);
        badnews.setBackground(Color.yellow);
        restart1 = new JButton("Restart");
        restart1.setBackground(Color.red);
        setLayout(new BorderLayout());
        add("North", finalScenarios);
        add("Center", badnews);
        add("South", restart1);
		return this;
    }
	
	public void addNextActionListener(ActionListener listener) {
        restart1.addActionListener(listener);
    }	 
	
	public void setbadnews(int question) {
		badnews.setText("<html>Unfortunately, everyone died! <br> "
    			+ "You did not make it to the end! <br>"
    			+ " <br> <br> You only finished " + finalQuestions + " questions.<html>");	
	}
}