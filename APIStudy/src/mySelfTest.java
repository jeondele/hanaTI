
public class mySelfTest {

	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();

		new Thread(() -> {
		    for(int i=0; i<10000; i++) {
		        stringBuffer.append(i);
		        stringBuilder.append(i);
		    }
		}).start();

		new Thread(() -> {
		    for(int i=0; i<10000; i++) {
		        stringBuffer.append(i);
		        stringBuilder.append(i);
		    }
		}).start();

		new Thread(() -> {
		    try {
		        Thread.sleep(5000);

		        System.out.println("StringBuffer.length: "+ stringBuffer.length());
		        System.out.println("StringBuilder.length: "+ stringBuilder.length());
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}).start();
	}

}
