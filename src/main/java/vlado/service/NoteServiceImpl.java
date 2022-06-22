package vlado.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlado.model.Note;
import vlado.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public List<Note> findAll() {
		
		return noteRepository.findAll();
	}

	@Override
	public void save(Note note) {
		
		note.setDate_time(LocalDateTime.now());
		noteRepository.save(note);		
	}

}
