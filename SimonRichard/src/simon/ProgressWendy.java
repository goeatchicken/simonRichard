package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPratice.components.Component;

public class ProgressWendy extends Component implements ProgressInterfaceRichard {
	
	private String round;
	private int size;
	private boolean gameOver;
	private int x;
	private int y;
	private int w;
	private int h;
	

	public ProgressWendy(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int x) {
		// TODO Auto-generated method stub
		round = "Round " + x;
		update();
	}

	@Override
	public void setSequenceSize(int x) {
		// TODO Auto-generated method stub
		size = x;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		if(gameOver)
		{
			g.setColor(Color.BLACK);
			g.drawString("Game Over", x +10, y+10);
		}
	}

}
