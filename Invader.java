import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Invader extends GameObject {
	
	static final int SIZE = 30;
	static final int BUFFER = SIZE/2;
	String name;

	public Invader(int x, int y, int velocityX, int velocityY) {
		super(x, y, SIZE, velocityY, SIZE, SIZE);
		name = "" + randomCharacter();
	}

	@Override
	public void accelerate() {
		if(x >= rightBound || x < 0 )
		{
			System.out.println("Right bound: " + rightBound);
			velocityX = -velocityX;
			y = y + SIZE + BUFFER;
		}

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		Font comicsans = new Font("Comic Sans MS", Font.PLAIN, SIZE);
		g.setFont(comicsans);
		g.drawString(name,x,y + SIZE);

	}

}
