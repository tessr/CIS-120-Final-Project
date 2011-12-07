import java.awt.Color;
import java.awt.Graphics;


public class Bullet extends GameObject {
	
	final static int SIZE = 5;

	public Bullet(int x, int y, int velocityX, int velocityY) {
		super(x, y, velocityX, velocityY, SIZE, SIZE);
	}

	public void accelerate() {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.drawRect(x, y, SIZE, SIZE);

	}

}
