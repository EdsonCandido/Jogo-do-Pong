package PongV2;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{

	double y, yVel;
	final double GRAVITY = 0.94;
	boolean upAccel, downAccel;
	int player, x;
	
	public HumanPaddle(int player) {
		// TODO Auto-generated constructor stub
		this.upAccel = false; this.downAccel = false;
		y = 210; yVel = 0;
		if (player == 1) {
			x = 20;
		}else{
			x = 660;
		}
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
		
	}

	public void move() {
		// TODO Auto-generated method stub
		if(upAccel){
			yVel -= 2;
		}else if(downAccel){
			yVel +=2;
		}else if(!upAccel && ! downAccel){
			yVel *= GRAVITY;
		}
		if(yVel >= 5 ){
			yVel = 5;
		}else if(yVel <= -5){
			yVel = -5;
		}
		y += yVel;
		//definindo limite da superior
		if(y <0 ){
			y = 0;
		}
		// 420 px é o limite inferior;
		if( y > 420){
			y = 420;
		}
		
	}
	public void setUpAccel(boolean input){
		this.upAccel = input;
	}
	
	public void setDownAccel(boolean input){
		this.downAccel = input;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int)y;
	}

}
