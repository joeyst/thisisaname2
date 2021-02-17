package avoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		//velX = r.nextInt(5) + 1;
		//velY = r.nextInt(5);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x,  0,  Game.WIDTH - 48);
		y = Game.clamp(y,  0,  Game.HEIGHT - 72);
		
		/*if(x <= 0 || x >= Game.WIDTH)velX *= 0;
		if(y <= 0 || y >= Game.HEIGHT)velY *= 0;*/
		
		collision();
		
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			//why won't it work with if/if
			if(tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 5;
				}else if(tempObject.getId() == ID.BasicEnemy) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD.HEALTH -= 2;}}}}
				}
				
			
			
			
				
	
	

	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(getBounds());
		
		
		g.setColor(Color.white);
		//if(id == ID.Player) g.setColor(Color.white);
		//else if(id == ID.Player2) g.setColor(Color.gray);
		g.fillRect(x, y, 32, 32);
	}
	
	

}
