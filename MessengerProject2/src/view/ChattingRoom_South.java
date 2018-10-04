package view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

public class ChattingRoom_South extends Panel {
	Label message1L, message2L, message3L;
	Button msgB, inviteB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public ChattingRoom_South() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		message1L = new Label("");
		message1L.setAlignment(Label.CENTER);
		message2L = new Label("");
		message2L.setAlignment(Label.CENTER);
		message3L = new Label("");
		message3L.setAlignment(Label.CENTER);
		msgB = new Button("전체메세지");
		inviteB = new Button("초대하기");
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(message1L,		1, 0, 1, 1, 1, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(msgB, 			5, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(inviteB, 		7, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 8, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(message2L,		1, 1, 1, 1, 1, 0, 0, 0, 0, 0);
		add(message3L,		1, 2, 1, 1, 1, 0, 0, 0, 0, 0);
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
	
	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("메인화면");
		
		WaitingRoom_South loginPanel = new WaitingRoom_South();
		
		frame.add(loginPanel);
//		frame.pack();
		frame.setSize(600, 800);
		frame.setCenter();
		frame.setVisible(true);
	}
}
