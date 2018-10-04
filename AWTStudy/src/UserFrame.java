import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserFrame extends Frame implements MouseListener, WindowListener {
	
	Button buttonEast, buttonWest, buttonSouth, buttonNorth, buttonCenter;

	public UserFrame(){
		this("이름없음");
	}
	
	public UserFrame(String title){
		super(title);
		buttonEast = new Button("East");
		buttonWest = new Button("West");
		buttonSouth = new Button("South");
		buttonNorth = new Button("North");
		buttonCenter = new Button("Center");
	}
	
	//화면 배치
	public void setContents() {
		// 레이아웃 매니저 교체
		setLayout(new FlowLayout()); //
		add(buttonEast, BorderLayout.EAST);
		add(buttonWest, BorderLayout.WEST);
		add(buttonSouth, BorderLayout.SOUTH);
		add(buttonNorth, BorderLayout.NORTH);
		add(buttonCenter, BorderLayout.CENTER);
		
	}
	
	//이벤트 소스에 이벤트 리스너 연결
	public void eventRegist() {
		buttonEast.addMouseListener(this);
		buttonWest.addMouseListener(this);
		buttonSouth.addMouseListener(this);
		buttonNorth.addMouseListener(this);
		buttonCenter.addMouseListener(this);
		addWindowListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭되었습니다..");
		//eButton
		Object eventSource = e.getSource();
		Button button = (Button)eventSource;
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		button.setBackground(new Color(r, g, b));
		
		if(eventSource == buttonEast) {
			System.out.println("buttonEast 클릭임");
		} else if (eventSource == buttonWest) {
			System.out.println("buttonWest 클릭임");
		} else if (eventSource == buttonSouth) {
			System.out.println("buttonSouth 클릭임");
		} else if (eventSource == buttonNorth) {
			System.out.println("buttonNorth 클릭임");
		} else if (eventSource == buttonCenter) {
			System.out.println("buttonCenter 클릭임");
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed() called.....");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased() called.....");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered() called.....");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseexited() called.....");
	}

	//창이 처음 열릴 때
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("창이 열렸습니다....");
	}

	//창닫을 때
	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false); //화면에서 사라지게 하는 것.
		dispose(); //os에 그래픽리소스 반납.
		System.exit(0); //virtualmachine 종료.
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
	public static void main(String[] args) {
		UserFrame uf = new UserFrame("타이틀입니다.");
		uf.setContents();
		uf.eventRegist();
		uf.setSize(800, 3000); //pixel로만 가능
		uf.setVisible(true);
	}

	

}
