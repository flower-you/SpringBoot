package com.yan.biz;

import com.yan.entity.UserBean;

public interface IUserServ {
	public void create(UserBean user);
	boolean login(UserBean user);
}
