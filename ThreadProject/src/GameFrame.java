import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame extends Frame implements Runnable {
	
	int x1, x2, x3 = 100, distance = 5;
	
	Image horse;
	Image worm;
	Image maserati;
	
	public GameFrame(String title) {
		super(title);
		horse = Toolkit.getDefaultToolkit().getImage("horse.jpg");
		worm = Toolkit.getDefaultToolkit().getImage("worm.jpg");
		maserati = Toolkit.getDefaultToolkit().getImage("maserati.jpg");
	}

	public void setContents() {
		
	}
	
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				gameStart();
			}
		});
	}
	
	//시작할 때 뛰게 하려면 windowOpen 할때 시작해 주면 된다.
	public void gameStart() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
//		g.dr(x, 100, 100, 100);
		g.drawImage(horse, x1, 100, this);
		g.drawImage(worm, x2, 250, this);
		g.drawImage(maserati, x3, 400, this);
	
		
	}
	//메소드 만들어서 호출하는 구조로 만들어 준다.
	@Override
	public void run() {
		Random random = new Random();
		boolean flag = true;
		while(flag) {
			x1 += random.nextInt(distance);
			x2 += random.nextInt(distance);
			x3 += random.nextInt(distance);
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			
			if (x1 == 500 && x2 == 500 && x3 == 500) {
				flag = false;
			}
		}
	}
	
	
}
