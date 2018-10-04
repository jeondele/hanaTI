package kr.or.kosta.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import kr.or.kosta.chat.common.Protocol;
import kr.or.kosta.chat.server.Client;

public class ChatFrame extends Frame {

	private ChatClient chatClient;
	private String nickName;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	JLabel userInfoL, roomInfoL;
	EtchedBorder eBorder;
	JTextArea chatTA;
	JScrollPane chatSP;

	TextField InputMsgTF;

	Button SendB, ExitB, changeB;
	List UserList;

	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;

	public ChatFrame() {
		this("이름없음");
	}

	public ChatFrame(String title) {
		super(title);

		gridBagConstraints = new GridBagConstraints();
		gridBagLayout = new GridBagLayout();

		changeB = new Button("채팅장 변경");
		ExitB = new Button("채팅장 나가기");
		SendB = new Button("보내기");

		eBorder = new EtchedBorder(EtchedBorder.RAISED);
		roomInfoL = new JLabel("채팅장 이름");
		roomInfoL.setBorder(eBorder);
		userInfoL = new JLabel("유저 리스트");
		userInfoL.setBorder(eBorder);
		UserList = new List();

		InputMsgTF = new TextField();

		chatTA = new JTextArea();
		chatSP = new JScrollPane(chatTA);
		chatSP.setVerticalScrollBarPolicy(chatSP.VERTICAL_SCROLLBAR_ALWAYS);

		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
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
		northP.setPreferredSize(new Dimension(50, 50));
		northP.setLayout(new GridBagLayout());
		northP.add(set(roomInfoL, 0, 0, 3, 1, 2, 0));
		northP.add(set(new Label(""), 1, 0, 1, 1, 0, 0));
		northP.add(set(new Label(""), 2, 0, 1, 1, 0, 0));
		northP.add(set(userInfoL, 3, 0, 1, 1, 0, 0));

		Panel eastP = new Panel();
		eastP.setPreferredSize(new Dimension(150, 150));
		eastP.setLayout(new BorderLayout());
		eastP.add(new Label(" "), BorderLayout.EAST);
		eastP.add(UserList, BorderLayout.CENTER);

		Panel centerP = new Panel();
		centerP.setLayout(new BorderLayout());
		centerP.add(new Label(" "), BorderLayout.EAST);
		centerP.add(new Label(" "), BorderLayout.WEST);
		centerP.add(chatSP, BorderLayout.CENTER);

		Panel southP = new Panel();
		southP.setPreferredSize(new Dimension(50, 50));
		southP.setLayout(new GridBagLayout());
		southP.add(set(InputMsgTF, 0, 0, 3, 1, 2, 0));
		southP.add(set(new Label(""), 1, 0, 1, 1, 1, 0));
		southP.add(set(SendB, 2, 0, 1, 1, 0, 0));
		southP.add(set(changeB, 3, 0, 1, 1, 0, 0));
		southP.add(set(ExitB, 4, 0, 1, 1, 0, 0));

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

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("::: kotestalk :::");
		frame.setContents();
		frame.setSize(500, 500);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
	}

	public void eventRegist() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

	}
}
