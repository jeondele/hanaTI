package kr.or.kosta.client.view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

/**
 * 채팅방의 제목과 나가기 뷰를 담고있는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class ChattingRoom_North extends Panel {
	Label roomTitleL;
	Button exitChatB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public ChattingRoom_North() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		roomTitleL = new Label("방 제목이 들어갈 곳");
		exitChatB = new Button("채팅방 나가기");
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

		add(roomTitleL, 1, 1, 1, 1, 1, 0, 0, 20, 0, 0);
		add(new Label(" "), 3, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		add(exitChatB, 13, 1, 1, 1, 0, 0, 0, 0, 0, 20);
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
