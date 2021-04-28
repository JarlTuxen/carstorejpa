package dk.kea.carstorejpa.repository;

import dk.kea.carstorejpa.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
