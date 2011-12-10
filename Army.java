import java.awt.Graphics;


public class Army {
	
	private Invader[][] army;
	private int width;
	private int height;
	private int jpanelwidth;
	private int jpanelheight;
	int total;
	int killed;

	public Army(int x, int y, int jwid, int jhei) {
		army = new Invader[x][y];
		width = x;
		height = y;
		total = x*y;
		killed = 0;
		jpanelwidth = jwid;
		jpanelheight = jhei;
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				int xpos = xx*(Invader.SIZE) + 30;
				int ypos = yy*(Invader.SIZE) + 20;
						
				army[xx][yy] = new Invader(xpos,ypos,1,0);
			}
		}
	}
	
	public boolean dead()
	{
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				if(army[xx][yy] != null)
					return false;
			}
		}
		return true;
	}
	
	public Invader getInvader(int x, int y)
	{
		return army[x][y];
	}
	
	public void clear()
	{
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				army[xx][yy] = null;
			}
		}
	}
	
	public Invader kill(Bullet bb)
	{
		Invader killedi = null;
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				if(bb != null && army[xx][yy] != null && 
						bb.intersects(army[xx][yy]) != Intersection.NONE)
				{
					killedi = army[xx][yy];
					if(army[xx][yy].power)
					{
						army[xx][yy].power = false;
					}
					else
					{
						army[xx][yy] = null;
					}
					
					killed++;
				}
			}
		}
		
		return killedi;
	}
	
	public boolean hasKilled(Paddle paddle)
	{
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				if(army[xx][yy] != null)
				{
					if (army[xx][yy].intersects(paddle) != 
							Intersection.NONE)
					{
						army[xx][yy] = null;
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	public void move()
	{
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				if(army[xx][yy]!=null)
				{
					army[xx][yy].setBounds(jpanelwidth, jpanelheight);
					army[xx][yy].move();
					
				}

			}
		}
		
		Invader.nextround();
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
