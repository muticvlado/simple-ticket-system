package vlado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.model.User;
import vlado.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/list")
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", userService.findAll());
		return "user-list";		
	}
	
	@GetMapping("/user/add")
	public String getUserForm(Model model) {
		
		model.addAttribute("user", new User());
		return "user-form";
	}
	
	@PostMapping("/user/save")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "user-form";
		}			
		
		userService.save(user);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/edit")
	public String getUpdateClientForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("user", userService.findById(id));
		return "user-form";
	}
	
	@GetMapping("/user/delete")
	public String getDeleteClientForm(@RequestParam Long id, Model model) {		
		
		User user = userService.findById(id).get();
		model.addAttribute("user", user);
		return "user-delete";
	}
	
	@GetMapping("/user/delete-ok")
	public String delete(@RequestParam Long id) {
		
		userService.deleteById(id);
		return "redirect:/user/list";
	}
}
