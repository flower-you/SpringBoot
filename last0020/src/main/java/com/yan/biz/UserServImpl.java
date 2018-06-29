package com.yan.biz;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.yan.dao.UserMapper;
import com.yan.entity.UserBean;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServImpl implements IUserServ {
	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(UserBean user) {
		userMapper.insert(user);
	}

	@Override
	public boolean login(UserBean user) {
		Assert.notNull(user, "参数错误!");
		Assert.hasText(user.getUsername(), "参数错误!");
		Assert.hasText(user.getPassword(), "参数错误!");
		Example example = new Example(UserBean.class);
		example.createCriteria().andEqualTo("username", user.getUsername());
		example.createCriteria().andEqualTo("password", user.getPassword());
		List<UserBean> ulist = userMapper.selectByExample(example);
		if (ulist != null && ulist.size() > 0) {
			UserBean temp = ulist.get(0);
			BeanUtils.copyProperties(temp, user);
			return true;
		}
		return false;
	}

}
