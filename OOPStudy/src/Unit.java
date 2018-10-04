/**
 * weapon과 연관관계
 * 세터 게터와 연결만하면 된다.
 * 생성자는 생성하지 않는다.
 * 
 * <참고>
 * 다이아몬드 aggregation (집합) dlfEosms 생성자 안에 웨건을 만들어 줘야 한다.;
 * ex) 	public Unit(Weagon weagon, String name) {
 * 			this.weagon = weagon;
 * 			this.name = name;
 * 		}
 * 
 * 까만 다이아몬드 Composition (집합) dlfEosms 생성자 안에 웨건을 만들어 줘야 한다.;
 * ex) 	public Unit(String name) {
 * 			this.weagon = new Weagon();
 * 			this.name = name;
 * 		}
 * @author 전상일
 *
 */
public class Unit {
	
	private Weapon weapon;
	
	private String name;
	
	public Unit() {
		
	}
	
	public Unit(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void attack() {
		weapon.attack();
	}
	
	public static void main(String[] args) {
		Unit unit = new Unit("SCV");
		
		Weapon weapon = null;
		
		weapon = new Gun();
		unit.setWeapon(weapon);
		unit.attack();
		
		weapon = new Sword();
		unit.setWeapon(weapon);
		unit.attack();
		
	}
}
