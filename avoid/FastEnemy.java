package avoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class FastEnemy extends GameObject{

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		Random rand = new Random();
		int r = rand.nextInt(5);
		
		velX = 10 + r;
		velY = 10 - r;

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 56)velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32)velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 8, 8, 0.1f, handler));
		
	}


	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 8, 8);
		
	}

}
