package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * 대기실의 전체목록, 방정보를 담고있는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class WaitingRoom_East extends Panel {
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	BorderLayout borderLayout;

	Label roomInfoL, userListL;
	List roomInfoList, userList;
	Button userAllB, userLeftB;
	
	JTable userTable, roomInfoTable;
	JScrollPane roomSP;
	
	Vector<String> userRow;
	DefaultTableModel model;
	
	DefaultTableCellRenderer celAlignCenter;
	DefaultTableCellRenderer celAlignLeft;
	
	private static final String roomHeader[] = { "닉네임", "현재 위치"};

	public WaitingRoom_East() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		borderLayout = new BorderLayout(20, 20);
		roomInfoL = new Label("방 정보");
		userListL = new Label("전체 유저 목록");
		model = new DefaultTableModel(roomHeader, 0);
		userTable = new JTable(model);
		userTable.setRowHeight(20);
		userTable.setBackground(Color.white);
		userTable.getColumn("닉네임").setPreferredWidth(70);
		userTable.getColumn("닉네임").setCellRenderer(celAlignCenter);
		userTable.getColumn("현재 위치").setPreferredWidth(30);
		userTable.getColumn("현재 위치").setCellRenderer(celAlignLeft);
		
		roomSP = new JScrollPane(userTable);
		
		userList = new List();
		roomInfoList = new List();

		userAllB = new Button("전체 이용자");
		userLeftB = new Button("대기자");

		setContents();
	}

	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);

		add(userListL, 1, 0, 2, 1, 1, 0, 3, 0, 0, 0);

		Panel userListPanel = new Panel();
		userListPanel.setLayout(new BorderLayout());
		userListPanel.add(roomSP);
		userListPanel.setPreferredSize(new Dimension(WIDTH, 372));
		add(userListPanel, 1, 1, 4, 4, 1, 1, 0, 0, 0, 0);
		add(new Label(" "), 1, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 3, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 5, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 6, 4, 1, 1, 0, 0, 0, 0, 0, 0);

		add(roomInfoL, 1, 5, 1, 1, 0, 0, 15, 0, 0, 0);

		Panel roomInfoPanel = new Panel();
		roomInfoPanel.setLayout(new BorderLayout());
		roomInfoPanel.add(roomInfoList);
		roomInfoPanel.setPreferredSize(new Dimension(WIDTH, 155));
		add(roomInfoPanel, 1, 6, 4, 3, 1, 1, 0, 0, 0, 0);
		add(new Label(" "), 1, 7, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 8, 1, 1, 0, 0, 0, 0, 0, 0);
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
