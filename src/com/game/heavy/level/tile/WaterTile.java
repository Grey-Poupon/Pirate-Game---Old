package com.game.heavy.level.tile;

import com.game.graphics.Screen;
import com.game.graphics.Sprite;

public class WaterTile extends Tile {

	public WaterTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x,int y, Screen screen){
		screen.rendertile(x<<4, y<<4, this);
	}
	public boolean solid(){
		return false;
	}
}


