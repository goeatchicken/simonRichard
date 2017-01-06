package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPratice.components.Button;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.sampleGames.ClickableScreen;
import whackAMole.MoleInterface;
import whackAMole.PlayerInterface;

public class SimonScreenRichard extends ClickableScreen implements Runnable{

	private ArrayList<MoveInterfaceRichard>move;
	private ButtonInterfaceRichard[] button;
	private ProgressInterfaceRichard progress;
	private TextLabel label;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenRichard(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> visibles) {
		// TODO Auto-generated method stub
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceRichard>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
		
	}

	private MoveInterfaceRichard randomMove() {
		// TODO Auto-generated method stub
		ButtonInterfaceRichard b;
		//code that randomly selects a ButtonInterfaceX
		return getMove(b);//partner codes this part
	}

	private ProgressInterfaceRichard getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		 */
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 6;
		//make new buttons
		button = new ButtonInterfaceRichard[numberOfButtons];
		Color[] color = {Color.blue, Color.green, Color.yellow, Color.black, Color.red, Color.cyan};
		for(int i = 0; i < numberOfButtons; i++){
			button[i] = getAButton();
			button[i].setColor(color[i]);
			button[i].setY(250);
			button[i].setY(500);
		}
	}

}
