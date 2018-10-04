package view;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingRoom_South extends Panel {
	Label message1L, message2L, message3L;
	Button enterRoomB, createRoomB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public WaitingRoom_South() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		message1L = new Label("");
		message1L.setAlignment(Label.CENTER);
		message2L = new Label("");
		message2L.setAlignment(Label.CENTER);
		message3L = new Label("");
		message3L.setAlignment(Label.CENTER);
		
		enterRoomB = new Button("방 들어가기");
		createRoomB = new Button("방 만들기");
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(message1L,		1, 0, 1, 1, 1, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(enterRoomB, 	5, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(createRoomB, 	7, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 8, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(message2L,		1, 1, 1, 1, 1, 0, 0, 0, 0, 0);
		add(message3L,		1, 2, 1, 1, 1, 0, 0, 0, 0, 0);
		
		eventRegist();
	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty, int insetsT, int insetsL, int insetsB, int insetsR) {

		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		
		gridBagConstraints.insets = new Insets(insetsT, insetsL, insetsB, insetsR);

		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("메인화면");
		
		WaitingRoom_South loginPanel = new WaitingRoom_South();
		
		frame.add(loginPanel);
//		frame.pack();
		frame.setSize(600, 800);
		frame.setCenter();
		frame.setVisible(true);
	}
	
	private void eventRegist() {
		
	}
}
