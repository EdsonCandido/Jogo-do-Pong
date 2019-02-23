package PongV2;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	//definindo o tamanho da janela
	final int WIDTH = 700, HEIGHT = 500;
	//Criando uma Thread para não ficar travando
	Thread thread;
	//Criando Jogadores
	HumanPaddle p1;
	//Criando IA para ele não deixar a bola escapar para o outro lado
	IAPaddle p2;
	//Criando a Bola
	Ball b1;
	boolean comecarJogo;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		comecarJogo = false;
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new IAPaddle(2, b1);
		thread = new Thread(this);
		thread.start();

	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX() < -10 || b1.getX() > 710){
			g.setColor(Color.red);
			g.drawString("Perdeu ", 350, 250);
		}else{
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
		}
		if(!comecarJogo){
			g.setColor(Color.white);
			g.drawString("TENNIS", 320, 100);
			g.drawString("Presione ENTER para começar", 260, 130);
		}
		
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		// TODO Auto-generated method stub
		for (;;) {
			if(comecarJogo){
				p1.move();
				p2.move();
				b1.move();
				b1.checkPaddleCollision(p1, p2);
			}
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//quando apertar a tecla para ele ir para cima
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			comecarJogo = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
