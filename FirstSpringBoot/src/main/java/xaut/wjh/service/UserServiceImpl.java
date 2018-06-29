package xaut.wjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xaut.wjh.dao.TUserMapper;
import xaut.wjh.entity.TUser;

@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class UserServiceImpl implements IUserService {

	@Autowired
	private TUserMapper usermapper;
	
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public void create(TUser user) {
		usermapper.insert(user);
	}

}
