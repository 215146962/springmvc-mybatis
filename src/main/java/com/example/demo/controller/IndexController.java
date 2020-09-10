package com.example.demo.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.utils.JSONResult;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
    public String firstPage(){
        
		return "login";

    }
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONResult login(String username,String password
			,HttpServletRequest request, HttpServletResponse response){
		//不知道什么原因获取不到前端参数
		if ("admin".equals(username) && "123".equals(password)) {
			request.getSession().setAttribute("username", username);
			System.out.println("进来了");
			return JSONResult.ok("登录成功");
		}
		return JSONResult.errorMsg("登录失败");
	}
	
	//跳转到index.jsp页面
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("username")==null) {
			response.sendRedirect(request.getContextPath()+"/");
		}
		return "index";
	}
	
	@RequestMapping("/printPersons")
	public void printPersons() {
		List<Person> persons=personService.getPersons();
		for (Person person : persons) {
			System.out.println(person);
		}
		//这里没问题，可以查询数据库
	}
	
	
}
