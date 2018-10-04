package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRoom extends Panel {
	Label roomNameL, memberLimitL;
	TextField roomNameTF, memberLimitTF;
	Button cancelB, createB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public CreateRoom() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		roomNameL = new Label("방 제목");
		memberLimitL = new Label("방 제한 인원 (최대 12명)");
		
		roomNameTF = new TextField();
		memberLimitTF = new TextField();
		
		createB = new Button("방 생성");
		cancelB = new Button(" 취소 ");
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(new Label(""),  0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(roomNameL, 		1, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(""),  2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(""), 	3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(""), 	4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(memberLimitL, 	5, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(""), 	6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(""), 	7, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(roomNameTF, 	1, 1, 3, 1, 1, 0, 0, 0, 0, 0);
		add(memberLimitTF, 	5, 1, 2, 1, 0, 0, 0, 0, 0, 0);
		
		add(new Label(""), 	0, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(createB, 		5, 3, 1, 1, 0, 0, 0, 0, 0, 0);
		add(cancelB, 		6, 3, 1, 1, 0, 0, 0, 30, 0, 0);
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
		
		CreateRoom loginPanel = new CreateRoom();
		
		frame.add(loginPanel);
		frame.setCenter();
		frame.setVisible(true);
	}
	
	public void eventRegist() {
		
	}
}
