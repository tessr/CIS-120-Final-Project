import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;


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
	}
	
	/*public Invader attacked(Army invaders)
	{
		for(Invader ii : invaders)
		{
			if(intersects(ii) != Intersection.NONE)
			{
				return ii;
			}
		}
		return null;
	}*/

}
