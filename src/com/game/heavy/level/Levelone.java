package com.game.heavy.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.graphics.spritesheet;
import com.game.heavy.level.tile.Tile;

public class Levelone extends Level{

	private Tile[] tiles;
	private int[] levelPixels;
	
	public Levelone(String path){
		super(path);
		
	}
	protected void loadlevel(String path){
	}
}
	
