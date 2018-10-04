import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class AWTExample {

	public static void main(String[] args) {
		Frame frame = new Frame("처음으로 만든 프레임");
		frame.setSize(800, 3000); //pixel로만 가능
		frame.setVisible(true);
		
		Button button1 = new Button("AWT1"); //버튼 들어가는 거
		Button button2 = new Button("AWT2");
		
		frame.setLayout(new FlowLayout());
		frame.add(button1);
		frame.add(button2);
		
		Label label = new Label("AWT Label"); //그냥 글자만 들어가는거
		frame.add(label);
		
		TextField textField = new TextField("아이디", 10); //디폴트 값, 10글자 짜리 칸 생성
		frame.add(textField);
		TextArea textArea = new TextArea(5, 20);
		frame.add(textArea);
		
//		Checkbox checkbox = new Checkbox("male", true);
//		frame.add(checkbox);
//		
		CheckboxGroup cg = new CheckboxGroup();			//체크박스 
		Checkbox cb1 = new Checkbox("male", true, cg);
		Checkbox cb2 = new Checkbox("female", true, cg);
		frame.add(cb1);
		frame.add(cb2);
		//frame.setResizable(true);
		
		Choice selectBox = new Choice();	//선택 박스
		selectBox.add("Son heung min");
		selectBox.add("Kim hak beum");
		frame.add(selectBox);
		
	}

}
