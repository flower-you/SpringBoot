package xaut.wjh.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xaut.wjh.entity.TUser;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInsert {

	@Autowired
	private TUserMapper usermapper;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void testInsert() {
		TUser user=new TUser();
		user.setUsername("sboot");
		user.setPassword("sboot");
		int len=usermapper.insert(user);
		Assert.assertEquals(1, len);
		System.out.println(usermapper);
	}

}
