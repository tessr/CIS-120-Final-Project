import java.awt.*;

public class Paddle extends GameObject {
	final static int HEIGHT = 30;
	final static int WIDTH = 80;

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
		//g.fillRect(x, y, WIDTH, HEIGHT);
		g.setColor(Color.orange);
		Font helvetica = new Font("Helvetica", Font.PLAIN, HEIGHT);
		g.setFont(helvetica);
		g.drawString("helvetica",x,y + HEIGHT);
		
	}
	
	public Bullet fire()
	{
		Bullet bb = new Bullet(x + WIDTH/2, y, 0, -1);
		return bb;
	}
}
