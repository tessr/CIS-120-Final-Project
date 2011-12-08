import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

@SuppressWarnings("serial")
public class PongCourt extends JPanel {
	
	private Paddle paddle;
	private ArrayList<Bullet> bullets;
	private ArrayList<Invader> invaders;

	private int interval = 35; // Milliseconds between updates.
	private Timer timer;       // Each time timer fires we animate one step.
	private int invader_interval = 600;
	private Timer invader_timer;

	final int COURTWIDTH = 800;
	final int COURTHEIGHT = 600;

	final int PADDLE_VEL = 4;
	
	private int lives = 3;
	private int score = 0;
	
	Font blackout = new Font("Blackout", Font.PLAIN, 60);

	public PongCourt() {
		setPreferredSize(new Dimension(COURTWIDTH, COURTHEIGHT));
		setFocusable(true);

		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent e) { tick(); }});
		timer.start(); 
		
		invader_timer = new Timer(invader_interval, new ActionListener() {
			public void actionPerformed(ActionEvent e) { invade(); }});
		invader_timer.start(); 

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					paddle.setVelocity(-PADDLE_VEL, 0);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					paddle.setVelocity(PADDLE_VEL, 0);
				else if (e.getKeyCode() == KeyEvent.VK_SPACE)
					bullets.add(paddle.fire());
				else if (e.getKeyCode() == KeyEvent.VK_R)
					reset();
			}

			public void keyReleased(KeyEvent e) {
				paddle.setVelocity(0, 0);
			}
		});
		// After a PongCourt object is built and installed in a container
		// hierarchy, somebody should invoke reset() to get things started... 
	}

	public void reset() {
		paddle = new Paddle(COURTWIDTH, COURTHEIGHT);
		bullets = new ArrayList<Bullet>();
		invaders = new ArrayList<Invader>();
		grabFocus();
	}
	
	void tick() {
		if(paddle != null)
		{
			paddle.setBounds(getWidth(), getHeight());
			paddle.move();
		
			for(Iterator<Bullet> ii = bullets.iterator(); ii.hasNext();)
			{
				Bullet bb = ii.next();
				if(bb.y > 0)
				{
					bb.setBounds(getWidth(),getHeight());
					bb.move();
					Invader attacked = bb.attacked(invaders);
					if(attacked != null) 
					{
						ii.remove();
						invaders.remove(attacked);
					}
				}
				else
				{
					ii.remove();
				}
			}
		}
		repaint(); // Repaint indirectly calls paintComponent.
	}
	
	void invade() {
		invaders.add(new Invader(10,30,1,0));
		boolean youlose = false;
		for(Iterator<Invader> ii = invaders.iterator(); ii.hasNext();)
		{
			Invader inv = ii.next(); 
			inv.setBounds(getWidth(),getHeight());
			inv.move();
			if(inv.intersects(paddle) != Intersection.NONE)
			{
				youlose = true;
			}
		}
		
		if(youlose)
		{
			invaders.clear();
			paddle = null;
			invader_timer.stop();
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Paint background, border
		if(paddle != null)
		{
			paddle.draw(g);
			for (Bullet bb : bullets)
			{
				bb.draw(g);
			}
			
			for(Invader inv : invaders)
			{
				inv.draw(g);
			}
		}
		else
		{
			blackout.deriveFont(60);
			g.setFont(blackout);
			g.drawString("you lose", COURTWIDTH/2, COURTHEIGHT/2);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(blackout.getFontName(),Font.PLAIN, 30));
		g.drawString("Score:_" + score, 120, 30);
		g.drawString("Lives:_"+lives, 240, 30);

	}
}
