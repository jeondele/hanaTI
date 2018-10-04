package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * 채팅방의 유저 목록을 jTable을 이용하여 나타내는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class ChattingRoom_East extends Panel {
	private static final String roomHeader[] = { "닉네임", "현재 위치"};

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	BorderLayout borderLayout;
	
	JTable chatUserTable, userAllTable;
	JScrollPane chatUserSP, userAllSP;
	Label chatUserL, userAllL;
	
	Vector<String> chatUserRow, userAllRow;
	DefaultTableModel chatUserModel, userAllModel;
	
	DefaultTableCellRenderer celAlignCenter;
	DefaultTableCellRenderer celAlignLeft;
	
	public ChattingRoom_East() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		borderLayout = 	new BorderLayout(20, 20);
		chatUserL = new Label("채팅 중인 유저");
		userAllL = new Label("전체 유저");
		
		chatUserModel = new DefaultTableModel(roomHeader, 0);
		chatUserTable = new JTable(chatUserModel);
		chatUserTable.setRowHeight(20);
		chatUserTable.setBackground(Color.white);
		chatUserTable.getColumn("닉네임").setPreferredWidth(70);
		chatUserTable.getColumn("닉네임").setCellRenderer(celAlignCenter);
		chatUserTable.getColumn("현재 위치").setPreferredWidth(30);
		chatUserTable.getColumn("현재 위치").setCellRenderer(celAlignLeft);
		
		chatUserSP = new JScrollPane(chatUserTable);

		userAllModel = new DefaultTableModel(roomHeader, 0);
		userAllTable = new JTable(userAllModel);
		userAllTable.setRowHeight(20);
		userAllTable.setBackground(Color.white);
		userAllTable.getColumn("닉네임").setPreferredWidth(70);
		userAllTable.getColumn("닉네임").setCellRenderer(celAlignCenter);
		userAllTable.getColumn("현재 위치").setPreferredWidth(30);
		userAllTable.getColumn("현재 위치").setCellRenderer(celAlignLeft);
		
		userAllSP = new JScrollPane(userAllTable);
		setContents();
	}
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(chatUserL, 		1, 0, 2, 1, 1, 0, 0, 0, -40, 0);
		
		Panel chatUserListPanel = new Panel();
		chatUserListPanel.setLayout(new BorderLayout());
		chatUserListPanel.add(chatUserSP);
		chatUserListPanel.setPreferredSize(new Dimension(WIDTH, 200));
		add(chatUserListPanel, 	1, 1, 4, 4, 1, 1, 0, 0, 0, 0);
		add(new Label(" "), 1, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 3, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 4, 1, 1, 0, 0, 0, 0, 0, 0);

		add(new Label(" "), 6, 5, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(userAllL, 		1, 7, 2, 1, 1, 0, 0, 0, -40, 0);

		Panel userAllPanel = new Panel();
		userAllPanel.setLayout(new BorderLayout());
		userAllPanel.add(userAllSP);
		userAllPanel.setPreferredSize(new Dimension(WIDTH, 255));
		add(userAllPanel, 	1, 8, 4, 3, 1, 1, 0, 0, 0, 0);
		add(new Label(" "), 1, 9, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 10, 1, 1, 0, 0, 0, 0, 0, 0);
	}
	// 패널에 더해줄 컴포넌트들의 요소들을 세팅하는 메소드
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
}
