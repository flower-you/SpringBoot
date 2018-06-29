package xaut.wjh;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {


	@Autowired
	private DataSource ds;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println(ds.getConnection());
	}

}
