package crudOperation.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crudOperation.services.Service;

@Controller
public class CreateUser {

	@Autowired
	Service service;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/jsp/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			
			List<ObjectError> str =result.getAllErrors();
			List<String> error= new ArrayList<String>();
			for(ObjectError m:str)
			{
				System.out.println(m.getDefaultMessage());
				error.add(m.getDefaultMessage());
			}
			model.addAttribute("error",error);
			System.out.println(error);
			return "error";
		} else {
			List<User> list = service.saveUser(user);
			// System.out.println(user.getPhone());
			// System.out.println(map);
			model.addAttribute("userMap", list);
			return "index";
		}

	}

	@RequestMapping(value = "/jsp/read/user/{id}", method = RequestMethod.GET)
	public String readUser(@PathVariable("id") String id, Model model) {
		// System.out.println(id);

		List<User> list = service.findUser(id);
		User user = list.get(0);
		if (user == null) {
			model.addAttribute("username", id);
			return "error";
		} else {
			model.addAttribute("user", user);
			return "show";
		}

	}

	@RequestMapping(value = "/jsp/find/user/{id}", method = RequestMethod.GET)
	public String findUser(@PathVariable("id") String id, Model model) {
		// User user=service.findUser(id);
		//
		List<User> list = service.findUser(id);
		User user = list.get(0);
		if (user == null) {
			model.addAttribute("username", id);
			return "error";
		} else {
			model.addAttribute("user", user);
			return "edit";
		}
		// return null;
	}

	@RequestMapping(value = "/jsp/update/user/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable("id") String id, @ModelAttribute User user, Model model) {

		System.out.println("in update:" + id);
		List<User> hash = service.updateUser(user);
		model.addAttribute("userMap", hash);

		return "index";
	}

	@RequestMapping(value = "/jsp/delete/user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") String id, Model model) {

		List<User> hs = service.deleteUser(id);
		System.out.println("delete:" + hs);
		model.addAttribute("userMap", hs);
		return "index";
	}

	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model,Exception ex)
	{
		model.addAttribute("error",ex.toString());
		return "error";
	}
	
}
