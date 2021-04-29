package dk.kea.carstorejpa.service;

import dk.kea.carstorejpa.model.Note;
import dk.kea.carstorejpa.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note findById(Long id){
        //findById returnerer en optional
        //return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (!optionalNote.isPresent()){
            throw new EntityNotFoundException("Note " + id + " not found");
        }
        return optionalNote.get();
    }

    public Note create(Note note){
        //check for Mod sat - noten skal have en bilmodel
        return noteRepository.save(note);
    }

    public Note update(Note note){
        //check for Mod sat - noten skal have en bilmodel
        //check for at id findes
       return noteRepository.save(note);
    }

    public void deleteById(Long id){
        //check for at id findes
        noteRepository.deleteById(id);
    }
}
