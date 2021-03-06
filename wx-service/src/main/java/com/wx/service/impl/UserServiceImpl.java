package com.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangzhaoyu.wx_model.User;
import com.wx.dao.UserMapper;
import com.wx.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	public List<User> getUser() {
		return userMapper.getUsers();
	}

}
