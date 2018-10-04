package kr.or.kosta.chat.client;
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

import kr.or.kosta.chat.common.Protocol;

public class ChatFrame extends Frame {
	
	private ChatClient chatClient;
	private String nickName;
	
	Label nickNameL;
	TextField nickNameTF, inputTF;
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
		nickNameL = new Label("대화명");
		nickNameTF = new TextField();
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
	
	public ChatClient getChatClient() {
		return chatClient;
	}

	public void setChatClient(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	//화면 배치
	public void setContents() {
		connectB.setFont(new Font("궁서", Font.BOLD, 20));
		
		Panel northP = new Panel(); //패널은 디폴트가 플로우 , 이것보다는 보더로 지정해서 꽉차게 나타내는 것이 좋다.
		northP.setLayout(new BorderLayout()); // 플로우 레이아웃에서 보더 레이아웃으로 변경. 이렇게 되면 생성자에 써놓은 크기가 의미 없어진다.
		northP.add(nickNameL, BorderLayout.WEST);
		northP.add(nickNameTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP = new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userL, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
		
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
	}
	
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	//연결하는 기능
	public void connect() {
		nickName = nickNameTF.getText();
		System.out.println(nickName);
		try {
			chatClient.connectServer();
			// 최초 연결 메시지 전송
			chatClient.sendMessage(Protocol.CONNECT + Protocol.DELEMETER + nickName);
			//상태표시줄에 보여주는 것이 좋다.
			appendMessage("@@@@@@ ChatServer와 연결되었습니다 @@@@@@@@@@@@");
			
			String message = chatClient.readMessage();
			String[] tokens = message.split(Protocol.DELEMETER);
			if(tokens[1].equalsIgnoreCase("SUCCESS")) {
				chatClient.receiveMessage();
			} else {
				JOptionPane.showMessageDialog(null, "이미 사용 중인 대화명입니다.\n 다른 대화명을 사용하세요", "경고", JOptionPane.ERROR_MESSAGE);
				chatClient.stopClient();
				return;
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
			
		}
		
		nickNameTF.setEnabled(false);
		connectB.setEnabled(false);
		//연결되면  화면에서 비활성화 해줘야 한다. 또는 연결 버튼 이름을 종료 버튼으로 바꿔준다.
	}
	
	public void sendMessage() {
		String message = inputTF.getText(); //유효성 검증해야한다.
		if(message == null || message.trim().length() == 0) {
			return;
		}
		inputTF.setText("");
		System.out.println(message + " 메세지 전송");
		//메세지 전송되면 지워준다.
	}
	
	public void appendMessage(String message) {
		messageTA.append(message + "\n");
	}
	
	public void appendMessage() {
		String message = inputTF.getText();
		messageTA.append(message + "\n");
		inputTF.setText("");
	}
	
	//끊는 기능
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		
		nickNameTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		connectB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		/*이름없는 지격내부 클래스 */
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		//엔터치고 연결될 수 있게 하는 것도 해야한다.
		inputTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//서버에 메세지 보내는 걸로 바뀌어야 한다.
				sendMessage();
			}
		});
		
		// 엔터치고 연결될 수 있게 하는 것도 해야한다.
		sendB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 서버에 메세지 보내는 걸로 바뀌어야 한다.
				sendMessage();
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
				//요기도 구현해야하는 부분.
				finish();
			}
		});
		
	}
	
//	public static void main(String[] args) {
//		ChatFrame uf = new ChatFrame("KOTALK");
//		uf.setContents();
//		uf.setSize(600, 700); //pixel로만 가능
//		uf.setCenter();
//		uf.eventRegist();
//		uf.setVisible(true);
//	}

}

