package view;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingRoom_North extends Panel {

	TextField searchRoomTF;
	Button searchRoomB, exitB;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	public WaitingRoom_North() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		searchRoomTF = new TextField();
		searchRoomB = new Button("방 이름 검색");
		exitB = new Button("접속 종료");
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

		add(searchRoomTF, 1, 1, 1, 1, 1, 0, 0, 20, 0, 0);
		add(searchRoomB, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(exitB, 13, 1, 1, 1, 0, 0, 0, 0, 0, 20);
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

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("메인화면");

		WaitingRoom_North loginPanel = new WaitingRoom_North();

		frame.add(loginPanel);
		// frame.pack();
		frame.setSize(600, 800);
		frame.setCenter();
		frame.setVisible(true);
	}

}
