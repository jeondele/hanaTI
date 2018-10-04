package kr.or.kosta.client.view;

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

/**
 * 대기실의 방 검색과 접속종료를 나타내는 패널 클래스
 * 
 * @author 전상일
 *
 */
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

	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
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
	
	// 패널에 더해줄 컴포넌트들의 요소들을 세팅하는 메소드
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
}
