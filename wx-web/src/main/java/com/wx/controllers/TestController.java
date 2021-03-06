package com.wx.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.wangzhaoyu.aspect.api.LogAspect;
import com.wangzhaoyu.wx_model.User;
import com.wx.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping("/t1")
	@LogAspect(value="�Ǻ���")
	public String t1() {
		JSONObject resultJson = new JSONObject(); 
		resultJson.put("result", "���Խ������ ");
		List<User> users = userService.getUser();
		System.out.println(users.size());
		users.forEach(u -> System.out.println(u.getName()));
		resultJson.put("data", users.get(0));
		SerializeConfig mapping = new SerializeConfig();
		mapping.put(Date.class, new SimpleDateFormatSerializer(null)); // yyyy-MM-dd
		return JSON.toJSONString(resultJson, mapping, SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect);
	}
}
