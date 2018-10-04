package kr.or.kosta.client.view;

import java.awt.Button;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * 메인 어플리케이션 실행 시 로그인을 하는 패널 클래스
 * @author 전상일
 *
 */
public class LoginRoom extends Panel {
	
	TalkFrame talkFrame;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Label brandL, titleL, subTitleL, nickNameL, nickNameExceptionL;
	TextField nickNameTF;
	Button enterB;
	
	public LoginRoom(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		titleL = new Label("HTS");
		titleL.setAlignment(Label.CENTER);
		titleL.setFont(new Font("Serif", Font.BOLD, 40));
		
		subTitleL = new Label("(HanaTalkSystem)");
		subTitleL.setAlignment(Label.CENTER);
		subTitleL.setFont(new Font("Serif", Font.BOLD, 20));
		
		nickNameL = new Label("NickName : ");
		nickNameExceptionL = new Label("");
		
		nickNameTF = new TextField();
		enterB = new Button("Let's TALK");
		
		setContents();
		eventRegist();
	}
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		
		setLayout(gridBagLayout);
		
		add(new Label(" "),   	0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	1, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	2, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	3, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	4, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	5, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	6, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	7, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(titleL, 			2, 1, 4, 2, 0, 0, 0, 0, 0, 0);	
		
		add(subTitleL,   		2, 3, 4, 2, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 5, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(nickNameL,			2, 6, 1, 1, 0, 0, 0, 0, 0, 0);
		add(nickNameTF,			3, 6, 3, 1, 0, 0, 0, 0, 0, 0);

		add(nickNameExceptionL,	2, 7, 4, 1, 0, 0, 0, 0, 0, 0);
		
		Panel gridPanel = new Panel();
		gridPanel.add(enterB);
		add(gridPanel, 			2, 8, 4, 2, 0, 0, 0, 0, 0, 0);
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
	
	//로그인 수행시 유효성 검증
	public void eventRegist() {
		
		//닉네임 입력후 검증
		nickNameTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.setBlock(false);
				talkFrame.connect();
				if(nickNameTF.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "다른 닉네임을 입력하세요", "채팅방 입장 불가", JOptionPane.ERROR_MESSAGE);
					return;
				}
				nickNameTF.setText(" ");
				nickNameTF.setText("");
			}
		});
		//닉네임 입력후 검증
		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.setBlock(false);
				talkFrame.connect();
				if(nickNameTF.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "다른 닉네임을 입력하세요", "채팅방 입장 불가", JOptionPane.ERROR_MESSAGE);
					return;
				}
				nickNameTF.setText(" ");
				nickNameTF.setText("");
			}
		});
	}
}
