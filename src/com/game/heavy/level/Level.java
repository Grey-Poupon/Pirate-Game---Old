package com.game.heavy.level;


import java.util.ArrayList;
import java.util.List;

import com.game.graphics.Screen;
import com.game.heavy.entity.Entity;
import com.game.heavy.level.tile.Tile;

public class Level {
protected int width,height;
public int[] tiles;

private List<Entity> entities = new ArrayList<Entity>();

public Level(int width,int height){
	this.width=width;
	this.height=height;
	tiles= new int [width*height];
	generatelevel();
	
}
public Level(String path){
	loadlevel(path);
	
}
protected void generatelevel(){
	
}
protected void loadlevel(String path){
	
}
public void update(){
	for(int i = 0 ; i<entities.size() ; i++){
	entities.get(i).update();}
	
}
private void time(){
}

public void render(int xscroll,int yscroll,Screen screen){
	screen.setoffset(xscroll,yscroll);
	int x0=xscroll >> 4; 
	int x1 = (xscroll + screen.width +16)>>4;
	int y0 = yscroll >>4 ;
	int y1 = (yscroll + screen.height + 16)>>4;
	
	for(int y=y0;y<y1;y++){
		for (int x =x0;x<x1;x++){
			getTile(x,y).render(x, y, screen);
		}
	}
	for(int i = 0 ; i<entities.size() ; i++){
		entities.get(i).render(screen);}	
}
	

	
public void add(Entity e){
	entities.add(e);
}

public Tile getTile(int x, int y){
	if (x<0 || y<0 || x>=width ||y>=height) return Tile.voidtile;
	if (tiles[x + y *width]==0) return Tile.grass;
	if (tiles[x + y *width]==2) return Tile.sand;
	if (tiles[x + y *width]==3) return Tile.water;
	if (tiles[x + y *width]==1) return Tile.water;

	return Tile.voidtile;
	

}
public int[] gettile(){
	return this.tiles;
}
}
