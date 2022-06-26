package vlado.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vlado.model.Note;
import vlado.model.Ticket;
import vlado.service.NoteService;
import vlado.service.TicketService;
import vlado.service.UserService;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/ticket/note/add")
	public String getNoteForm(@RequestParam Long id, Model model, Principal principal) {
		
		Ticket ticket = ticketService.findById(id).get();
		Note note = new Note();
		note.setTicket(ticket);
		note.setUser(userService.findByUsername(principal.getName()).get(0));		
		model.addAttribute("note", note);
		return "note-form";
	}
	
	@PostMapping("/ticket/note/save")
	public String saveNote(@ModelAttribute Note note) {
		
		noteService.save(note);
		return "redirect:/ticket/details?id=" + note.getTicket().getId();
	}
}
