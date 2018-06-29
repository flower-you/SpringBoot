package xaut.wjh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import xaut.wjh.dao.TUserMapper;
import xaut.wjh.entity.TUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Autowired
	private TUserMapper userMapper;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSelect() {
		Page<TUser> page = PageHelper.startPage(-10, 3);// 参数1是页码值，从1开始；参数2是每页行数
		List<TUser> ulist = userMapper.selectAll();
		System.out.println("总行数："+page.getTotal());
		System.out.println("最大页码值："+page.getPages());
		System.out.println("当前页码值："+page.getPageNum());
		ulist.forEach(System.out::println);
	}

}
