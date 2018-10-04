package examples;

import java.io.IOException;

public class SingletoneExample {

	public static void main(String[] args) throws IOException {
//		Logger logger = new Logger();
		Logger logger = Logger.getInstance();
		logger.log("테스트입니다...");


		//Calendar, toolkit, runtime ----- 싱글톤 패턴
//		Runtime runtime = Runtime.getRuntime();
//		runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.naver.com");
	}

}
