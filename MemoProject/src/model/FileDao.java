package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//(DataAccessObject)
public class FileDao {
	
	//filepath에 있는것을 불러서 ta에 뿌려주는 역할
	public String fileRead (String filePath) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");

//		BufferedReader br = new BufferedReader(new FileReader(filePath));
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		while((line = br.readLine())!= null) {
//			sb.append(line+"\n");
//		}
//		return sb.toString();
		String txt = null;
		File file = new File(filePath);
		if (!file.exists()) {
			throw new IOException();
		}
		
		BufferedReader br =null;

		try{
			br = new BufferedReader(inputStreamReader);
			char[] buffer = new char[(int)file.length()];
			int count = br.read(buffer);
			txt = new String(buffer, 0, count);
		} finally {
			if (br !=null) br.close();
		}
		return txt;
	}
	
	//ta에 있는 것을 file을 생성해서 저장하는 역할
	public void fileSave (String toBeSaved, String textArea) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(toBeSaved, "utf-8");
			textArea = textArea.replaceAll("\n", "\r\n");
			out.print(textArea);
		} finally {
			if(out != null) out.close();
		}
	}
}
