package pattern3;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 전상일
 *
 */
public interface UserDAO {
	
	public void create(User user) throws Exception;
	public User read(String id) throws Exception;
	public void update(User user, String id) throws Exception;
	public void delete(String id) throws Exception;
	public User certify(String id, String passwd) throws Exception;
	/*사원번호, 사원이름, 급여, 부서이름, 도시명 컬럼값을 가지는 employee list를 가져와야 한다.*/
	public List<Map<String, String>> employeeList() throws Exception;
	public List<User> listAll() throws Exception;

}
