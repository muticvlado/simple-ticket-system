package vlado.controller;

import java.time.LocalDateTime;

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

import vlado.model.Note;
import vlado.model.Ticket;
import vlado.service.ClientService;
import vlado.service.NoteService;
import vlado.service.TicketService;
import vlado.service.UserService;

@Controller
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserService userService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/")
	public String getAllTickets(Model model) {
		
		model.addAttribute("tickets", ticketService.findAll());
		return "ticket-list";
	}
		
	@GetMapping("/ticket/add")
	public String getTicketForm(Model model) {
		
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("clients", clientService.findAll());
		
		return "ticket-form";
	}
	
	@PostMapping("/ticket/save")
	public String save(@Valid @ModelAttribute Ticket ticket, BindingResult results, Model model) {
		
		if(results.hasErrors()) {
			model.addAttribute("ticket", ticket);
			model.addAttribute("users", userService.findAll());
			model.addAttribute("clients", clientService.findAll());
			return "ticket-form";
		}
		
		ticketService.save(ticket);
		return "redirect:/ticket/";
	}
	
	@GetMapping("/ticket/details")
	public String getTicketDetails(@RequestParam Long id, Model model) {
		
		model.addAttribute("ticket", ticketService.findById(id).get());
		return "ticket-details";
	}
	
	@GetMapping("/ticket/note/close")
	public String closeTicket(@RequestParam Long id) {
		
		Ticket ticket = ticketService.findById(id).get();
		ticket.setClose_date_time(LocalDateTime.now());
		
		Note closeNote = new Note();
		closeNote.setDate_time(LocalDateTime.now());
		closeNote.setText("TIKET JE ZATVOREN.");
		closeNote.setTicket(ticket);
		closeNote.setUser(ticket.getUser());		
		
		noteService.save(closeNote);
		ticketService.save(ticket);
		
		return "redirect:/ticket/";	
	}
}
