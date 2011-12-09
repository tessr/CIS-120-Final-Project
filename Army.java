import java.awt.Graphics;


public class Army {
	
	private Invader[][] army;
	private int width;
	private int height;
	private int total;
	private int killed;

	public Army(int x, int y) {
		army = new Invader[x][y];
		width = x;
		height = y;
		total = x*y;
		killed = 0;
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				int xpos = xx*(Invader.SIZE) + 5;
				int ypos = yy*(Invader.SIZE) + 10;
				System.out.println(xx);
				System.out.println(yy);
						
				army[xx][yy] = new Invader(xpos,ypos,1,0);
			}
		}
	}
	
	public Invader getInvader(int x, int y)
	{
		return army[x][y];
	}
	
	public Invader kill(Bullet bb)
	{
		Invader killed = null;
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				if(bb != null && army[xx][yy] != null && 
						bb.intersects(army[xx][yy]) != Intersection.NONE)
				{
					killed = army[xx][yy];
					army[xx][yy] = null;
				}
			}
		}
		
		return killed;
	}
	
	public void draw(Graphics g) {
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{			
				if(army[xx][yy] != null)
					army[xx][yy].draw(g);
			}
		}
		
	}

}
