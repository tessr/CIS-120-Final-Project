import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Invader extends GameObject {
	
	static final int SIZE = 30;
	static final int BUFFER = SIZE/2;
	
	/*
	 * The following three variables are static because all of the invaders move
	 * at the same way at the same time. next_svelocityX is a little bit of a 
	 * hack to get around the fact that when iterating through the array, the 
	 * first Invader which signals the change would be affected differently from
	 * all of the following arrays. 
	 */
	static int svelocityX = SIZE;
	static int next_svelocityX = svelocityX;
	static int yOffset = 20;
	
	int basey;
	String name;
	boolean power;

	public Invader(int x, int y, int velocityX, int velocityY) {
		super(x, y, SIZE, velocityY, SIZE, SIZE/2);
		basey = y;
		name = "" + randomCharacter();
		power = randomPower();
		svelocityX = SIZE;
		next_svelocityX = svelocityX;
		yOffset = 20;
	}
	
	@Override
	public void move() {
		x += svelocityX;
		accelerate();
		y = basey + yOffset;
	}
	
	public static void nextround() 
	{
		if(svelocityX != next_svelocityX)
		{
			yOffset += SIZE;
		}
		svelocityX = next_svelocityX;
	}

	@Override
	public void accelerate() {
		if(x >= rightBound || x < 0 + SIZE )
		{
			next_svelocityX = -svelocityX;
		}

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		Font comicsans;
		if(power) 
		{ 
			comicsans = new Font("Comic Sans MS", Font.BOLD, SIZE);
		}
		else
		{
			comicsans = new Font("Comic Sans MS", Font.PLAIN, SIZE);
		}
		
		g.setFont(comicsans);
		g.drawString(name,x,y + SIZE);

	}

}
