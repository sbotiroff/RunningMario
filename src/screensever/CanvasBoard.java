package screensever;

/*
* @ This file draws a warrior 
* @ Author: Sardor Botirov
* @ Professor: Usman Rizvi
* @ Class: Java C SCI 143
* @ Date: 08/05/2019
* @ file CanvasBoard.java
*/

import java.awt.*;
import acm.program.*;
import acm.graphics.*;

// class fields
public class CanvasBoard extends GraphicsProgram {
	public static final Color VERY_LIGHT_BLUE = new Color(92, 148, 252);
	Font myFont = new Font("Helvetica", Font.PLAIN, 25);

	public void init() {
		setBackground(VERY_LIGHT_BLUE);
		setSize(800, 500);
	}

	public void run() {
//		Draw a coin
		GOval coin = new GOval(230, 12, 11, 18);
		add(coin);
		coin.setFilled(true);
		coin.setColor(new Color(252, 151, 57));

		// Line under labels
		GLine vLine = new GLine(0, 60, 800, 60);
		add(vLine);
		vLine.setColor(Color.WHITE);

		// Drawing a grass
		GArc mat = new GArc(140, 400, 120, 100, 0, 180);
		add(mat);
		mat.setFilled(true);
		mat.setColor(new Color(0, 168, 1));

		// Drawing a pipe
		GImage pipe = new GImage("pipe.png");
		add(pipe);
		pipe.setBounds(650, 360, 130, 130); // x, y, width, height

		// labels
		labels();

		// calling bricks;
		bricks();

		// Calling clouds and Mario for animate the clouds pass (true) else pass
		// (false);
		marioAndClouds(true);

	}

	// Labels
	public void labels() {
		GLabel marioLabel = new GLabel("Mario life : 3", 10, 30);
		add(marioLabel);
		marioLabel.setFont(myFont);
		marioLabel.setColor(Color.WHITE);

		GLabel coinsLabel = new GLabel(" x 00", 250, 30);
		add(coinsLabel);
		coinsLabel.setFont(myFont);
		coinsLabel.setColor(Color.WHITE);

		GLabel levelLabel = new GLabel("World : 1-1", 460, 30);
		add(levelLabel);
		levelLabel.setFont(myFont);
		levelLabel.setColor(Color.WHITE);

		GLabel timeLabel = new GLabel("Time : 390", 660, 30);
		add(timeLabel);
		timeLabel.setFont(myFont);
		timeLabel.setColor(Color.WHITE);
	}

	// Bricks
	public void bricks() {
		// Draw bricks
		for (int i = 0; i < 22; i++) {
			GImage brick = new GImage("brick.png");
			add(brick);
			brick.setBounds(0 + (i * 39), 450, 40, 50); // x, y, width, height
		}
	}

	// Clouds with animation
	public void marioAndClouds(boolean animate) {
		GImage cloud = new GImage("cloud.png");
		add(cloud);
		cloud.setBounds(200, 70, 80, 60); // x, y, width, height

		GImage bigCloud = new GImage("bigCloud.png");
		add(bigCloud);
		bigCloud.setBounds(600, 80, 120, 60); // x, y, width, height

		GImage mario = new GImage("walkingMario.gif");
		add(mario);
		mario.setBounds(110, 370, 100, 90);

		GImage jumpingMario = new GImage("jumpingMario.png");
		add(jumpingMario);
		jumpingMario.setBounds(-100, 375, 50, 80);

		
		while (animate) {
			bigCloud.move(-1, 0);
			cloud.move(1, 0);
			pause(15);
			//animate the mario
			if (mario.getX() > 78 && mario.getX() <= 550) {
				mario.move(1, 0);
			}

			if (mario.getX() == 550) {
				jumpingMario.setBounds(571, 375, 50, 80);
				mario.setBounds(-100, 370, 100, 90);
			}

			if (jumpingMario.getX() > 550 && jumpingMario.getX() < 680) {
				jumpingMario.move(2, -2);
			}

			if (jumpingMario.getX() > 680 && jumpingMario.getX() < 720) {
				jumpingMario.move(2, 0);
			}

			if (jumpingMario.getX() > 720 && jumpingMario.getX() < 850) {
				jumpingMario.move(2, 2);
			}

			if (jumpingMario.getX() > 850) {
				jumpingMario.setBounds(-18, 280, 50, 80);
			}

			if (jumpingMario.getX() > -19 && jumpingMario.getX() < 80) {
				jumpingMario.move(2, 2);
			}

			if (jumpingMario.getX() == 80 && mario.getX() == -100) {
				mario.setBounds(80, 370, 100, 90);
				jumpingMario.setBounds(-100, 375, 50, 80);
			}
			
			// Animate the cloud
			if (cloud.getX() < 400) {
				cloud.move(0, 0.1);
			} else {
				cloud.move(0, -0.1);
			}

			if (cloud.getX() > 800) {
				cloud.setLocation(-cloud.getWidth(), cloud.getY());
			}

			if (bigCloud.getX() < -200) {
				bigCloud.setLocation(800, bigCloud.getY());
			}

		}
	}

}
