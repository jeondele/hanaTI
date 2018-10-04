package myselfKoTalk;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends Panel implements ActionListener{
	TalkFrame talkFrame;
	
	Label idL, pwdL;
	TextField idTF, pwdTF;
	Button successB;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public RegisterPanel() {
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		idL = new Label("새로운 아이디 : ");
		pwdL = new Label("새로운 비밀번호 : ");
		idTF = new TextField();
		pwdTF = new TextField();
		successB = new Button("성공!");
		setContents();
	}
	
	public RegisterPanel(TalkFrame talkFrame) {
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		this.talkFrame = talkFrame;
		idL = new Label("새로운 아이디 : ", Label.CENTER);
		pwdL = new Label("새로운 비밀번호 : ", Label.CENTER);
		idTF = new TextField();
		pwdTF = new TextField();
		successB = new Button("성공!");
		successB.addActionListener(this);
		setContents();
		setCenter();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(new Label(" "), 		0, 0, 1, 1, 0, 0);
		add(idL, 					1, 0, 1, 1, 0, 0);
		add(idTF, 					2, 0, 1, 1, 1, 0);
		add(new Label(" "), 		3, 0, 1, 1, 0, 0);
		
		add(new Label(" "), 		0, 1, 1, 1, 0, 0);
		add(pwdL, 					1, 1, 1, 1, 0, 0);
		add(pwdTF, 					2, 1, 1, 1, 1, 0);
		add(new Label(" "), 		3, 1, 1, 1, 0, 0);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(successB);
		add(buttonPanel, 			2, 2, 1, 1, 0, 0);
		
	}
	
	public void add(Component component, int x, int y, int width, int height, double weightX, double weightY ) {
		
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.gridwidth = width;
		gridBagConstraints.gridheight = height;
		gridBagConstraints.weightx = weightX;
		gridBagConstraints.weighty = weightY;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}

	private void setCenter() {
		Toolkit.getDefaultToolkit().beep(); // 삑소리
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - (int)getSize().getWidth()) / 2;
		int y = (dim.height - (int)getSize().getHeight()) / 2;
		
		setLocation(x, y);
	}
	
	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("메인화면");
		RegisterPanel rp = new RegisterPanel();
		frame.add(rp);
		frame.setSize(300, 500);
//		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		talkFrame.changeCard("LOGIN");
	}

}
