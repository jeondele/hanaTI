package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

import model.FileDao;

public class MemoUI extends Frame {
	TextArea memoTA;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, openMI, saveMI, exitMI;
	
	FileDao fileDao;
	Frame owner;
	FileDialog fileDialog;
	
	String toBeSaved;
	
	public MemoUI() {
		this("NO TITLE");
	}

	public MemoUI(String title) {
		super(title);
		
		fileDao = new FileDao();
		owner = new Frame();
		
		memoTA = new TextArea();
		
		menuBar = new MenuBar();
		menu	= new Menu("메뉴");
		newMI	= new MenuItem("새로만들기");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N, true));
		openMI 	= new MenuItem("열기");
		openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O, true));
		saveMI 	= new MenuItem("저장");
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S, true));
		exitMI  = new MenuItem("끝내기");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X, true));
		setContents();
		setSize(600, 700);
		setCenter();
		eventRegist();
		setVisible(true);
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		add(memoTA, BorderLayout.CENTER);
	
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(openMI);
		menu.addSeparator();
		menu.add(saveMI);
		menu.addSeparator();
		menu.add(exitMI);
	}
	private void setOwner() {
		owner.setSize(400, 200);
	}
	
	private void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setText(null);
			}
		});
		
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setOwner();
				fileDialog = new FileDialog( owner ,"파일 저장", FileDialog.SAVE);
				fileDialog.setVisible(true);
				String dfName = fileDialog.getDirectory() + fileDialog.getFile();
				String text = memoTA.getText();
				text.replaceAll("\n", "\r\n");
				try {
					fileDao.fileSave(dfName, text);
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					JOptionPane.showMessageDialog(null, "저장되지 않았습니다.", "주의", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setOwner();
				fileDialog = new FileDialog( owner ,"파일 열기", FileDialog.LOAD);
				fileDialog.setVisible(true);
				
				try {
					String path = fileDialog.getDirectory() + fileDialog.getFile();
					System.out.println(path);
					String text = fileDao.fileRead(path);
					memoTA.setText(text);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "불러오지 못했습니다", "주의", JOptionPane.WARNING_MESSAGE);
				} 
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		
	}
}


