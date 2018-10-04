package kr.or.kosta.client.view;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;

/**
 * 채팅방의 초대메세지 관련 기능을 들어있는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class ChattingRoom_South extends Panel {
	Label message1L, message2L, message3L;
	Button msgB, msgAllB, inviteB;
	
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
		msgB = new Button("귓속말모드");
		msgAllB = new Button("전체모드");
		inviteB = new Button("초대하기");
		setContents();
	}
	
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(message1L,		1, 0, 1, 1, 1, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(msgAllB, 		4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(msgB, 			5, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(inviteB, 		7, 0, 1, 1, 0, 0, 0, 0, 0, 20);
		add(new Label(" "), 8, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(message2L,		1, 1, 1, 1, 1, 0, 0, 0, 0, 0);
		add(message3L,		1, 2, 1, 1, 1, 0, 0, 0, 0, 0);
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
