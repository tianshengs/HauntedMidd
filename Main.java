// Main.java
// Final Project CS201
// Aiko Genius Statue (Section A), Tiansheng Sun (Section B)

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.*;

class Main extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
    protected int livesLeft; // keep track of the number of lives a user still have
	protected int numberOfQuestion; //keep track of the question Number
	protected JLabel title;
	protected JLabel question; // a label presenting a question
	protected JLabel scenarios; // a label that print out the scenario
	protected JLabel numberOfLives; // a label that shows the number of lives  
	protected JLabel questionNumber;
	protected JButton optionA; 
	protected JButton optionB;
	protected JButton optionC;
	protected int livesLost; //keep track of the number of lives a user lost
	protected int optionIndex;
	protected boolean action;
	
	protected String [] Qarr ;
	protected String[][] optionArr;
	
	public Main(){
		livesLeft = 3;
    	numberOfQuestion = 1;
		scenarios = new JLabel("<html> Welcome! <html>");
		
		drawMainScreen();
	}
	
	   //Draw the title panel 
    public JLabel titlePanel( ) {
    	title = new JLabel("Haunted Midd: The Survival XVII");
    	title.setFont(new Font("TimesRoman", Font.ITALIC|Font.BOLD, 20)); // set text
    	title.setHorizontalAlignment(JLabel.CENTER);
    	title.setForeground(Color.black);
    	title.setBackground(Color.darkGray);
		return title;
    }
    
    // draws the main program
    public Main drawMainScreen() {
    	
    	// scenario, lives, question number panel
    	JPanel scenarioLivesPanel = new JPanel();
    	scenarioLivesPanel.setLayout(new BorderLayout());
    	
    	numberOfLives = new JLabel("  " + livesLeft + " lives left...");   	
    	numberOfLives.setFont(new Font("TimesRoman", Font.BOLD, 25)); // set text
    	numberOfLives.setOpaque(true);//https://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color
    	numberOfLives.setBackground(Color.cyan);
    	
    	scenarios = new JLabel("<html> Welcome! <html>");
    	scenarios.setFont(new Font("TimesRoman", Font.BOLD, 20)); // set text
    	scenarios.setOpaque(true);
    	scenarios.setBackground(Color.lightGray);
    	scenarios.setHorizontalAlignment(JLabel.CENTER);
    	
    	questionNumber = new JLabel("Question" + numberOfQuestion);
    	questionNumber.setFont(new Font("TimesRoman", Font.ITALIC|Font.BOLD, 25)); // set text
    	questionNumber.setOpaque(true);
    	questionNumber.setForeground(Color.white);
    	questionNumber.setBackground(Color.black);
    	questionNumber.setHorizontalAlignment(JLabel.CENTER);
    	
    	scenarioLivesPanel.add("Center", scenarios);
        scenarioLivesPanel.add("East", numberOfLives);
        scenarioLivesPanel.add("South", questionNumber);
        
    	// question panel
        question = new JLabel("<html>This is where the question will appear.<html>"); // initialize variables
        question.setFont(new Font("Serif", Font.BOLD, 30)); // set text
        question.setVerticalAlignment(JLabel.TOP);
        question.setOpaque(true); 
        question.setForeground(Color.white);
        question.setBackground(Color.black);
        
        Qarr = new String[] {"<html>The dining hall is closed. You’re hungry. Where would you like to go?<html>", 
				  "<html>After the dinner, you want to have some fun. Where would you like to go?<html>", 
				  "<html>It’s night time, you have to find a place to sleep. What do you want to do?<html>", 
				  "<html>Suddenly you hear a voice asking you to go to the restroom. What do you want to do?<html>", 
				  "<html>You realized this place is dangerous. You have to figure out a way to leave the haunted house. How do you get out of the house?<html>"}; 
        
        question = new JLabel(Qarr[0]); // initialize variables
        question.setBackground(Color.white);
        question.setHorizontalAlignment(JLabel.CENTER);
        
        Border border = BorderFactory.createMatteBorder(40, 40, 40, 40, Color.gray);
        question.setBorder(border);
        
        // option panel
        Panel optionPanel = new Panel(); 
        optionPanel.setLayout(new GridLayout(3, 1)); // grid layout
        
        optionPanel.setFont(new Font("TimesRoman", Font.BOLD, 20)); // set text
    	
    	optionArr = new String[][] {{"<html>Go to the dining hall anyway<html>", 
				"<html>Go to Sabai Sabai<html>", 
				"<html>Go to your host family’s house<html>"}, 

				{"<html>Fitness Center<html>",
				 "<html>Burlington<html>", 
				 "<html>Haunted House<html>"}, 
				
				{"<html>Go back to your room. <html>", 
				 "<html>Stay at Middlebury Inn. <html>",	 
				 "<html>Go to Jewett (Health and Wellness house…that nobody knows about)<html>",
				}, 
				
				{"<html>Stay in your bed<html>", 
				 "<html>Go to the restroom<html>",	 
				 "<html>Follow the voice<html>",
				}, 
				
				{"<html>Go out the front door. <html>", 
				 "<html>Climb to the roof and use the emergency ladder. <html>",	 
				 "<html>You called your friend asked your friend to come pick you up. <html>",
				}};

			optionA = new JButton(optionArr[numberOfQuestion-1][0]);
			optionB = new JButton(optionArr[numberOfQuestion-1][1]); 
			optionC = new JButton(optionArr[numberOfQuestion-1][2]); 
			
			optionA.setBackground(Color.black);
	    	optionB.setBackground(Color.black);
	    	optionC.setBackground(Color.black);
	    	
	    	optionA.addMouseListener(this);
	    	optionB.addMouseListener(this);
	    	optionC.addMouseListener(this);
	    	
	    	optionPanel.add(optionA);
	    	optionPanel.add(optionB);
	    	optionPanel.add(optionC);
        
    	// intermediate "center" panel w/ question and options
    	Panel center = new Panel(); 
    	center.setLayout(new GridLayout(3, 1));
    	
    	center.add(scenarioLivesPanel);
    	center.add(question);
        center.add(optionPanel);
        
        // main panel
        setLayout(new BorderLayout());
        add("North", titlePanel());
        add("Center", center);
		return this;
    }
    
	public void mouseEntered(MouseEvent b) {
		((JButton) b.getSource()).setForeground(Color.white);
	}

	public void mouseExited(MouseEvent b) {
		((JButton) b.getSource()).setForeground(Color.darkGray);
		
	}
	
    public String[][] createScenarios() {
    	String[] [] arr = { // panel 1
   			 
	             //good scenarios
	 			{"<html>You got lucky because today is Thanksgiving! The dining hall has "
				 + "a special meal ready for you.<html>", 
				 "<html>Sabai Sabai is open! You ask for hotpot, but the owner gives you "
				 + "noodle soup instead… but overall you get a good meal.<html>", 
	 			 "<html>Your host family cooks great food! You had some delicious tofurkey.<html>"}, 
	 			
	 			//bad scenarios
	 			{"<html>The dining hall is CLOSED. You can’t get any food there! You lost " + livesLost + " lives.<html>", 
				 "<html>You lose your ID card on the way home! You can’t get back to your dorm, "
				 + "so you freeze to death. You lost " + livesLost + " lives.<html>", 
				 "<html>Your host family’s vicious dog bites you. You lost " + livesLost + " lives.<html>"}, 
	 			
	 			// panel 2
	 			
	 			//good scenarios
	 			{"<html>Everyone exercises and become super muscular.<html>", 
				 "<html>Good thing today’s Black Friday! You got all the best deals! <html>", 
				 "<html>The Haunted House wasn’t that scary, but you had a great time. <html>"}, 
	 			
	 			//bad scenarios
	 			{"<html>You try to deadlift, and break your spine. You lost " + livesLost + " lives.<html>", 
				 "<html>You lost all your money, your passport, and missed the bus back to campus. You lost " + livesLost + " lives.<html>", 
				 "<html>You got so scared that you had a heart attack. You lost " + livesLost + " lives.<html>"}, 
	 			
	 			// panel 3
	 			
	 			//good scenarios
	 			{"<html>Turns out your room is haunted! But you are familiar with your room. You hit the ghost in the head with your desk lamp. <html>", 
				 "<html>Turns out Middlebury Inn is haunted! But the hotel manager gave you a room that didn’t have ghosts in it. <html>", 
				 "<html>OH NO, JEWETT IS HAUNTED! But you realize that your friend lives in Jewett. The friend shares their bed with you for the night. <html>"}, 
	 			
	 			//bad scenarios
	 			{"<html>…but your room is haunted! And you saw two ghosts kissing each other! You died because of a heart condition due to singleness. "
	 			 + "You lost " + livesLost + " lives.<html>", 
	 			 "<html>Turns out Middlebury Inn is a 200-year-old building that is haunted during thanksgiving break. Your room had too many ghosts in it, "
	 			 + "and one of them turned you into a zombie. You lost " + livesLost + " lives.<html>", 
	 			 "<html>This house is haunted! It was a snowy day, and the ghost pushed you down stairs, resulting in a spine injury and death. You lost " 
	 			 + livesLost + " lives.<html>"}, 
	 			
	 			// panel 4
	 			
	 			//good scenarios
	 			{"<html>You fall asleep and the voice disappears. Nothing happens. <html>", 
				 "<html>You found 100 million dollars.<html>", 
				 "<html>You shouted at the voice and the voice ran away.<html>"}, 
	 			
	 			//bad scenarios
	 			{"<html>The voice got angry that you didn’t go to the restroom. The ghost kills you. You lost " + livesLost + " lives.<html>", 
	 			 "<html>You shouldn’t have listened to the voice! The ghost kills you by drowning you in the toilet. You lost " + livesLost + " lives.<html>", 
	 			 "<html>You were so focused about finding the vice, that you did not pay attention to your surroundings. You fall off the window "
	 			 + "and die. You lost " + livesLost + " lives.<html>"}, 
	 			
	 			// panel 5
	 			
	 			//good scenarios
	 			{"<html>Somehow you didn’t encounter any ghosts on your way to the front door, and you escaped the building. <html>", 
				 "<html>You get out of the building fine. Nothing happens. <html>", 
				 "<html>Your friend comes to the rescue, and all the ghosts run away.<html>"}, 
	 			
	 			//bad scenarios
	 			{"<html>The ghost blocked the entrance. You can’t get out. You lost " + livesLost + " lives.<html>", 
	 			 "<html>You were out of shape, and took you too much time to climb the roof, and the ghost caught "
	 			 + "up to you. You lost " + livesLost + " lives.<html>", 
	 			 "<html>You try to call your friend many times, but then you remember that your friend never responds "
	 			 + "to your messages anyway. The ghost finds you and you die. You lost " + livesLost + " lives.<html>"}};
    	 
		return arr;
    }
    
    public void handleLives() {
    	Random random = new Random();
    	livesLost = random.nextInt(2);
    	livesLeft = livesLeft - livesLost;
    }

    public String printScenario() {
    	String [][] scenarioChoices = createScenarios();
    	if (livesLost == 0) return scenarioChoices[2* numberOfQuestion - 2][optionIndex];
        else {
    	    numberOfLives.setText("  " + livesLeft + " lives left...");
            return scenarioChoices[2* numberOfQuestion - 1][optionIndex];
    	}
    }
    
    public void addNextActionListener(ActionListener listener) {
        optionA.addActionListener(listener);
        optionB.addActionListener(listener);
        optionC.addActionListener(listener);
    }
    
    public void clickAction(){
    	question.setText(Qarr[numberOfQuestion]);
    	optionA.setText(optionArr[numberOfQuestion][0]);
    	optionB.setText(optionArr[numberOfQuestion][1]);
    	optionC.setText(optionArr[numberOfQuestion][2]);
    	
    	scenarios.setText(printScenario());
    	numberOfQuestion += 1;
    	questionNumber.setText("Question" + numberOfQuestion);
    	
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
