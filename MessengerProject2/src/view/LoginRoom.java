package view;

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
		
		//상표명 붙이기
//		brandL = new Label("HTS");
//		brandL.setLocation(talkFrame.getSize().width, talkFrame.getSize().height);;
		
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
	
	public void eventRegist() {
		
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
