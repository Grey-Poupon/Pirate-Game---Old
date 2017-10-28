package com.game.heavy.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.game.graphics.Sprite;
import com.game.heavy.entity.Entity;
import com.game.heavy.entity.projectile.CannonBall;
import com.game.heavy.entity.projectile.Projectile;


public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	public void move(int xa, int ya){
		if (xa>0)dir=1;//right
		if (xa<0)dir=3;//left
		if (ya>0)dir=2;//down
		if (ya<0)dir=0;//up
		
		if(!collision(xa,0)){
		x+=xa;
		}
		if(!collision(0,ya)){
		y+=ya;
		}
	}
	
	public void update(){
		
	}

	protected void shoot(int x,int y,int dir){
		Projectile p = new CannonBall(x, y, dir);
		projectiles.add(p);
		level.add(p);
	}
	
	private boolean collision(int xa, int ya){
		boolean solid = false;
		for (int c=0;c<4;c++){
		int xt = ((x+xa) + c  % 2 *15 -16);
		int yt = ((y+ya) + c / 2 *8 -10);
		if(level.getTile((xt)>>4,(yt)>>4).solid())  solid = true;
		}
		return solid;
	}
   public void render(){
}
}
