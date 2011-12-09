import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game {

	private Game() {
		// Top-level frame
		final JFrame frame = new JFrame("TypeInvaders");
		frame.setLocation(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Main playing area
		final PongCourt court = new PongCourt();
		frame.add(court, BorderLayout.SOUTH);

		// Reset button
		final JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.NORTH);
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				court.reset();
			}
		});
		//panel.add(reset);
		
		final JPanel hello = new JPanel();
		frame.add(hello, BorderLayout.NORTH);
		final JLabel welcome = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 30px'>" +
						"Welcome_to_<br /><big>TypeInvaders</big></span></html>");
		final JLabel instructions = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 15px'>" +
						"use_your_spacebar_to_fire_helvetica_characters<br />" +
						"at_the_oncoming_comic_sans_ms_invaders._use_<br />" +
						"arrow_keys_to_move._some_invaders_are_tenacious;<br />" +
						"hang_in_there!_But_run_into_more_than_three...Game_over.</span></html>");
		hello.add(welcome, BorderLayout.NORTH);
		hello.add(instructions, BorderLayout.CENTER);
		
		/*final JPanel scoreboard = new JPanel();
		JLabel lives = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 20px'>" +
						"Lives:_3</span></html>");
		JLabel score = 
				new JLabel("<html><span style = 'font-family: Blackout; font-size: 20px'>" +
						"Score:_0</span></html>");
		scoreboard.add(lives,BorderLayout.WEST);
		scoreboard.add(score,BorderLayout.EAST);
		frame.add(scoreboard,BorderLayout.CENTER);*/
		

		// Put the frame on the screen
		frame.pack();
        frame.setVisible(true);
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
