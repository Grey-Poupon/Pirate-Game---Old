package com.game.graphics;

public class Sprite {
	
	public int SIZE;
	private int x,y;
	public int[] pixels = new int[256*256];
	private spritesheet sheet;
	
	public static Sprite grass        = new Sprite(16,0,0, spritesheet.tiles);
	public static Sprite voidsprite   = new Sprite(16,0x0BD8DB);
	public static Sprite mud          = new Sprite(16,0,2, spritesheet.tiles);
	public static Sprite sand         = new Sprite(16,0,1, spritesheet.tiles);
	public static Sprite water        = new Sprite(16,1,2, spritesheet.tiles);
	public static Sprite cannonBall   = new Sprite(16,1,1, spritesheet.tiles);

	
	public static Sprite playerup     = new Sprite(16,0,5, spritesheet.tiles);
	public static Sprite playerright  = new Sprite(16,2,5, spritesheet.tiles);
	public static Sprite playerdown   = new Sprite(16,1,5, spritesheet.tiles);
	public static Sprite playerleft   = new Sprite(16,3,5, spritesheet.tiles);
	
	public static Sprite playerup1    = new Sprite(16,0,6, spritesheet.tiles);
	public static Sprite playerright1 = new Sprite(16,2,6, spritesheet.tiles);
	public static Sprite playerdown1  = new Sprite(16,1,6, spritesheet.tiles);
	public static Sprite playerleft1  = new Sprite(16,3,6, spritesheet.tiles);
	public static Sprite playerup2    = new Sprite(16,0,7, spritesheet.tiles);
	public static Sprite playerright2 = new Sprite(16,2,7, spritesheet.tiles);
	public static Sprite playerdown2  = new Sprite(16,1,7, spritesheet.tiles);
	public static Sprite playerleft2  = new Sprite(16,3,7, spritesheet.tiles);
	
	
	
	
	
	
	
	public static Sprite player32 = new Sprite(32,0,2, spritesheet.tiles);
	
	
	public Sprite(int size, int x, int y,spritesheet sheet){
		SIZE=size;
		this.x=x * size;
		this.y=y*size;
		this.sheet=sheet;
		load();
	}
	public Sprite(int size , int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	private void setColour(int colour){
		for (int i = 0;i<SIZE*SIZE;i++){
			pixels[i]= colour;
		}
	}
	private void load(){
		for (int y=0;y<SIZE;y++){
			for (int x=0;x<SIZE;x++){				
				pixels[x+y*SIZE]=sheet.pixels[(x+this.x)+((y+this.y)*sheet.SIZE)];
				
			}
		}
	}

}
