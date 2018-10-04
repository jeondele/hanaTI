package myAWT;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;

public class GridBackLayoutSouthPanel extends Panel {

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Button sendB, cancelB;
	
	public GridBackLayoutSouthPanel() {
		sendB = new Button("  보내기  ");
		cancelB = new Button("  취소  ");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		setContents();
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(new Label(" "),   	0, 0, 1, 1, 0, 0);
		add(new Label(" "),   	1, 0, 1, 1, 0, 0);
		add(new Label(" "),  	2, 0, 1, 1, 0, 0);
		add(new Label(" "), 	3, 0, 1, 1, 0, 0);
		add(new Label(" "), 	4, 0, 1, 1, 0, 0);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(sendB);
		buttonPanel.add(new Label(" "));
		buttonPanel.add(cancelB);
		add(buttonPanel, 		0, 1, 4, 1, 1, 0);
		add(new Label(" "),   	0, 2, 1, 1, 0, 0);
		add(new Label(" "),  	1, 2, 1, 1, 0, 0);
		add(new Label(" "),  	2, 2, 1, 1, 0, 0);
		add(new Label(" "), 	3, 2, 1, 1, 0, 0);
		add(new Label(" "), 	4, 2, 1, 1, 0, 0);
	}
	
	private void add( Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
//		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
//		gridBagConstraints.insets = new Insets(5, 5, 10, 10);	
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("GRIDBACK LAYOUT");
		GridBackLayoutSouthPanel gridPanel = new GridBackLayoutSouthPanel();
		gridPanel.setContents();
		frame.add(gridPanel);
		//픽셀을 직접 지정
		frame.setSize(400, 400);
		
//		frame.pack();
		frame.setVisible(true);
	}
}
