package vlado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vlado.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
