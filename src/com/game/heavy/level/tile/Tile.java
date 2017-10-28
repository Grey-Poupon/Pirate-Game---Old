package com.game.heavy.level.tile;

import com.game.graphics.Screen;
import com.game.graphics.Sprite;

public class Tile {
	public static Tile grass = new Grasstile(Sprite.grass);
	public static Tile voidtile = new VoidTile(Sprite.voidsprite);
	public static Tile mud = new MudTile(Sprite.mud);
	public static Tile sand = new Grasstile(Sprite.sand);
	public static Tile water = new WaterTile(Sprite.water);


	
	public int x,y;
	public Sprite sprite;	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}

	
	public void render(int x,int y, Screen screen){
	}
	public boolean solid(){
		return true;
	}
}
