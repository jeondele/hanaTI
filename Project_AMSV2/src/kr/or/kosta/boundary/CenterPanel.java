package kr.or.kosta.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDAO;
import kr.or.kosta.entity.AccountException;

/**
 * AMS의 실제 기능을 하는 패널입니다.
 * 
 * 1. MainFrame에 담기 위한 Panel입니다.
 * 2. 익명 내부클래스를 통한 ActionListener,ItemListener 를 구현했습니다.
 * 
 * @author 전상일
 */
public class CenterPanel extends Panel {
	
	GridBagLayout gridBagLayout;
	BorderLayout borderLayout;
	GridBagConstraints gridBagConstraints;
	
	AccountDAO accountManager;

	Label accTypeL, accNumL, accOwnerL, accPwdL, accDepositL, accLoanL, accListL, unitL,
		  accNumExceptionL, accOwnerExceptionL, accPwdExceptionL, accDepoExceptionL, accLoanExceptionL;
	
	Choice accTypeC;
	Button searchAccB, deleteAccB, searchOwnerB, registAccB, searchAllB;
	TextField accNumTF, accOwnerTF, accPwdTF, accDepositTF, accLoanTF;
	TextArea accListTA;
	
	/**
	 *  CenterPanel 인스턴스 생성 시 기본으로 설정하는 기능들을 담은 생성자입니다. 
	 *  프레임 안에 넣어줄 라벨, 텍스트 필드, 텍스트 영역, 발생하는 이벤트 등을 세팅합니다
	 */
	public CenterPanel() {
		gridBagLayout = 		new GridBagLayout();
		borderLayout = 			new BorderLayout(20, 20);
		gridBagConstraints = 	new GridBagConstraints();
		
		accTypeL = 		new Label("계좌종류 ");
		accNumL = 		new Label("계좌번호 ");
		accOwnerL = 	new Label("예금주명 ");
		accPwdL = 		new Label("비밀번호 ");
		accDepositL = 	new Label("입금금액 ");
		accLoanL = 		new Label("대출금액 ");
		accListL = 		new Label("계좌목록 ");
		unitL = 		new Label("(단위 :원)");
		unitL.setAlignment(Label.RIGHT);
		
		accNumExceptionL = 		new Label("");
		accOwnerExceptionL = 	new Label("");
		accPwdExceptionL = 		new Label("");
		accDepoExceptionL =		new Label("");
		accLoanExceptionL = 	new Label("");
		
		accTypeC = 		new Choice();
		
		searchAccB = 	new Button(" 조 회 ");
		deleteAccB = 	new Button(" 삭 제 ");
		searchOwnerB = 	new Button(" 검 색 ");
		registAccB = 	new Button(" 신규등록 ");
		searchAllB = 	new Button(" 전체조회 ");
		
		accNumTF = 		new TextField();
		accOwnerTF = 	new TextField();
		accPwdTF = 		new TextField();
		accDepositTF = 	new TextField();
		accLoanTF = 	new TextField();
		
		accListTA =		new TextArea();
		accListTA.setEditable(false);
		
		setContents();
		eventRegist();
	}
	
	/**
	 * 연관관계에 있기 때문에 setter 메소드를 통해 AccountManager를 CenterPanel와 연관시켜줍니다.
	 * 
	 * @param accountManager	CenterPanel에서 처리할 AccountManager를 받아옵니다.
	 */
	public void setAccountManager(AccountDAO accountManager) {
		this.accountManager = accountManager;
	}
	
