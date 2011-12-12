import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class Game {

	private Game() {
		// Top-level frame
		final JFrame frame = new JFrame("TypeInvaders");
		frame.setLocation(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		
		//fonts
		File blackoutfile;
		Font blackout = new Font("Blackout",Font.PLAIN,30);
		
		try
		{
			blackoutfile = new File("Blackout 2AM.ttf");
			blackout = Font.createFont(Font.TRUETYPE_FONT, blackoutfile );
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		catch (FontFormatException e)
		{
			
		}
		

		// Main playing area
		final PongCourt court = new PongCourt();
		frame.add(court, BorderLayout.SOUTH);
		frame.setFont(new Font(blackout.getFontName(), Font.PLAIN, 30));
		
		final JPanel hello = new JPanel();
		frame.add(hello, BorderLayout.NORTH);
		final JLabel welcome = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 30px'>" +
						"Welcome_to_<br /><big>TypeInvaders</big></span></html>");
		
		final JLabel instructions_prompt = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 15px'>" +
						"hit_'i'_for_instructions</span></html>");
		hello.add(welcome, BorderLayout.NORTH);
		
		final JLabel instructions = 
				new JLabel("<html>" +
						"<span style = 'font-family: Blackout; font-size: 35px'>" + 
						"Welcome_to_Typeinvaders</span><br/>"+
						"<p><span style = 'font-family: Helvetica; font-size: 11px'>" +
						"<b>Just like Space Invaders, but much scarier!</b><br />" +
						"Use the spacebar to fire little Helvetica characters "+
						" at the oncoming Comic Sans <br/> invaders. Use arrow keys " +
						"to move your trusty exclamation point nozzle. Note: Some <br/>" +
						"invaders are tenacious (a.k.a. bold) and need more than " +
						"one hit before they die!<br />And be careful: If the nozzle " +
						"is touched by three invaders, you lose!"+
						"</span></p></html>");
		hello.add(welcome, BorderLayout.NORTH);
		hello.add(instructions_prompt, BorderLayout.CENTER);
		
		final JDialog instructiondialog = new JDialog();
		instructiondialog.setFont(new Font(blackout.getFontName(), Font.PLAIN, 30));
		instructiondialog.add(instructions);
		
		instructiondialog.setLocation(350,350);
		instructiondialog.pack();
	
		

		// Put the frame on the screen
		frame.pack();
        frame.setVisible(true);
        
       court.addKeyListener(new KeyAdapter(){
        	public void keyPressed(KeyEvent e)
        	{
        		if(e.getKeyCode() == KeyEvent.VK_I)
        			instructiondialog.setVisible(true);
        	}
        });
		// Start the game running
        court.reset();
		}

	/*
	 * Rather than directly building the top level frame object in the main
	 * method, we use the invokeLater utility method to ask the Swing framework
	 * to invoke the method 'run' of the Runnable object we pass it, at some
	 * later time that is convenient for it. (The key technical difference is
	 * that this will cause the new object to be created by a different
	 * "thread".)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Game();
			}
		});
	}

}
