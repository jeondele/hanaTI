import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExample {

	public static void main(String[] args) {
		Frame owner = new Frame();
		owner.setSize(400,200);
		owner.setVisible(true);

		Dialog dialog = new Dialog(owner, "타이틀", true); //모달 (창이뜨면 다른 창을 컨트롤 할 수 없다), 비모달( 창이떠도 다른창 입력가능하다)
		dialog.setSize(200,200);
		dialog.setVisible(true);
		
//		Window window = new Window(owner);
//		window.setSize(400, 200);
//		window.setVisible(true);
		
		FileDialog fileDialog = new FileDialog(owner, "파일열기", FileDialog.LOAD);
		FileDialog fileDialogSave = new FileDialog(owner, "파일열기", FileDialog.SAVE);
		fileDialog.setVisible(true);
	}
}
