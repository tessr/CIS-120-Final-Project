import java.awt.*;

public class Paddle extends GameObject {
	final static int HEIGHT = 55;
	final static int WIDTH = 10;
	String name = "!";

	public Paddle(int courtwidth, int courtheight) {
		super((courtwidth - WIDTH) / 2, courtheight - HEIGHT - 20, 0, 0, WIDTH, HEIGHT);
	}

	public void accelerate() {
		if (x < 0 || x > rightBound)
			velocityX = 0;
		if (y < 0 || y > bottomBound)
			velocityY = 0;
	}

	public void draw(Graphics g) {
		g.setColor(Color.orange);
		Font midnight = new Font("Blackout", Font.PLAIN, HEIGHT);
		g.setFont(midnight);
		g.drawString(name,x,y + HEIGHT);
		
	}
	
	public Bullet fire()
	{
		Bullet bb = new Bullet(x + WIDTH/2, y, 0, -3);
		return bb;
	}
}
