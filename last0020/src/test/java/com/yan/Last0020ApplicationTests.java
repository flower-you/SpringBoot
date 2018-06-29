package com.yan;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yan.dao.UserMapper;
import com.yan.entity.UserBean;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Last0020ApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsert() throws Exception {
		UserBean user = new UserBean();
		user.setUsername("zhangsan");
		user.setPassword("333333");
		int len = userMapper.insert(user);
		assertEquals(1, len);
	}

	@Test
	public void testDelete() throws Exception {
		int len = userMapper.deleteByPrimaryKey(2L);
		assertEquals(1, len);
	}

	@Test
	public void testLoad() throws Exception {
		UserBean user = userMapper.selectByPrimaryKey(3L);
		System.out.println(user);
	}

	@Test
	public void testUpdate() throws Exception {
		UserBean user = new UserBean();
		user.setId(3L);
		user.setUsername("lisi");
		user.setPassword("444444");
		int len = userMapper.updateByPrimaryKey(user);
		assertEquals(1, len);
	}

	@Test
	public void testSelect() {
		Page<UserBean> page = PageHelper.startPage(-10, 3);// 参数1是页码值，从1开始；参数2是每页行数
		List<UserBean> ulist = userMapper.selectAll();
		System.out.println("总行数："+page.getTotal());
		System.out.println("最大页码值："+page.getPages());
		System.out.println("当前页码值："+page.getPageNum());
		ulist.forEach(System.out::println);
	}

	@Test
	public void testSelectExample() {
		Example example = new Example(UserBean.class);
		Criteria c = example.createCriteria();
		c.andBetween("id", 1L, 10L);
		c.orCondition(" username like 'yan%'");
		List<UserBean> ulist = userMapper.selectByExample(example);
		ulist.forEach(System.out::println);
	}
}
