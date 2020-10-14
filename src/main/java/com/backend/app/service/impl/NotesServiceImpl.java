package com.backend.app.service.impl;

import com.backend.app.model.NoteModel;
import com.backend.app.repository.NotesRepository;
import com.backend.app.service.NotesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotesServiceImpl implements NotesService {

    private NotesRepository notesRepository;
    private static Logger logger = LogManager.getLogger();

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<NoteModel> getNotes() {
        logger.info("SERVICE LAYER - Getting notes...");
        return notesRepository.findAll();
    }

    @Override
    public NoteModel createNote(NoteModel note) {
        logger.info("SERVICE LAYER - Creating note...");
        return notesRepository.save(note);
    }

    @Override
    public NoteModel updateNote(NoteModel note, String note_id) {
        logger.info("SERVICE LAYER - Updating note...");
        NoteModel note_from_database = notesRepository.findById(note_id).orElseThrow(RuntimeException::new);
        note_from_database.setDate(note.getDate());
        note_from_database.setDescription(note.getDescription());
        return notesRepository.save(note);
    }

    @Override
    public void deleteNote(String note_id) {
        logger.info("SERVICE LAYER - Deleting note...");
        notesRepository.deleteById(note_id);
    }

}
