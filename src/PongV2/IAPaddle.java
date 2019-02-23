package PongV2;

import java.awt.Color;
import java.awt.Graphics;

public class IAPaddle implements Paddle{

	double y, yVel;
	final double GRAVITY = 0.94;
	boolean upAccel, downAccel;
	int player, x;
	Ball b1;
	
	public IAPaddle(int player, Ball b) {
		// TODO Auto-generated constructor stub
		this.upAccel = false; this.downAccel = false;
		this.b1 = b;
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
		y = b1.getY() -40;
		
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
