package org.cxj.integration.mybatis.service;

import java.util.List;

import javax.annotation.Resource;

import org.cxj.integration.mybatis.mapper.UserMapper;
import org.cxj.integration.mybatis.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class UserService {
	
	@Resource
	private UserMapper userMapper;
    
	public List<User> queryUsers(String searcher){
		return userMapper.queryUser(searcher);
	}
	
	public int createUser(User user) {
		return userMapper.insertSelective(user);
	}
	
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	public int deleteUser(String loginId) {
		return userMapper.deleteByPrimaryKey(loginId);
	}
	
	public User queryUserById(String loginId) {
		return userMapper.selectByPrimaryKey(loginId);
	}
	
}
