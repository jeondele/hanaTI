class MethodExample {

	void printMessage(String name, String message){
      
	  System.out.println("[" + name + "] : " + message);
	
	}

	int sum(int x, int y){
      return x + y;
	}
	
	// JVM�� ���� ���� ����Ǵ� ��Ʈ������Ʈ main() �Լ�
	public static void main(String[] args){
      // �Լ� ���(ȣ��)
	  	MethodExample mp = new MethodExample ();
		mp.printMessage(" ��׸� ", "�ູ�ϼ���"); // ��ȯ�� ���� 	
      
		int result = mp.sum(30, 50); // ��ȯ�� ����
		System.out.println(result);
	} 

}
