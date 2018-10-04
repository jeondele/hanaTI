package myAWT;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class GridBackLayoutNorthPanel extends Panel {

	Label receiverL, fileL, titleL;
	TextField receiverTF, fileTF, titleTF;
	Button findB;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	
	public GridBackLayoutNorthPanel() {
		receiverL = new Label("받는사람");
		fileL = new Label("첨부파일");
		titleL = new Label("제목");
		receiverTF = new TextField();
		fileTF = new TextField();
		titleTF = new TextField();
		findB = new Button("  찾기  ");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(receiverL, 			0, 0, 1, 1, 0, 0);
		add(receiverTF, 		1, 0, 1, 1, 1, 0);
		add(new Label(" "),		2, 0, 1, 1, 0, 0);	
		add(new Label(" "),		3, 0, 1, 1, 1, 0);	

		add(fileL, 				0, 1, 1, 1, 0, 0);
		add(fileTF, 			1, 1, 1, 1, 1, 0);
		add(findB, 				2, 1, 1, 1, 0, 0);
		add(new Label(" "),		3, 1, 1, 1, 1, 0);	
		
		add(titleL, 			0, 2, 1, 1, 0, 0);
		add(titleTF, 			1, 2, 3, 1, 1, 0);
		
	}
	
	private void add( Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);	
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("GRIDBACK LAYOUT");
		GridBackLayoutNorthPanel gridPanel = new GridBackLayoutNorthPanel();
		gridPanel.setContents();
		frame.add(gridPanel);
		//픽셀을 직접 지정
		frame.setSize(400, 400);
		
//		frame.pack();
		frame.setVisible(true);
	}
}
