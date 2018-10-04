package myselfKoTalk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends Panel implements ActionListener{
	
	TalkFrame talkFrame;
	
	Label tempL;
	Button logoutB;
	
	public MainPanel() {
		tempL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");
		setContents();
	}
	
	public MainPanel(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		tempL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");
		setContents();
		logoutB.addActionListener(this);
	}

	public void setContents() {
		setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(logoutB);
		
		add(tempL, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
//		TalkFrame frame = new TalkFrame("메인화면");
//		MainPanel mainPanel = new MainPanel();
//		
//		frame.add(mainPanel);
//		frame.setSize(300, 500);
////		frame.pack();
//		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 talkFrame.changeCard("LOGIN");
	}
}
