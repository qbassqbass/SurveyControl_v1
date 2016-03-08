package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import entity.UserDao;

@Controller
@RequestMapping("/admin/**")
public class AdminController {

	@RequestMapping("/admin/user-create")
	@ResponseBody
	public User create(String id, String email, String name, String fullname){
		User user = null;
		try{
			user = new User(id, fullname, email, name);
			userDao.save(user);
			
		}catch(Exception ex){
			return new User("ERROR",ex.toString(),"ERROR", "ERROR");
		}
		return user;
	}
	
	@RequestMapping("/user-delete")
	@ResponseBody
	public String delete(String id){
		try{
			User user = new User(id);
			userDao.delete(user);
		}catch(Exception ex){
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	@Autowired
	private UserDao userDao;
}
