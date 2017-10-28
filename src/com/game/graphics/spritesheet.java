package com.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class spritesheet {
private String path;
public final int SIZE;
public int[]pixels;

public static spritesheet tiles = new spritesheet("/textures/spritesheet.png",256);

public spritesheet(String path,int size){
	this.path=path;
	SIZE=size;
	pixels=new int[size*size];
	load();
}
private void load() {
	try {
		BufferedImage image = ImageIO.read(spritesheet.class.getResource(path));
		int w = image.getWidth();
		int h = image.getHeight();
		image.getRGB(0, 0, w, h, pixels, 0, w);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
