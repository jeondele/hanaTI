package view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

public class ChattingRoom_North extends Panel {
	Label roomTitleL;
	Button exitChatB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public ChattingRoom_North() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		roomTitleL = new Label("방 제목이 들어갈 곳");
		//방 제목 폰트 설정
		exitChatB = new Button("채팅방 나가기");
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);

		add(new Label(" "), 0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 7, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 8, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 9, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 10, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 11, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 12, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 13, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 14, 0, 1, 1, 0, 0, 0, 0, 0, 0);

		add(roomTitleL, 1, 1, 1, 1, 1, 0, 0, 20, 0, 0);
		add(new Label(" "), 3, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(exitChatB, 13, 1, 1, 1, 0, 0, 0, 0, 0, 20);
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

		ChattingRoom_North loginPanel = new ChattingRoom_North();

		frame.add(loginPanel);
		// frame.pack();
		frame.setSize(600, 800);
		frame.setCenter();
		frame.setVisible(true);
	}
}
