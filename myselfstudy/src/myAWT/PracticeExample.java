package myAWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class PracticeExample extends Frame {
	
	GridBackLayoutNorthPanel gridBackLayoutNorthPanel;
	GridBackLayoutSouthPanel gridBackLayoutSouthPanel;
	TextArea mailTA;
	
	public PracticeExample(){
		this("AWTPractice");
	}
	
	public PracticeExample(String title){
		super(title);
		gridBackLayoutNorthPanel = new GridBackLayoutNorthPanel();
		gridBackLayoutSouthPanel = new GridBackLayoutSouthPanel();
		mailTA = new TextArea();
		
	}
	
	public void setContents() {
		
		add(gridBackLayoutNorthPanel, BorderLayout.NORTH);
		add(mailTA, BorderLayout.CENTER);
		add(gridBackLayoutSouthPanel, BorderLayout.SOUTH);
		
		add(new Label("     "), BorderLayout.EAST );
		add(new Label("     "), BorderLayout.WEST );
	}
	
	private void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	public static void main(String[] args) {
		PracticeExample pe = new PracticeExample("연습입니다..!");
		pe.setContents();
		pe.setSize(600, 500); //pixel로만 가능
		pe.setVisible(true);
	}

}
