package vlado.service;

import java.util.List;

import vlado.model.Note;

public interface NoteService {
	
	List<Note> findAll();
	
	void save(Note note);
}
