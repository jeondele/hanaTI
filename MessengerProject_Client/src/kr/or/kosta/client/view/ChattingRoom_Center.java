package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

/**
 * 채팅방에 입장했을 때 실질적인 채팅화면에 해당하는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class ChattingRoom_Center extends Panel {
	TextArea chatTA;
	TextField chatTF;
	Button sendB;
	Label chatL;
	Choice msgToC;
	
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
		msgToC = new Choice();
		msgToC.add("전체메세지");
		setContents();
	}
	
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(chatL, 		1, 0, 2, 1, 1, 0, 5, 0, 15, 0);
		
		Panel chatTAPanel = new Panel();
		chatTAPanel.setLayout(new BorderLayout());
		chatTAPanel.add(chatTA);
		chatTAPanel.setPreferredSize(new Dimension(WIDTH, 495));
		add(chatTAPanel, 		1, 1, 4, 1, 0, 0, -15, 0, 1, 0);
		add(new Label(""),  	1, 2, 1, 1, 0, 0, 0, 0, 0, 0);

		add(msgToC, 		1, 3, 1, 1, 0, 0, -1, 0, 0, 0);
		add(chatTF, 		2, 3, 2, 1, 1, 0, -7, 0, 0, 0);
		add(sendB, 			4, 3, 1, 1, 0, 0, -8, 5, 0, 0);
		add(new Label(""),  4, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		
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
