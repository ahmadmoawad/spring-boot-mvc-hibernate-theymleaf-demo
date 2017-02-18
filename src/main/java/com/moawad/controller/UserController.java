package com.moawad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.moawad.dao.UserDao;
import com.moawad.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/user")
	public String userPage() {
		return "user";
	}

	@RequestMapping(path = "/user/add", method = RequestMethod.POST)
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
		User user = new User(name, email);
		userDao.save(user);
		return "redirect:/user";
	}

	@RequestMapping(path = "/user/get", method = RequestMethod.GET)
	public String getUsers(Model model) {
		Iterable<User> users = (List<User>) userDao.findAll();
		List<User> usersList = new ArrayList<>();
		users.forEach(e -> {
			usersList.add(e);
		});
		model.addAttribute("users", usersList);
		return "result";
	}

}
