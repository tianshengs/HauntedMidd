// HauntedMidd.java
// Final Project CS201
// Aiko Genius Statue (Section A), Tiansheng Sun (Section B)

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HauntedMidd extends Applet{

    private static final long serialVersionUID = 1L; // to avoid Eclipse warning
    
    // instance variables
    protected CardLayout cl = new CardLayout();
    protected Start start;
    protected Main main;
    protected Success success;
    protected Failure failure;

    public void init() {
    	
    	cl = new CardLayout();
    	setLayout(cl);
    	
    	start = new Start();
        main = new Main();
        success = new Success();
    	failure = new Failure();
    	
        ActionListener buttonListener = new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				perform(e);
			}
    	}; 
    	
    	//https://www.java-forums.org/new-java/52271-using-cardlayout-java-applet-.html
    	
    	start.addNextActionListener(buttonListener);
    	main.addNextActionListener(buttonListener);
    	success.addNextActionListener(buttonListener);
    	failure.addNextActionListener(buttonListener);
    	
    	add(start, "start");
    	add(main, "main");
    	
		cl = (CardLayout)(this.getLayout());
		cl.show(this,"start");
    }
   
    public void perform(ActionEvent e) {
    	
    	if (e.getSource() == start.start) {
			cl.show(this,"main");
		}
    	else if (e.getSource() == success.restart) {
			reset(); 
		}
    	else if (e.getSource() == failure.restart1) {
			reset();
		} 
    	else { // if other buttons pressed
			main.handleLives();
			
			if (main.livesLeft <= 0) { // if no lives left, failure
				
				failure.finalQuestions = main.numberOfQuestion - 1;
				failure.setbadnews(failure.finalQuestions);
				failure.finalScenarios.setText(main.printScenario());
				add(failure, "failure"); 
				cl.show(this, "failure");
			} 
			else { // if still lives left 
				
				if (main.numberOfQuestion < 5) { 
		        	if (e.getSource() == main.optionA) {
		        		main.optionIndex = 0;
		            } 
		        	else if (e.getSource() == main.optionB) {
		            	main.optionIndex = 1;
		            } 
		        	else if (e.getSource() == main.optionC) {
		            	main.optionIndex = 2;
		            }
		        	main.clickAction();	
		        	
		        } else { // if user reaches end, success
		        	success.finalLives = main.livesLeft;
		        	success.setcongratulations(success.finalLives);
		        	success.finalScenarios.setText(main.printScenario()); 
		        	add(success, "success"); 
		        	cl.show(this, "success");
		        } 
		}
		}      
    }
    // resets screen
    public void reset() {
    	
    	main.livesLeft = 3;
		main.numberOfQuestion = 1;
		main.numberOfLives.setText(main.livesLeft + " lives left...");
		main.questionNumber.setText("Question " + main.numberOfQuestion);
		main.question.setText(main.Qarr[0]); 
		
		cl.show(this,"start");
    }
}
