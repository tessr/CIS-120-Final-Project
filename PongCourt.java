import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PongCourt extends JPanel {
	private Ball ball;
	private Paddle paddle;

	private int interval = 35; // Milliseconds between updates.
	private Timer timer;       // Each time timer fires we animate one step.

	final int COURTWIDTH = 300;
	final int COURTHEIGHT = 200;

	final int PADDLE_VEL = 4;

	public PongCourt() {
		setPreferredSize(new Dimension(COURTWIDTH, COURTHEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setFocusable(true);

		timer = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent e) { tick(); }});
		timer.start(); 

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					paddle.setVelocity(-PADDLE_VEL, 0);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					paddle.setVelocity(PADDLE_VEL, 0);
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
		ball = new Ball(0, 0, 2, 3);
		paddle = new Paddle(COURTWIDTH, COURTHEIGHT);
		grabFocus();
	}

	void tick() {
		ball.setBounds(getWidth(), getHeight());
		ball.move();
		paddle.setBounds(getWidth(), getHeight());
		paddle.move();
		ball.bounce(paddle.intersects(ball));
		repaint(); // Repaint indirectly calls paintComponent.
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Paint background, border
		ball.draw(g);
		paddle.draw(g);
	}
}
