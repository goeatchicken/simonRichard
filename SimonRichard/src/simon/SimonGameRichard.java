package simon;

import guiPratice.GUIApplication;


public class SimonGameRichard extends GUIApplication{

	public SimonGameRichard(){
		
	}
	
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenRichard ssr = new SimonScreenRichard(getWidth(), getHeight());
		setScreen(ssr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimonGameRichard game = new SimonGameRichard();
		Thread app = new Thread(game);
		app.start();
	}
}
