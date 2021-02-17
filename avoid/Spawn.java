package avoid;

import java.util.Random;



public class Spawn {
	
	Random rand = new Random();
	int r = rand.nextInt(1000);
	
	private Handler handler;
	private HUD hud;
	
	private int scoreKeep = 0;
	private int runnerLevel = 1;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 100) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			handler.addObject(new BasicEnemy(r, r, ID.BasicEnemy, handler));
			runnerLevel = runnerLevel + 1;
			
		if(runnerLevel == 5) {
			handler.addObject(new FastEnemy(r, r, ID.FastEnemy, handler));
			runnerLevel = runnerLevel - 5;
		}
			
			/*if(hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(0, 0, ID.BasicEnemy, handler));*/
			}
		}
	}

