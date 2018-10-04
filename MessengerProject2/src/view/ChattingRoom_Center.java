package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ChattingRoom_Center extends Panel {
	TextArea chatTA;
	TextField chatTF;
	Button sendB;
	Label chatL, msgToL;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	BorderLayout borderLayout;
	
	public ChattingRoom_Center() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		borderLayout = new BorderLayout(20, 20);
		
		chatTA = new TextArea();
		chatTF = new TextField();
		sendB = new Button("보내기");
		chatL = new Label("채팅창");
		msgToL  = new Label("전체 메세지");
		
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(chatL, 		1, 0, 2, 1, 1, 0, 5, 0, 15, 0);
		
		Panel chatTAPanel = new Panel();
		chatTAPanel.setLayout(new BorderLayout());
		chatTAPanel.add(chatTA);
		chatTAPanel.setPreferredSize(new Dimension(WIDTH, 495));
		add(chatTAPanel, 		1, 1, 4, 1, 0, 0, -15, 0, 1, 0);
		add(new Label(""),  	1, 2, 1, 1, 0, 0, 0, 0, 0, 0);

		add(msgToL, 		1, 3, 1, 1, 0, 0, -1, 0, 0, 0);
		add(chatTF, 		2, 3, 2, 1, 1, 0, -7, 0, 0, 0);
		add(sendB, 			4, 3, 1, 1, 0, 0, -8, 5, 0, 0);
		add(new Label(""),  4, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		
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
		frame.setSize(600, 800);
		
		ChattingRoom_Center loginPanel = new ChattingRoom_Center();
		
		frame.add(loginPanel);
		frame.setCenter();
		frame.setVisible(true);
	}
}
