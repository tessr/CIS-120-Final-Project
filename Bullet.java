import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Bullet extends GameObject {
	
	final static int SIZE = 10;
	String name;

	public Bullet(int x, int y, int velocityX, int velocityY) {
		super(x, y, velocityX, velocityY, SIZE, SIZE);
		name = "" + randomCharacter();
	}

	public void accelerate() {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		Font helvetica = new Font("Helvetica", Font.PLAIN, SIZE);
		g.setFont(helvetica);
		g.drawString(name,x,y + SIZE);
		//g.drawRect(x, y, SIZE, SIZE);

	}

}
