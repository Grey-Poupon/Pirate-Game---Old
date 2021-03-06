package com.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.graphics.Screen;
import com.game.heavy.entity.mob.Player;
import com.game.heavy.level.Level;
import com.game.heavy.level.Randomlevel;
import com.game.input.Keyboard;

public class Heavy extends Canvas implements Runnable {
private static final long serialVersionUID = 1L;
public static int width = 300;
public static int height = width/16 * 9;
public static int scale = 3;

private Player player;
private Thread thread;
private JFrame frame;
private Keyboard key;
private boolean running = false;
private Level level;

private Screen screen;

private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

public Heavy() {
	Dimension size = new Dimension(scale*width,scale*height);
	setPreferredSize(size);
	screen = new Screen(width,height);
	frame = new JFrame();
	key = new Keyboard();
	level = new Randomlevel(64, 64);
	player = new Player(key);
	player.init(level);
	addKeyListener(key);
	
}
public synchronized void start(){
	running = true;
	thread = new Thread(this,"Display");
	thread.start();
}
public synchronized void stop(){
	running = false;
	try{
		thread.join();
	} catch (InterruptedException e){
		e.printStackTrace();
	}
}
public void run(){
	long lastTime = System.nanoTime();
	long timer = System.currentTimeMillis();
	final double ns = 1000000000.0 / 60.0;
	double delta = 0;
	int updates = 0;
	int frames = 0;
	requestFocus();
	while(running){
		long  now = System.nanoTime();
		delta += (now-lastTime)/ns;
		lastTime=now;
		while(delta>=1){
			update();
			updates++;
			delta--;
		}
		render();
		frames++;
		if(System.currentTimeMillis() - timer>1000){
			timer+= 1000;
			frame.setTitle("Heavy"+"   "+updates + "ups" + frames + " fps");
			updates=0;
			frames=0;
		
		}
	}
	stop();
}
public void render(){
	BufferStrategy bs = getBufferStrategy();
	if (bs==null){
		createBufferStrategy(3);
		return;
	}
	screen.clear();
	int xScroll = player.x - screen.width / 2;
	int yScroll = player.y - screen.height / 2;
	level.render(xScroll, yScroll, screen);
	player.render(screen);
	
	for (int i =0;i<pixels.length;i++){
		pixels[i] = screen.pixels[i];
	}
	Graphics g = bs.getDrawGraphics();
	g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
	g.setColor(Color.WHITE);
	g.setFont(new Font ("Verdana",0,20));
	g.drawString("X: "+ player.x + "  Y: " + player.y,0,20);
	g.dispose();
	bs.show();
	}
public void update(){
	key.update();
	player.update();
	level.update();

}


public static void main(String[] args){
	Heavy game =new Heavy();
	game.frame.setResizable(false);
	game.frame.setTitle("Heavy");
	game.frame.add(game);
	game.frame.pack();
	game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.frame.setLocationRelativeTo(null);
	game.frame.setVisible(true);
	
	game.start();
	
}
}
