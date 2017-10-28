package com.game.graphics;

import java.util.Random;

import javax.swing.JFrame;

import com.game.heavy.level.tile.Tile;

public class Screen {
	public int width, height;
	public int[]pixels;
	public final int MAP_SIZE=64;
	public final int MAP_SIZE_MASK=MAP_SIZE-1;
	public int xoffset,yoffset;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	private JFrame frame;
	

	private Random random = new Random();
	public Screen(int width,int height){
		this.width = width;
		this.height= height;
		pixels = new int [width*height];
		
		for (int i =0; i<MAP_SIZE*MAP_SIZE;i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	public void clear(){
		for (int i =0;i<pixels.length;i++){
			pixels[i]=0;
		}
	}
	
	
	
	 public void rendertile(int xp,int yp, Sprite sprite){
	    	xp -= xoffset;
	    	yp -= yoffset;
	    	for (int y =0; y<sprite.SIZE; y++){
	    		int ya = y + yp;
	    		for (int x =0; x<sprite.SIZE; x++){
	        		int xa = x + xp;
	        		if(xa <-sprite.SIZE || xa>=width || ya<0 || ya >= height)break;
	        		if(xa<0) xa=0;
	        		int col = sprite.pixels[x+y*sprite.SIZE];
	        		if (col != 0xffff00ff){
	        			pixels[xa+ya*width] = sprite.pixels[x+y*sprite.SIZE];
	        		}
	    		}
	    	}
	    		
	    		
	   }
    public void rendertile(int xp,int yp, Tile tile){
    	xp -= xoffset;
    	yp -= yoffset;
    	for (int y =0; y<tile.sprite.SIZE; y++){
    		int ya = y + yp;
    		for (int x =0; x<tile.sprite.SIZE; x++){
        		int xa = x + xp;
        		if(xa <-tile.sprite.SIZE || xa>=width || ya<0 || ya >= height)break;
        		if(xa<0) xa=0;
        		int col = tile.sprite.pixels[x+y*tile.sprite.SIZE];
        		if (col != 0xffff00ff){
        			pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
        		}
    		}
    		
    		
    	}
    	
    }
    
    public void renderPlayer(int xp, int yp, Sprite sprite){
    	int size =sprite.SIZE;
    	xp -= xoffset;
    	yp -= yoffset;
    	for (int y =0; y<size; y++){
    		int ya = y + yp;
    		for (int x =0; x<size; x++){
        		int xa = x + xp;
        		if(xa <-size || xa>=width || ya<0 || ya >= height)break;
        		if(xa<0) xa=0;
        		int col = sprite.pixels[x+y*size];
        		if (col != 0xffff00ff){
        			pixels[xa+ya*width] = col;
        		}
        		
    		}
    		
    		
    	}
    	
    }
    
    public void setoffset(int xoffset,int yoffset){
    	this.xoffset=xoffset;
    	this.yoffset=yoffset;
    }
}
