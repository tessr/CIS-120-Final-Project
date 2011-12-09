import java.awt.Graphics;


public class Army {
	
	private Invader[][] army;
	private int width;
	private int height;
	private int jpanelwidth;
	private int jpanelheight;
	private int total;
	private int killed;

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
				int xpos = xx*(Invader.SIZE) + 20;
				int ypos = yy*(Invader.SIZE) + 10;
						
				army[xx][yy] = new Invader(xpos,ypos,1,0);
				System.out.println("New Invader: " + xpos + ", " + ypos);
			}
		}
	}
	
	public Invader getInvader(int x, int y)
	{
		return army[x][y];
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
					army[xx][yy] = null;
					killed--;
				}
			}
		}
		
		return killedi;
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
