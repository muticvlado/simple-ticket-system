package vlado.controller;

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

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/ticket/note/add")
	public String getNoteForm(@RequestParam Long id, Model model) {
		
		Ticket ticket = ticketService.findById(id).get();
		Note note = new Note();
		note.setTicket(ticket);
		note.setUser(ticket.getUser());
		
		model.addAttribute("note", note);
		return "note-form";
	}
	
	@PostMapping("/ticket/note/save")
	public String saveNote(@ModelAttribute Note note) {
		
		noteService.save(note);
		return "redirect:/ticket/details?id=" + note.getTicket().getId();
	}
}
