package com.game.heavy.entity.projectile;

import com.game.graphics.Sprite;
import com.game.heavy.entity.Entity;

public abstract class Projectile extends Entity {
	 protected int xorigin , yorigin;
	 protected double angle;
	 protected double nx , ny;
	 protected Sprite sprite;
	 protected double speed , rateoffire,range,damage;
	 
	 
	 public Projectile(int x, int y, int dir){
		 xorigin = x;
		 yorigin = y;
		 angle = (dir-1)*Math.PI/2;
		 
	 }
	 protected void move(){
		 
	 }
}
