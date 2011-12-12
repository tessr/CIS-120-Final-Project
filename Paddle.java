import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Paddle extends GameObject {
	final static int HEIGHT = 55;
	final static int WIDTH = 10;
	String name = "!";
	private File blackoutfile;
	private Font blackout;

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
		
		try
		{
			blackoutfile = new File("Blackout 2AM.ttf");
			blackout = Font.createFont(Font.TRUETYPE_FONT, blackoutfile );
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		catch (FontFormatException e)
		{
			
		}
		
		g.setFont(new Font(blackout.getFontName(), Font.PLAIN, HEIGHT));
		g.drawString(name,x,y + HEIGHT);
		
	}
	
	public Bullet fire()
	{
		Bullet bb = new Bullet(x + WIDTH/2, y, 0, -3);
		return bb;
	}
}
