package simon;

public class MoveWendy implements MoveInterfaceRichard {
	
	private ButtonInterfaceRichard move;

	public MoveWendy(ButtonInterfaceRichard m) {
		// TODO Auto-generated constructor stub
		this.move = m;
	}

	@Override
	public ButtonInterfaceRichard getButton() {
		// TODO Auto-generated method stub
		return move;
	}

}
