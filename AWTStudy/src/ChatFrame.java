import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChatFrame extends Frame {
	
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userL;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;

	public ChatFrame(){
		this("AWTChat");
	}
	
	public ChatFrame(String title){
		super(title);
		serverL = new Label("SERVER");
		serverTF = new TextField();
		inputTF = new TextField();
		//이름없는 지역내부 클래스
		connectB = new Button("CONNECT!") {
			@Override
			public void paint(Graphics g) {
				
				super.paint(g);
			}
		};
		sendB = new Button("SEND");
		messageTA = new TextArea();
		userL = new List();
		userL.add("날라리");
		userL.add("꼴뚜기");
		userL.add("머저리");
		
		menuBar = new MenuBar();
		menu	= new Menu("FILE");
		newMI	= new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N, true));
		exitMI  = new MenuItem("EXIT");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X, true));
	}
	
	//화면 배치
	public void setContents() {
//		connectB.setEnabled(false);//버튼 비활성화 할때 사용
//		connectB.setBackground(new Color(100, 50, 122));
//		connectB.setBackground(Color.BLUE);
//		connectB.setBackground(Color.WHITE);
		
		connectB.setFont(new Font("궁서", Font.BOLD, 20));
		
		Panel northP = new Panel(); //패널은 디폴트가 플로우 , 이것보다는 보더로 지정해서 꽉차게 나타내는 것이 좋다.
		northP.setLayout(new BorderLayout()); // 플로우 레이아웃에서 보더 레이아웃으로 변경. 이렇게 되면 생성자에 써놓은 크기가 의미 없어진다.
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP = new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userL, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
		
		//setLocation(100, 100);
		
//		setColorAll(Color.BLUE);
		
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
	}
	
	private void setCenter() {
//		Runtime.getRuntime().exec(command); //팩토리 메소드
//		Toolkit.getDefaultToolkit().beep(); //삑삑소리
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
				for (Component component2 : cs) {
					component2.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void appendMessage() {
		String message = inputTF.getText();
		messageTA.append(message + "\n");
		inputTF.setText("");
	}
	
	public void eventRegist() {
		/* 이름있는 지역 내부 클래스 */
		/*
		class Exiter extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		}
		*/
	
		/*이름없는 지격내부 클래스 */
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		inputTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendMessage();
			}
		});
		
		serverTF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyChar());
				System.out.println(KeyEvent.VK_ENTER);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		inputTF.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				System.out.println(inputTF.getText());
			}
		});
		
		userL.addItemListener(new ItemListener() {
			
			@Override
			//내부 메소드의 this는 자기 자신의 메소드 not class
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String name = userL.getSelectedItem();
					JOptionPane.showMessageDialog(null, name +"님 선택이요..", "알림", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, name +"님 선택이요..", "알림", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		
	}
	
	public static void main(String[] args) {
		ChatFrame uf = new ChatFrame("KOTALK");
		uf.setContents();
		uf.setSize(600, 700); //pixel로만 가능
		uf.setCenter();
		uf.eventRegist();
		uf.setVisible(true);
	}
	
	/**  멤버 내부 클래스를 이용한 이벤트 처리 */
//	class Exiter extends WindowAdapter {
//		@Override
//		public void windowClosing(WindowEvent e) {
//			finish();
//		}
//	}
}

