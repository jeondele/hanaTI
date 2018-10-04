package myselfKoTalk;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TalkFrame extends Frame implements WindowListener{

	MainPanel mainPanel;
	LoginPanel loginPanel;
	RegisterPanel registerPanel;
	
	Panel cardPanel;
	CardLayout cardLayout;
	
	public TalkFrame() {
		this("이름 없음");
		
	}

	public TalkFrame(String title) {
		super(title);
		mainPanel = new MainPanel(this);
		loginPanel = new LoginPanel(this);
		registerPanel = new RegisterPanel(this);
		
		cardPanel = new Panel();
		cardLayout = new CardLayout();
	}

	/**
	 * 	카드레이아웃 세팅
	 */
	public void setContents() {
		cardPanel.setLayout(cardLayout);
		cardPanel.add("LOGIN", loginPanel);
		cardPanel.add("MAIN", mainPanel);
		cardPanel.add("SUCC", registerPanel);
		
		add(cardPanel, BorderLayout.CENTER);
		eventRegist();
	}
	
	private void eventRegist() {
		addWindowListener(this);
	}

	public void setCenter() {
		Toolkit.getDefaultToolkit().beep(); // 삑소리
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - (int)getSize().getWidth()) / 2;
		int y = (dim.height - (int)getSize().getHeight()) / 2;
		
		setLocation(x, y);
	}
	
	public void changeCard(String name) {
		cardLayout.show(cardPanel, name);
	}
	
	public static void main(String[] args) {
		TalkFrame talkFrame = new TalkFrame("KOTALK");
		talkFrame.setContents();
		talkFrame.setSize(300, 500);
		talkFrame.setCenter();
		talkFrame.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		finish();
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
