import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.utils.MybatisUtils;

public class PersonTest {
	
	
	@Test
	public void getPersons() {
		SqlSession session = MybatisUtils.getSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        System.out.println("-----------"+mapper);
		List<Person> persons=mapper.getPersons();
		for (Person person:persons) {
			System.out.println(person);
		}
		session.commit();
		MybatisUtils.close();
	}
}
