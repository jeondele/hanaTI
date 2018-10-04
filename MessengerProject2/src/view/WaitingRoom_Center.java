package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class WaitingRoom_Center extends Panel {

	private static final String roomHeader[] = { "방 번호", "제목", "방장", "인원"};
	String[][] roomContents = {{"","","",""}};

	Label roomListL;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	BorderLayout borderLayout;
	JTable roomTable;
	JScrollPane roomSP;
	Vector<String> userRow;
	DefaultTableModel model;

	DefaultTableCellRenderer celAlignCenter;
	DefaultTableCellRenderer celAlignLeft;

	public WaitingRoom_Center() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		borderLayout = new BorderLayout(20, 20);
		model = new DefaultTableModel(roomHeader, 0);
		roomTable = new JTable(model);
		roomListL = new Label("방 목록");
		roomTable.setRowHeight(40);
		roomTable.setBackground(Color.white);
		roomTable.getColumn("방 번호").setPreferredWidth(3);
		roomTable.getColumn("방 번호").setCellRenderer(celAlignCenter);
		roomTable.getColumn("제목").setPreferredWidth(200);
		roomTable.getColumn("제목").setCellRenderer(celAlignLeft);
		roomTable.getColumn("방장").setPreferredWidth(2);
		roomTable.getColumn("방장").setCellRenderer(celAlignCenter);
		roomTable.getColumn("인원").setPreferredWidth(2);
		roomTable.getColumn("인원").setCellRenderer(celAlignCenter);
		roomSP = new JScrollPane(roomTable);
		setContents();
	}

	public void setContents() {
		setLayout(gridBagLayout);

		add(roomListL, 1, 0, 2, 1, 1, 0, 3, 0, 0, 0);

		Panel roomListPanel = new Panel();
		roomListPanel.setLayout(new BorderLayout());
		roomListPanel.add(roomSP);
		roomListPanel.setPreferredSize(new Dimension(WIDTH, 570));
		add(roomListPanel, 1, 1, 4, 4, 1, 1, 0, 0, 1, 0);
		add(new Label(" "), 1, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 3, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 1, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 2, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 3, 4, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "), 4, 4, 1, 1, 0, 0, 0, 0, 0, 0);
	}

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

//	public static void main(String[] args) {
//		TalkFrame frame = new TalkFrame("메인화면");
//		frame.setSize(600, 800);
//
//		WaitingRoom_Center loginPanel = new WaitingRoom_Center();
//
//		frame.add(loginPanel);
//		frame.setCenter();
//		frame.setVisible(true);
//	}
}
