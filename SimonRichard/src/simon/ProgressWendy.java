package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPratice.components.Component;

public class ProgressWendy extends Component implements ProgressInterfaceRichard {
	
	private int roundNum;
	private int sizeNum;
	private boolean gameOver;
	
	

	public ProgressWendy() {
		super(100, 30, 150, 70);
		// TODO Auto-generated constructor stub

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
		roundNum = x;
		update();
	}

	@Override
	public void setSequenceSize(int x) {
		// TODO Auto-generated method stub
		sizeNum = x;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		if(gameOver)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, 300, 50);
			g.setColor(Color.white);
			g.drawString("Game Over", 10, 20);
			g.drawString("Round " + roundNum, 10, 30);
			g.drawString("Size " + sizeNum, 10, 40);
		}
		else
		{
			g.setColor(Color.green);
			g.fillRect(0, 0, 300, 50);
			g.setColor(Color.black);
			g.drawString("Round " + roundNum, 10, 30);
			g.drawString("Size " + sizeNum, 10, 40);
		}
		
	}

}
