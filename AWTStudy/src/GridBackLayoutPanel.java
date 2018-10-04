import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

public class GridBackLayoutPanel extends Panel {

	Button button1, button2, button3;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	
	public GridBackLayoutPanel() {
		button1 = new Button("BUTTON NO.1");
		button2 = new Button("BUTTON NO.2");
		button3 = new Button("BUTTON NO.3");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(button1, 0, 0 , 1, 1, 0, 0);
		add(button2, 1, 0 , 1, 1, 1, 0);
		add(button3, 0, 1 , 2, 1, 1, 1);
		
//		//버튼을 붙일 때마다 격자를 자동 계산
//		//컴포넌트 고유의 크기를 유지하면서 flowLayout처럼 움직인다.
//		//붙일때마다 필요한 애들
//		gridBagConstraints.gridx = 0;
//		gridBagConstraints.gridy = 0;
//		gridBagConstraints.gridwidth = 1;
//		gridBagConstraints.gridheight = 1;
//		//나머지 여백을 다차지 해라(숫자 값  1 );
//		
//		gridBagConstraints.weightx = 0;
//		gridBagConstraints.weighty = 0;
//		
//		gridBagLayout.setConstraints(button1, gridBagConstraints);
//		add(button1);
	
	}
	
	private void add( Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = gridBagConstraints.VERTICAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);	
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("GRIDBACK LAYOUT");
		GridBackLayoutPanel gridPanel = new GridBackLayoutPanel();
		gridPanel.setContents();
		frame.add(gridPanel);
		//픽셀을 직접 지정
//		frame.setSize(400, 400);
		
		frame.pack();
		frame.setVisible(true);
	}
}
