import java.util.Calendar;

public class CalendarExample {
	
	
	// 근무 일 수 계산 메소드
	public static int getWorks(String year, String month, String date) {
		final int ONE_DAY_AS_SECOND = 24 * 60 * 60;
		Calendar today = Calendar.getInstance();
		Calendar past = Calendar.getInstance();
		
		long todayMillis = today.getTimeInMillis();
		past.set(Integer.valueOf(year), Integer.valueOf(month)-1, Integer.valueOf(date));
		long pastMillis = past.getTimeInMillis();
		int gap = (int)((todayMillis - pastMillis)/(1000*ONE_DAY_AS_SECOND)+1);
		return gap;
	}

	public static void main(String[] args) {
//		Calendar today = Calendar.getInstance(); //팩토리 메소드 : 내가 직접생성하는 것이 아니라 공간에서 요청만 하는 것
//		today = Calendar.getInstance(); //stringpool과 비슷. 생성되어있다면 직접 생성할 필요없이 팩토리에서 생성된 놈을 전달 받는 것.
//		today = Calendar.getInstance();
//		today = Calendar.getInstance();
//		today.set(Calendar.YEAR, 1987);
//		System.out.println(today);
//		
//		int year = today.get(Calendar.YEAR);
//		int month = today.get(Calendar.MONTH);
//		int date = today.get(Calendar.DATE);
//		int day = today.get(Calendar.DAY_OF_WEEK);
//		
//		System.out.println(year);
//		System.out.println(month +1);
//		System.out.println(date);
//		System.out.println(day);
//		
//		switch (day) {
//			case Calendar.SUNDAY : System.out.println("일요일"); break;
//
//			default: break;
//		}
		//Calendar today2 = new GregorianCalendar();	// 기본! 하지만 이렇게는 안한다. 객체를 부를때마다 재생성 할 필요 없음.
		
//		Calendar today = new Calendar(); //추상클래스라서 생성 안된다.
		
		long value = getWorks("1987", "3", "1");
		System.out.println(value);
		Calendar past = Calendar.getInstance();
		past.set(Integer.valueOf("1987"), Integer.valueOf("3"), Integer.valueOf("1"));
		System.out.println(past.getTimeInMillis());
		Calendar today = Calendar.getInstance();
		long todayMillis = today.getTimeInMillis();
		System.out.println(todayMillis);
	}

}
