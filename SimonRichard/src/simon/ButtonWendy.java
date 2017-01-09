package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPratice.components.Action;
import guiPratice.components.Component;

public class ButtonWendy extends Component implements ButtonInterfaceRichard {
	
	private Action action;
	private Color col;
	boolean highlight;
	private static int w = 50;
	private static int h = 50;

	public ButtonWendy() {
		super(0, 0, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.col = color;
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
	
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		if(col != null)
		{
			highlight = true;
		}
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(col);
		g.drawOval(0, 0, w, h);
		if(highlight)
		{
			g.setColor(col);
			g.fillOval(0, 0, w, w);
		}
		
	}

}
