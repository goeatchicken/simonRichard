package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import guiPratice.components.Action;
import guiPratice.components.Component;

public class ButtonWendy extends Component implements ButtonInterfaceRichard {
	
	private Action action;
	private Color col;
	boolean highlight;
	private Color displayColor;
	private static int w = 50;
	private static int h = 50;

	public ButtonWendy() {
		super(0, 0, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x >= getX() && x <= getX() + getWidth() && y >= getY() && y <= getY() + getHeight();
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.col = color;
		displayColor = col;
		update();
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		this.action = a;
		update();
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		displayColor = Color.gray;
		highlight = false;
		update();
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		if(col != null) 
		{
			displayColor = col;
		}
		highlight = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.drawOval(0, 0, w, h);
		if(displayColor != null)
		{
			g.setColor(displayColor);
		}
		else 
		{
			g.setColor(Color.gray);
		}
		if(highlight)
		{
			g.setColor(col);
			g.fillOval(0, 0, w, w);
			g.setColor(Color.white);
		}
		else
		{
			g.setColor(Color.gray);
			g.fillOval(0, 0, w, w);
		}
		
	}

}