	/**
	 *  CenterPanel의 Layout을 GridBagLayout으로 설정하고, 라벨, 텍스트 영역 등의 기본 구조를 화면에 배치합니다. 
	 */
	private void setContents() {
		setLayout(gridBagLayout);
		
		accPwdTF.setEchoChar('*');
		accTypeC.add("전체계좌");
		accTypeC.add("입출금계좌");
		accTypeC.add("마이너스계좌");
		
		add(new Label(" "),   	0, 0, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 1, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(new Label(" "),   	0, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(accTypeL,   		1, 2, 1, 1, 0, 0, 5, 0, 5, 0);
		add(accTypeC,   		2, 2, 1, 1, 0, 0, 0, 0, 10, 0);
		add(new Label(" "),   	3, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	4, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	5, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	6, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	7, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	8, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	9, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	10, 2, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(accNumL,   			1, 3, 1, 1, 0, 0, 5, 0, 0, 0);
		add(accNumTF,   		2, 3, 2, 1, 1, 0, 5, 0, 0, 0);
		add(searchAccB,   		5, 3, 1, 1, 0, 0, 1, 0, 0, 10);
		add(deleteAccB,   		6, 3, 1, 1, 0, 0, 1, 0, 0, 0);
		
		add(accNumExceptionL,   2, 4, 2, 1, 1, 0, 0, 0, 0, 0);
		
		add(accOwnerL,   		1, 5, 1, 1, 0, 0, 5, 0, 0, 0);
		add(accOwnerTF,   		2, 5, 2, 1, 1, 0, 5, 0, 0, 0);
		add(searchOwnerB,   	5, 5, 1, 1, 0, 0, 1, 0, 0, 10);
		
		add(accOwnerExceptionL, 2, 6, 2, 1, 1, 0, 0, 0, 0, 0);
		
		add(accPwdL,   			1, 7, 1, 1, 0, 0, 5, 0, 0, 0);
		add(accPwdTF,   		2, 7, 2, 1, 1, 0, 5, 0, 0, 0);
		add(accDepositL,   		5, 7, 1, 1, 0, 0, 5, 0, 0, 0);
		add(accDepositTF,   	6, 7, 4, 1, 1, 0, 5, 0, 0, 0);
		
		add(accPwdExceptionL,   2, 8, 2, 1, 1, 0, 0, 0, 0, 0);
		add(accDepoExceptionL,	6, 8, 4, 1, 1, 0, 0, 0, 0, 0);
		
		add(accLoanL,   		1, 9, 1, 1, 0, 0, 5, 0, 0, 0);
		add(accLoanTF,   		2, 9, 2, 1, 1, 0, 5, 0, 0, 0);
		add(registAccB,   		5, 9, 1, 1, 0, 0, 1, 0, 0, 10);
		add(searchAllB,   		6, 9, 1, 1, 0, 0, 1, 0, 0, 0);
		
		add(accLoanExceptionL,  2, 10, 2, 1, 1, 0, 0, 0, 0, 0);
		
		add(accListL,   		1, 11, 1, 1, 0, 0, 0, 0, 0, 0);
		add(unitL,   			9, 11, 1, 1, 0, 0, 0, 0, 0, 0);
		
		add(accListTA, 			1, 12, 9, 8, 1, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 13, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 14, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 15, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 16, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 17, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 18, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 19, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 20, 1, 1, 0, 0, 0, 0, 0, 0);
		add(new Label(" "),   	0, 21, 1, 1, 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * GridLayout에 격자로 기능들을 시각화할 때, 각 라벨, 텍스트, 버튼등의 위치, 넓이, 들여쓰기 등을 더해주는 메소드입니다.
	 * 
	 * @param component		지정할 구성요소를 파라미터로 받습니다.
	 * @param gridx			그리드 내부의 x좌표를 지정합니다.
	 * @param gridy			그리드 내부의 y좌표를 지정합니다.
	 * @param gridwidth		해당 구성요소의 폭을 지정합니다.
	 * @param gridheight	해당 구성요소의 높이를 지정합니다.
	 * @param weightx		해당 구성요소의 가로 부분의 가중치를 지정해 줍니다.
	 * @param weighty		해당 구성요소의 세로 부분의 가중치를 지정해 줍니다.
	 * @param insetsT		해당 구성요소의 상단 들여쓰기를 지정해줍니다.
	 * @param insetsL		해당 구성요소의 왼쪽 들여쓰기를 지정해줍니다.
	 * @param insetsB		해당 구성요소의 하단 들여쓰기를 지정해줍니다.
	 * @param insetsR		해당 구성요소의 오른쪽 들여쓰기를 지정해줍니다.
	 */
	private void add(Component component, 
					int gridx, int gridy, int gridwidth, int gridheight, 
					double weightx, double weighty, 
					int insetsT, int insetsL, int insetsB, int insetsR) {

		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.insets = new Insets(insetsT, insetsL, insetsB, insetsR);

		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	/**
	 * 	어플리케이션의 화면을 reset시켜주는 메소드입니다.
	 */
	private void setDefaultText() {
		accListTA.setText(null);
		accNumTF.setText(" ");
		accNumTF.setText("");
		accOwnerTF.setText(" ");
		accOwnerTF.setText("");
		accPwdTF.setText(" ");
		accPwdTF.setText("");
		accDepositTF.setText(" ");
		accDepositTF.setText("");
		accLoanTF.setText(" ");
		accLoanTF.setText("");
		accNumExceptionL.setText(" ");
		accOwnerExceptionL.setText(" ");
		accPwdExceptionL.setText(" "); 
		accDepoExceptionL.setText(" ");
		accLoanExceptionL.setText(" ");
	}
	
	/**
	 * 신규 등록을 위해 등록이 가능한지 아닌지 판별하는 메소드입니다.
	 * 
	 * @return 신규 등록하기 위해 계좌번호, 예금주, 비밀번호, 입금금액 등을 적어주었다면 true, 아니면 false를 반환합니다.
	 */
	private boolean isRegistable() {
		return !accNumTF.getText().equals("") && !accOwnerTF.getText().equals("") 
			   && !accPwdTF.getText().equals("") && !accDepositTF.getText().equals("");
	}
	
	public void close() {
		accountManager.close();
	}
	/**
	 * 사용자가 수행하는 이벤트들을 처리하는 메소드 입니다.
	 */
	private void eventRegist() {
		
		/**
		 * 계좌종류를 바꾸는 버튼을 누르면 누를 때마다 어플리케이션 실행창을 reset 시키고, 입출금계좌 종류로 들어갈 시에 입력 못하게 해줍니다.
		 */
		accTypeC.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setDefaultText();
				if(accTypeC.getSelectedItem().equals("입출금계좌")) {
					accLoanTF.setEnabled(false);
				} else {
					accLoanTF.setEnabled(true);
				}
			}
		});
		
		/**
		 * 계좌 종류(전체계좌, 입출금계좌, 마이너스계좌)에 따라 해당 목록들을 보여줍니다.
		 */
		searchAllB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, 
											  accTypeC.getSelectedItem() + "목록을 보여드립니다.", 
											  "알림",
											  JOptionPane.INFORMATION_MESSAGE);
				
				setDefaultText();
				accListTA.append(accTypeC.getSelectedItem() + "목록" + "\n");
				accListTA.append(
						"----------------------------------------------------------------------------------"
						+ "-----------------------------------------------\n");
				accListTA.append("계좌종류\t\t 계좌번호\t\t예금주명\t\t\t현재잔액\t\t\t대출금액\n");
				accListTA.append(
						"=================================================================================="
						+ "===============================================\n");
				if (accTypeC.getSelectedItem().equals("전체계좌")) {
					List<Account> allList = null;
					
					try {
						allList = accountManager.listAll();
						for (Account account : allList) {
							accListTA.append(account.toString() + "\n");
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, 
								"등록된 계좌 목록이 없습니다.", 
								"주의",
								JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					List<Account> typeList = null;
					try {
						typeList = accountManager.list(accTypeC.getSelectedIndex());
						for (Account account : typeList) {
							accListTA.append(account.toString() + "\n");
						}

					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, 
			  					  "등록된 계좌 목록이 없습니다.", 
			  					  "주의",
			  					  JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		/**
		 * 계좌 종류에 따라서 계좌번호가 있는 지 조회하는 이벤트입니다.
		 */
		searchAccB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Account account = accountManager.get(accNumTF.getText());
					JOptionPane.showMessageDialog(null, 
												  accTypeC.getSelectedItem() + "에서 조회합니다.", 
												  "알림",
												  JOptionPane.INFORMATION_MESSAGE);
					
					accListTA.setText(null);
					if(accTypeC.getSelectedItem().equals("전체계좌")||accTypeC.getSelectedItem().equals("입출금계좌")||accTypeC.getSelectedItem().equals("마이너스계좌")) {
						accListTA.setText(null);
						accListTA.append(accNumTF.getText() + " 조회 결과" + "\n");
						accListTA.append(
								"--------------------------------------------------------------------------"
								+ "-------------------------------------------------------\n");
						accListTA.append("계좌종류\t\t 계좌번호\t\t예금주명\t\t\t현재잔액\t\t\t대출금액\n");
						accListTA.append(
								"=========================================================================="
								+ "=======================================================\n");
						accListTA.append(account.toString());
					} else {
						accNumExceptionL.setText(accTypeC.getSelectedItem()+" 목록에는 없습니다.");
						accNumExceptionL.setForeground(Color.RED);
					}
				} catch (AccountException e1) {
					accNumExceptionL.setText(e1.getMessage());
					accNumExceptionL.setForeground(Color.RED);
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, 
							  "불러오는 과정에서 오류가 발생했습니다.", 
							  "주의",
							  JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		/**
		 * 계좌번호 입력창을 마우스로 클릭할 시, 계좌번호 창, 예외처리 문구를 전부 지웁니다.
		 */
		accNumTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				accNumTF.setText(" ");
				accNumTF.setText("");
				accNumExceptionL.setText(" ");
			}
		});
		
		/**
		 * 해당 계좌번호에 해당하는 계좌를 삭제하는 이벤트입니다. 단, Choice 버튼이 해당 계좌의 종류여야합니다.
		 */
		deleteAccB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					if((accTypeC.getSelectedItem().equals("전체계좌")||accTypeC.getSelectedItem().equals("입출금계좌")||accTypeC.getSelectedItem().equals("마이너스계좌"))&& (accountManager.remove(accNumTF.getText()))) 
					{
						JOptionPane.showMessageDialog(null, 
													  accNumTF.getText() + "계좌번호가 삭제되었습니다.", 
													  "알림",
													  JOptionPane.INFORMATION_MESSAGE);
						setDefaultText();
					} else {	
						accNumExceptionL.setText("해당계좌에서는 삭제 불가합니다.");
						accNumExceptionL.setForeground(Color.RED);
					}
				} catch (HeadlessException | AccountException | IOException e1) {
					JOptionPane.showMessageDialog(null, 
							  "삭제 과정에서 오류가 발생했습니다.", 
							  "주의",
							  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/**
		 * 예금주 입력창을 마우스로 클릭할 시, 예금주 창, 예외처리 문구를 전부 지웁니다.
		 */
		accOwnerTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				accOwnerTF.setText(" ");
				accOwnerTF.setText("");
				accOwnerExceptionL.setText(" ");
			}
		});
		
		/**
		 * 예금주 창에서 받은 텍스트 값에 해당하는 예금주가 AccountManager의 계좌목록에 있는 지 찾고, 있으면 텍스트영역에 뿌려줍니다.
		 */
		searchOwnerB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					List<Account> accOwnerList = accountManager.search(accOwnerTF.getText());

					JOptionPane.showMessageDialog(null, 
												  accOwnerTF.getText() +" 님의 " + accTypeC.getSelectedItem() + " 목록입니다.", 
												  "알림",
												  JOptionPane.INFORMATION_MESSAGE);
					accListTA.setText(null);
					int cnt = 0;
					accListTA.append(accOwnerTF.getText() + " 님의 " + accTypeC.getSelectedItem() +" 조회 결과" + "\n");
					accListTA.append(
							"------------------------------------------------------------------------------"
							+ "---------------------------------------------------\n");
					accListTA.append("계좌종류\t\t 계좌번호\t\t예금주명\t\t\t현재잔액\t\t\t대출금액\n");
					accListTA.append(
							"=============================================================================="
							+ "===================================================\n");
					for (Account account : accOwnerList) {
						/*if (accTypeC.getSelectedIndex()!=2) {*/
							accListTA.append(account.toString()+"\n");
							cnt++;
						//}
					}
					
					if(cnt == 0) {
						accOwnerExceptionL.setText(accOwnerTF.getText()+ " 님의 "+ accTypeC.getSelectedItem() + " 목록이 없습니다.");
						accOwnerExceptionL.setForeground(Color.RED);
					}
				} catch (AccountException e1) {
					accOwnerExceptionL.setText(e1.getMessage());
					accOwnerExceptionL.setForeground(Color.RED);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, 
							  "검색 과정에서 오류가 발생했습니다.", 
							  "주의",
							  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		/**
		 * 계좌번호, 예금주 명, 입금금액, 대출금액, 비밀번호를 모두 입력하면 마이너스 계좌에 정상 등록됩니다.
		 * 계좌번호, 예금주 명, 입금금액, 비밀번호를 입력하면 입출금계좌에 정상 등록됩니다.
		 */
		registAccB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("-------------");
				if(isRegistable()&&(!accLoanTF.isEnabled()|| accLoanTF.getText().equals(""))) {
					try {
						System.out.println("1.확인");
						accountManager.add(1, accNumTF.getText(), 
										   accOwnerTF.getText(), Integer.valueOf(accPwdTF.getText()), 
										   Long.valueOf(accDepositTF.getText()));
						JOptionPane.showMessageDialog(null, 
													  accOwnerTF.getText() + " 님의 계좌가  \"입출금계좌\"로 정상 등록되었습니다!", 
													  "알림",
													  JOptionPane.INFORMATION_MESSAGE);
						setDefaultText();
					} catch (NumberFormatException e1) {
						accDepoExceptionL.setText("반드시 숫자로 입력해주세요!");
						accDepoExceptionL.setForeground(Color.RED);
						accPwdExceptionL.setText("반드시 숫자로 입력해주세요!");
						accPwdExceptionL.setForeground(Color.RED);
					} catch (AccountException e1) {
						System.out.println("1.캐치");
						JOptionPane.showMessageDialog(null, 
													  "중복되는 계좌번호 입니다!", 
													  "주의",
													  JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, 
								  "중복되는 >> 입니다!", 
								  "주의",
								  JOptionPane.ERROR_MESSAGE);
					}
				} else if (isRegistable() && accLoanTF.isEnabled() && !accLoanTF.getText().equals("")) {
					try {
						System.out.println("2.확인");
						accountManager.minusAdd(accTypeC.getSelectedIndex(), accNumTF.getText(), 
										   accOwnerTF.getText(), 
										   Integer.valueOf(accPwdTF.getText()), 
										   Long.valueOf(accDepositTF.getText()), 
										   Long.valueOf(accLoanTF.getText()));
						JOptionPane.showMessageDialog(null, 
													  accOwnerTF.getText() + " 님의 계좌가  \"마이너스계좌\"로 정상 등록되었습니다!", 
													  "알림",
													  JOptionPane.INFORMATION_MESSAGE);
						setDefaultText();
					} catch (NumberFormatException e1) {
						System.out.println("2.캐치");

						accLoanExceptionL.setText("반드시 숫자를 입력해주세요!");
						accLoanExceptionL.setForeground(Color.RED);
						accPwdExceptionL.setText("반드시 숫자로 입력해주세요!");
						accPwdExceptionL.setForeground(Color.RED);
						accDepoExceptionL.setText("반드시 숫자로 입력해주세요!");
						accDepoExceptionL.setForeground(Color.RED);
					} catch (AccountException | IOException e1) {
						
						JOptionPane.showMessageDialog(null, 
								  "등록 과정에서 오류가 발생했습니다.", 
								  "주의",
								  JOptionPane.ERROR_MESSAGE);
					} 
				} else if (!accTypeC.getSelectedItem().equals("마이너스계좌") && isRegistable() && accLoanTF.isEnabled() && accLoanTF.getText().equals("")) {
					try {
						
						accountManager.add(1, accNumTF.getText(), 
										   accOwnerTF.getText(), Integer.valueOf(accPwdTF.getText()), 
										   Long.valueOf(accDepositTF.getText()));
						JOptionPane.showMessageDialog(null, 
													  accOwnerTF.getText() + " 님의 계좌가 \"입출금계좌\"로 정상 등록되었습니다!", 
													  "알림",
													  JOptionPane.INFORMATION_MESSAGE);
						setDefaultText();
					} catch (NumberFormatException e1) {
						accDepoExceptionL.setText("반드시 숫자로 입력해주세요!");
						accDepoExceptionL.setForeground(Color.RED);
						accPwdExceptionL.setText("반드시 숫자로 입력해주세요!");
						accPwdExceptionL.setForeground(Color.RED);
					} catch (AccountException e1) {
						JOptionPane.showMessageDialog(null, 
													  e1.getMessage(), 
													  "주의",
													  JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, 
								  "등록 과정에서 오류가 발생했습니다.", 
								  "주의",
								  JOptionPane.ERROR_MESSAGE);
					}
				} else if (!accTypeC.getSelectedItem().equals("전체계좌") && accLoanTF.isEnabled() && accLoanTF.getText().equals("")) {
					accLoanExceptionL.setText("대출금액을 입력해주세요");
					accLoanExceptionL.setForeground(Color.RED);
				} else if (accNumTF.getText().equals("")) {
					accNumExceptionL.setText("계좌번호를 입력해주세요");
					accNumExceptionL.setForeground(Color.RED);
				} else if (accOwnerTF.getText().equals("")) {
					accOwnerExceptionL.setText("예금주 명을 입력해주세요");
					accOwnerExceptionL.setForeground(Color.RED);
				} else if (accPwdTF.getText().equals("")) {
					accPwdExceptionL.setText("비밀번호를 입력해주세요");
					accPwdExceptionL.setForeground(Color.RED);
				} else if (accDepositTF.getText().equals("")) {
					accDepoExceptionL.setText("입금금액을 입력해주세요");
					accDepoExceptionL.setForeground(Color.RED);
				} 
			}
		});
		
		/**
		 * 비밀번호 입력창을 마우스로 클릭할 시, 비밀번호 창, 예외처리 문구를 전부 지웁니다.
		 */
		accPwdTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accPwdTF.setText(" ");
				accPwdTF.setText("");
				accPwdExceptionL.setText(" ");
			}
		});
		
		/**
		 * 입금금액 입력창을 마우스로 클릭할 시, 입금금액 창, 예외처리 문구를 전부 지웁니다.
		 */
		accDepositTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accDepositTF.setText(" ");
				accDepositTF.setText("");
				accDepoExceptionL.setText(" ");
			}
		});
		
		/**
		 * 대출금액 입력창을 마우스로 클릭할 시, 대출금액 창, 예외처리 문구를 전부 지웁니다.
		 */
		accLoanTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				accLoanTF.setText(" ");
				accLoanTF.setText("");
				accLoanExceptionL.setText(" ");
			}
		});
		
		/**
		 *  계좌번호 포맷의 권장사항을 이벤트 처리하였습니다.
		 */
		accNumTF.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(accNumTF.getText().length() != 8) {
					accNumExceptionL.setText("'0000-0000' 8자리 숫자로 입력해주세요!(권장사항)");
					accNumExceptionL.setForeground(Color.RED);
				} else {
					accNumExceptionL.setText(" ");
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
}
