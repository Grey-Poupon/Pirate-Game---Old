package com.game.heavy.entity;

import java.util.Random;

import com.game.graphics.Screen;
import com.game.heavy.level.Level;

public class Entity {

	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	
	
	public void update(){
		
	}
	public void render(Screen screen){
		
	}
	public void remove(){
		//remove some people

		removed=true;
	}
	public boolean isremove(){
		return removed;
	}
	public void init(Level level){
		this.level=level;
	}
}
