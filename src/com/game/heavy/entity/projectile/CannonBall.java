package com.game.heavy.entity.projectile;

import com.game.graphics.Screen;
import com.game.graphics.Sprite;

public class CannonBall extends Projectile {

	public CannonBall(int x, int y, int dir) {
		super(x, y, dir);
		this.x=x-16;
		this.y=y-16;
		range = 200;
		damage = 20;
		rateoffire =  1;
		speed = 1;
		sprite=Sprite.cannonBall;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	
}
	
	public void update(){
		move();
	}
	public void move(){
		x += nx;
		y += ny;
	}
	public void render(Screen screen){
		screen.rendertile(x ,y , sprite);
	}
}