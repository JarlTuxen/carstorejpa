package dk.kea.carstorejpa.service;

import dk.kea.carstorejpa.model.Note;
import dk.kea.carstorejpa.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note findById(Long id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (!optionalNote.isPresent()){
            throw new RuntimeException("Mod " + id + " not found");
        }
        //returner indhold af optional vha. get()
        return optionalNote.get();
    }

    public Note create(Note note){
        return noteRepository.save(note);
    }

    public Note update(Note note){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return noteRepository.save(note);
    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

}

