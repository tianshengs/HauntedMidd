// Success.java
// Final Project CS201
// Aiko Genius Statue (Section A), Tiansheng Sun (Section B)

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

// success panel
class Success extends Main{
	private static final long serialVersionUID = 1L;
	
	JLabel congratulations;
	JLabel finalScenarios;
	JButton restart;
	int finalLives;
	
	public Success() {
		finalScenarios = new JLabel();
		finalScenarios.setFont(new Font("TimesRoman", Font.BOLD, 30)); // set text
    	finalScenarios.setOpaque(true);
    	finalScenarios.setBackground(Color.magenta);
    	finalScenarios.setHorizontalAlignment(JLabel.LEFT);
		drawSuccess();
	}
	
	public Success drawSuccess() {
		congratulations = new JLabel();
    	congratulations.setFont(new Font("Serif", Font.BOLD, 35)); // set text
        congratulations.setVerticalAlignment(JLabel.CENTER);
        congratulations.setHorizontalAlignment(JLabel.CENTER);
        congratulations.setOpaque(true); 
        congratulations.setForeground(Color.red);
        congratulations.setBackground(Color.yellow);
        restart = new JButton("restart");
        setLayout(new BorderLayout());
        add("North", finalScenarios);
        add("Center", congratulations);
        add("South", restart);
		return this; 
    }
	
	public void setcongratulations(int lives) {
		congratulations.setText("<html>Congratulations! <br> "
    			+ "You survived the Haunted Midd! <br> Your friends are so proud of you!"
    			+ " <br> <br> You won with " + lives + " lives left.");
	}
	public void addNextActionListener(ActionListener listener) {
        restart.addActionListener(listener);
    }	
}