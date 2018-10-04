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

public class LoginPanel extends Panel implements ActionListener{

	TalkFrame talkFrame;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Label emailL, passwdL;
	TextField emailTF, passwdTF;
	Button loginB, registB;
	
	public LoginPanel() {
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		emailL = new Label("Email : ");
		passwdL = new Label("Passwd : ");
		emailTF = new TextField();
		passwdTF = new TextField();
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		
		setContents();
		setCenter();
	}
	
	public LoginPanel(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		emailL = new Label("Email : ");
		passwdL = new Label("Passwd : ");
		emailTF = new TextField();
		passwdTF = new TextField();
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		
		loginB.addActionListener(this);
		registB.addActionListener(this);
		setContents();
		setCenter();
	}
	
	public void setContents() {
		
		setLayout(gridBagLayout);
		add(new Label(" "), 		0, 0, 1, 1, 0, 0);
		add(emailL, 				1, 0, 1, 1, 0, 0);
		add(emailTF, 				2, 0, 1, 1, 1, 0);
		add(new Label(" "), 		3, 0, 1, 1, 0, 0);

		add(new Label(" "), 		0, 1, 1, 1, 0, 0);
		add(passwdL, 				1, 1, 1, 1, 0, 0);
		add(passwdTF, 				2, 1, 1, 1, 1, 0);
		add(new Label(" "), 		3, 1, 1, 1, 0, 0);

		Panel gridPanel = new Panel();
		gridPanel.add(loginB);
		gridPanel.add(registB);
		add(gridPanel, 1, 2, 2, 1, 0, 0);
		
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
	
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep(); // 삑소리
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - (int)getSize().getWidth()) / 2;
		int y = (dim.height - (int)getSize().getHeight()) / 2;
		
		setLocation(x, y);
	}
	
	public static void main(String[] args) {
//		TalkFrame frame = new TalkFrame("메인화면");
//		
//		LoginPanel loginPanel = new LoginPanel();
//		
//		frame.add(loginPanel);
//		frame.setSize(300, 500);
////		frame.pack();
//		frame.setCenter();
//		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button buttonSource = (Button)e.getSource();
		
		if(buttonSource == loginB) {
			System.out.println("----");
			talkFrame.changeCard("MAIN");
		}
		else talkFrame.changeCard("SUCC");
	}
}
