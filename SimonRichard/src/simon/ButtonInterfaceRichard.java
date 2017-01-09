package simon;

import java.awt.Color;

import guiPratice.components.Action;
import guiPratice.components.Clickable;

public interface ButtonInterfaceRichard extends Clickable {

	void setColor(Color color);

	void setX(int i);

	void setY(int i);

	void setAction(Action a);

	void hightlight();

	void dim();

	void highlight();
}
