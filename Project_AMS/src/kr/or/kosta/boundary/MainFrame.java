package kr.or.kosta.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import kr.or.kosta.entity.AccountManager;

/**
 * AMS 어플리케이션의 기본 프레임 부분입니다.
 * 
 * @author 전상일
 */
public class MainFrame extends Frame {
	
	BorderLayout borderLayout;
	CenterPanel centerPanel;
	
	/**
	 * 어플리케이션의 디폴트 제목 : "KOSTA AMS - 메인화면"
	 */
	public MainFrame() {
		this("KOSTA AMS - 메인화면");
	}
	
	/**
	 * Layout 틀의 여백, 실제 기능을 하는 panel, 그 밖의 구성요소를 MainFrame 인스턴스 생성 시 설정합니다.
	 *  
	 * @param title 어플리케이션 실행 창의 제목
	 */
	public MainFrame(String title) {
		super(title);
		borderLayout = new BorderLayout(20, 20);
		centerPanel = new CenterPanel();
		setContents();
		setSize(850, 500);
		setCenter();
		eventRegist();
		setVisible(true);
	}
	
	/**
	 * @return 생성된 CenterPanel 인스턴스를 반환합니다.
	 */
	public CenterPanel getCenterPanel() {
		return centerPanel;
	}
	
	/**
	 *  어플리케이션 실행 창을 종료시키는 메소드 입니다.
	 */
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/**
	 *  MainFrame을 BrderLayout으로 지정하고, MainFrame의 중심부에 centerpanel을 넣어줍니다.
	 */
	private void setContents() {
		setLayout(borderLayout);
		add(centerPanel, borderLayout.CENTER);
	}
	
	/**
	 *  어플리케이션 실행 시 사용자 스크린의 중심부에 어플리케이션 실행 창이 올 수 있도록 합니다.
	 */
	private void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}

	/**
	 *  어플리케이션의 이벤트를 등록합니다.
	 */
	private void eventRegist() {
		
		/**
		 * 어플리케이션 화면을 종료할 수 있도록 이름없는 내부 클래스를 생성하여 finish() 메소드를 추가합니다.
		 */
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
	}
}
