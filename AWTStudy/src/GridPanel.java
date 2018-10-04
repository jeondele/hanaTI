import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class GridPanel extends Panel {

	Button[] buttons;
	
	public GridPanel() {
		buttons = new Button[100];
		setLayout(new GridLayout(10, 10));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button((i+1)+" button");
			add(buttons[i]);
		}
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("GRID LAYOUT");
		GridPanel gridPanel = new GridPanel();
		frame.add(gridPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
