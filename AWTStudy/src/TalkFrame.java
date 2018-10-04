import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * CardLayout 적용 Frame
 * @author 김기정
 *
 */
public class TalkFrame extends Frame implements WindowListener {
	
	LoginPanel loginPanel;
	MainPanel mainPanel;
	
	Panel cardPanel;
	CardLayout cardLayout;
	
	public TalkFrame() {
		this("이름없음");
	}
	
	public TalkFrame(String title) {
		super(title);
		loginPanel = new LoginPanel(this);
		mainPanel = new MainPanel(this);
		
		cardPanel = new Panel();
		cardLayout = new CardLayout();
		
	}
	
	// 화면 배치
	public void setContents() {
		cardPanel.setLayout(cardLayout);
		cardPanel.add("LOGIN", loginPanel);
		cardPanel.add("MAIN", mainPanel);
		
		add(cardPanel, BorderLayout.CENTER);
		eventRegist();
		
//		cardLayout.show(cardPanel, "MAIN");
		
	}
	
	public void setCenter() {
		//Runtime.getRuntime().exec(command);
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if(component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}
	
	public void changeCard(String name) {
		cardLayout.show(cardPanel, name);
	}
	
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		addWindowListener(this);
	}
	
	public void logout (String name) {
		cardLayout.show(cardPanel, name);
	}
	
	
	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("Kotalk");
		frame.setContents();
		frame.setSize(300, 500);
		frame.setCenter();
		frame.setVisible(true);
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
		System.out.println("window closed!!!!!!!!!!!!");
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
