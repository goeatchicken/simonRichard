package simon;

import java.awt.Graphics2D;

import guiPratice.components.Component;

public class ProgressWendy extends Component implements ProgressInterfaceRichard {
	
	private int round;
	private int size;

	public ProgressWendy(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRound(int x) {
		// TODO Auto-generated method stub
			round = x;
	}

	@Override
	public void setSequenceSize(int x) {
		// TODO Auto-generated method stub
			size = x;
	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub

	}

}
