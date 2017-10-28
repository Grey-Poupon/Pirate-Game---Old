package com.game.heavy.entity.mob;

import com.game.graphics.Screen;
import com.game.graphics.Sprite;
import com.game.input.Keyboard;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private int anim=0;
	private boolean walking = false;
	public Player(Keyboard input){	
		this.input=input;
		sprite = Sprite.playerup;	
	}

	
	
	public Player(int x,int y, Keyboard input){
		this.x=x;
		this.y=y;
		this.input=input;
		
		
	}
	public void update(){
		
		
		int xa=0, ya=0;
		if(anim < 7500)anim++;
		else anim=0;
		if(input.up)    ya--;
		if(input.down)  ya++;
		if(input.left)  xa--;
		if(input.right) xa++;
		if(input.fire)  updateshooting();

		
		if ((xa!=0||ya!=0)){
			move(xa,ya);
			walking =true;
		}else{
			walking=false;
		}
	}
	private void updateshooting(){
		shoot(x,y,dir);
	}
	
	
	
	public void render(Screen screen){
		int xx=x-16;
		int yy=y-16;
		if (dir==0){
			sprite = Sprite.playerup;
			if (walking){if(anim%20<10){sprite=Sprite.playerup1;}else{sprite=Sprite.playerup2;}}}
		if (dir==1){
			sprite = Sprite.playerdown;
			if (walking){if(anim%20<10){sprite=Sprite.playerdown1;}else{sprite=Sprite.playerdown2;}}}
		
		if (dir==2){
			sprite = Sprite.playerright;
		    if (walking){ if(anim%20<10){sprite=Sprite.playerright1;}else{sprite=Sprite.playerright2;}}}
		if (dir==3){
			sprite = Sprite.playerleft;
			if (walking){if (anim%20<10){sprite=Sprite.playerleft1;}else{sprite=Sprite.playerleft2;}}}
		screen.renderPlayer(xx, yy, sprite);
	}

}
