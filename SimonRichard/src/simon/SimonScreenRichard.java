package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPratice.sampleGames.ClickableScreen;
import guiPratice.components.Button;
import guiPratice.components.TextLabel;
import guiPratice.components.Visible;
import guiPratice.components.Action;

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
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		move.add(randomMove());
		progress.setSequenceSize(move.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		ButtonInterfaceRichard b = null;
		for(MoveInterfaceRichard m: move){
			if(b!=null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			int sleepTime = (int) (1000 * (Math.pow(2, 1/roundNumber)));
			try{
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String text) {
		// TODO Auto-generated method stub
		try{
			label.setText(text);
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
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
		int rand = (int) (Math.random() * button.length);
		while(rand == lastSelectedButton)
		{
			rand = (int) (Math.random() * button.length);
		}
		b = button[rand];
		lastSelectedButton = rand;
		return getMove(b);//partner codes this part
	}

	private MoveInterfaceRichard getMove(ButtonInterfaceRichard b) {
		// TODO Auto-generated method stub
		return new MoveWendy(b);
	}

	private ProgressInterfaceRichard getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		 */
		return new ProgressWendy();
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
			button[i].setX(120 + 55*i);
			button[i].setY(150);
			
			final ButtonInterfaceRichard b = button[i];
			b.setAction(new Action(){
				public void act(){
					if(acceptingInput){
						//when button is pressed
						Thread blink = new Thread(new Runnable(){
							//light da button
							public void run(){
								b.highlight();
								try{
									Thread.sleep(800);
								}
								catch(InterruptedException e){
									e.printStackTrace();
								}
								//dim is turning off the light
								b.dim();
							}
							
						});
						blink.start();
						
						if (b == move.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}else{
							gameOver();
							changeText("You went up to round " + roundNumber);
							acceptingInput = false;
							return;
						}
						if(sequenceIndex == move.size()){
							Thread nextRound = new Thread(SimonScreenRichard.this);
							nextRound.start();
						}
					}
				}

			});
			viewObjects.add(button[i]);
		}
	}
	private ButtonInterfaceRichard getAButton() {
		return new ButtonWendy();
	}

	private void gameOver() {
		// TODO Auto-generated method stub
		progress.gameOver();
	}

}
