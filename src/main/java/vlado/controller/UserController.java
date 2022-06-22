package vlado.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.model.Client;
import vlado.model.User;
import vlado.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", userService.findAll());
		return "user-list";		
	}
	
	@GetMapping("/add")
	public String getClientForm(Model model) {
		
		model.addAttribute("client", new Client());
		return "client-form";
	}
	
	@PostMapping("/save")
	public String saveClient(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "client-form";
		
		userService.save(user);
		return "redirect:/client";
	}
	
	@GetMapping("/edit")
	public String getUpdateClientForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("client", userService.findById(id));
		return "client-form";
	}
	
	@GetMapping("/delete")
	public String getDeleteClientForm(@RequestParam Long id, Model model) {		
		
		Optional<User> client = userService.findById(id);
		model.addAttribute("client", client.get());
		return "client-delete";
	}
	
	@GetMapping("/delete-ok")
	public String delete(@RequestParam Long id) {
		
		userService.deleteById(id);
		return "redirect:/client";
	}
}
