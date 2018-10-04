class BreakExample {
	public static void main(String[] args) {
		for(int i = 0 ; i < 10; i++) {

			System.out.println("출력 : " + i);
			break;
		}
	

		for(int i = 0 ; i < 10; i++) {
			if (i ==5)
			{
				continue;
			}
			System.out.println("출력 : " + i);
		}
		
		방그리:
		for (int i = 0 ; i < 10 ; i++ )
		{
			for (int j = 0 ; j < 10 ; j++ )
			{
				System.out.println(i + "," + j );
				if (j ==5)
				{
					break 방그리;
				}
			}
		}
	}
}
