package simon;

import java.awt.Color;

import guiPratice.components.Action;
import guiPratice.components.Clickable;

public interface ButtonInterfaceRichard extends Clickable {

	void setColor(Color color);

	void setAction(Action a);


	void dim();

	void highlight();

	void setX(int i);

	void setY(int i);
}
