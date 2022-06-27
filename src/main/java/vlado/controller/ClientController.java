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
import org.springframework.web.bind.annotation.RequestParam;

import vlado.model.Client;
import vlado.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public String getAllClients(Model model) {
		
		model.addAttribute("clients", clientService.findAll());
		return "client-list";		
	}
	
	@GetMapping("/client/add")
	public String getClientForm(Model model) {
		
		model.addAttribute("client", new Client());
		return "client-form";
	}
	
	@PostMapping("/client/save")
	public String saveClient(@Valid @ModelAttribute Client client, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return "client-form";
		
		clientService.save(client);
		return "redirect:/client";
	}
	
	@GetMapping("/client/edit")
	public String getUpdateClientForm(@RequestParam Long id, Model model) {
		
		model.addAttribute("client", clientService.findById(id));
		return "client-form";
	}
	
	@GetMapping("/client/delete")
	public String getDeleteClientForm(@RequestParam Long id, Model model) {		
		
		Optional<Client> client = clientService.findById(id);
		model.addAttribute("client", client.get());
		return "client-delete";
	}
	
	@GetMapping("/client/delete-ok")
	public String delete(@RequestParam Long id) {
		
		clientService.deleteById(id);
		return "redirect:/client";
	}
}
