package kr.or.kosta.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import kr.or.kosta.chat.common.Protocol;
import kr.or.kosta.chat.server.Client;

public class RoomFrame extends Frame {

	private ChatClient chatClient;
	private String nickName;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Label nickNameL, roomInfoL;
	TextField searchTF;
	Button ResetB, LogOutB, enterB, createB, roomInfoB;
	TextArea RoomInformTA;

	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;
	Choice choice;

	
	String roomHeader[] = {"방 번호", "제목", "인원", "입장가능여부"};
	String roomContents[][] = {{"1","1","1","1"}};
	JTable roomTable = new JTable(roomContents, roomHeader);
	JScrollPane roomSP;
	
	String UserListHeader[] = {" 닉네임", "아이디"};
	String UserListContents[][] = {{"1", "1"}};
	JTable userTable = new JTable(roomContents, roomHeader);
	JScrollPane userSP;
	DefaultTableCellRenderer celAlignCenter;
	DefaultTableCellRenderer celAlignLeft;

	JButton buttonT;
	 
	public RoomFrame() {
		this("이름없음");
	}

	public RoomFrame(String title) {
		super(title);
		nickNameL = new Label("대화명");
		enterB = new Button("채팅장 입장");
		createB = new Button("채팅장 생성");
		
		RoomInformTA = new TextArea();
		RoomInformTA.setEditable(false);
		RoomInformTA.setBackground(Color.WHITE);
		roomInfoB = new Button("대화방 정보");

		roomInfoB.setBackground(Color.LIGHT_GRAY);
		roomInfoB.setForeground(Color.BLACK);
		
		roomTable = new JTable(roomContents, roomHeader);
		roomSP = new JScrollPane(roomTable);
		
		userTable = new JTable(UserListContents, UserListHeader);
		userSP = new JScrollPane(userTable);

		
		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
		
		choice = new Choice();
		choice.add("제목");
		choice.add("방 번호");
		choice.add("입장가능한 방");
		searchTF = new TextField();
		
		gridBagConstraints = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		celAlignLeft = new DefaultTableCellRenderer();
		celAlignLeft.setHorizontalAlignment(JLabel.LEFT);
		
	}

	public ChatClient getChatClient() {
		return chatClient;
	}

	public void setChatClient(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	// 화면 배치
	public void setContents() {
		Panel northP = new Panel();
		northP.setPreferredSize(new Dimension(100, 100));;
		northP.setLayout(new GridBagLayout());
		northP.add(set(choice, 0, 0, 1, 2, 0, 0));
		northP.add(set(new Label("     "), 2, 0, 1, 1, 0, 0));
		northP.add(set(searchTF, 3, 0, 5, 2, 2, 0));
		northP.add(set(new Label("                          "), 
												8, 0, 3, 1, 0, 0));
		northP.add(set(new Label("                          "), 
												11, 0, 3, 1, 0, 0));
		northP.add(set(roomInfoB, 13, 0, 1, 2, 2, 0));


		Panel eastP = new Panel();
		eastP.setPreferredSize(new Dimension(200, 100));
		eastP.setLayout(new BorderLayout());
		eastP.add(userSP, BorderLayout.NORTH);
		eastP.add(new Label("  "), BorderLayout.EAST);
		eastP.add(RoomInformTA, BorderLayout.CENTER);
		
		Panel centerP = new Panel();
		centerP.setLayout(new BorderLayout());
		centerP.add(new Label("    "), BorderLayout.EAST);
		centerP.add(new Label("    "), BorderLayout.WEST);
		centerP.add(roomSP, BorderLayout.CENTER);
		
		Panel southP = new Panel();
		southP.setPreferredSize(new Dimension(100, 100));
		southP.setLayout(new GridBagLayout());
		southP.add(set(new Label("                                                                                                "),
				0, 0, 2, 1, 1, 0));
		southP.add(set(new Label("                                                                                                "),
				2, 0, 2, 1, 1, 0));
		southP.add(set(enterB, 4, 0, 1, 1, 0, 0));
		southP.add(set(new Label("   "), 5, 0, 1, 1, 0, 0));
		southP.add(set(createB, 6, 0, 1, 1, 0, 0));
		
		add(eastP, BorderLayout.EAST);
		add(northP, BorderLayout.NORTH);
		add(centerP, BorderLayout.CENTER);
		add(southP, BorderLayout.SOUTH);

		setLocation(100, 100);
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
	}

	private Component set(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		gridBagLayout.setConstraints(component, gridBagConstraints);
		return add(component);
	}
	
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}
	
	public void setComponentSize() {
		searchTF.setPreferredSize(new Dimension(300, 30));
		choice.setPreferredSize(new Dimension(150, 20));
		enterB.setPreferredSize(new Dimension(130, 50));
		createB.setPreferredSize(new Dimension(130, 50));
		roomInfoB.setPreferredSize(new Dimension(130, 50));
		userSP.setPreferredSize(new Dimension(300, 300));
		roomTable.setRowHeight(40);
		roomTable.setBackground(Color.white);
		roomTable.getColumn("방 번호").setPreferredWidth(5);
		roomTable.getColumn("방 번호").setCellRenderer(celAlignCenter);
		roomTable.getColumn("제목").setPreferredWidth(180);
		roomTable.getColumn("제목").setCellRenderer(celAlignLeft);
		roomTable.getColumn("인원").setPreferredWidth(5);
		roomTable.getColumn("인원").setCellRenderer(celAlignCenter);
		roomTable.getColumn("입장가능여부").setPreferredWidth(5);
		roomTable.getColumn("입장가능여부").setCellRenderer(celAlignCenter);
	}

	public void connect() {
		nickName = null;
		try {
			chatClient.connectServer();
			// 최초 연결 메시지 전송
			chatClient.sendMessage(Protocol.CONNECT + Protocol.DELEMETER + nickName);
//			appendMessage("@@@ ChatServer와 연결되었습니다 @@@@");
			chatClient.receiveMessage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void connectEnable(boolean flag) {
		enterB.setEnabled(flag);
	}

	public void sendMessage() {          
		String message = null;
		if (message == null || message.trim().length() == 0) {
			return;
		}
		chatClient.sendMessage(Protocol.MULTI_CHAT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + message);
	}

	public void sendExitSignal() {
		chatClient.sendMessage(Protocol.DISCONNECT + Protocol.DELEMETER + nickName + Protocol.DELEMETER);
		chatClient.stopClient();
	}

	public void appendMessage(String message) {
		RoomInformTA.append(message + "\n");
	}

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {

		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();

			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "주의", dialogButton, JOptionPane.WARNING_MESSAGE);
				if (dialogButton == JOptionPane.YES_OPTION) {
					sendExitSignal();
					finish();
				} else {

				}
			}
		});

		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		createB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});

	}
}
