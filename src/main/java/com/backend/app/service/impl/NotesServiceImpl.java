package com.backend.app.service.impl;

import com.backend.app.domain.NoteDomain;
import com.backend.app.model.NoteModel;
import com.backend.app.repository.NotesRepository;
import com.backend.app.service.NotesService;
import ma.glasnost.orika.MapperFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotesServiceImpl implements NotesService {

    private NotesRepository notesRepository;
    private static Logger logger = LogManager.getLogger();
    private MapperFacade mapperFacade;

    public NotesServiceImpl(NotesRepository notesRepository, MapperFacade mapperFacade) {
        this.notesRepository = notesRepository;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<NoteDomain> getNotes() {
        logger.info("SERVICE LAYER - Getting notes...");
        List<NoteDomain> notesDomain = new ArrayList<>();
        List<NoteModel> notesModel = notesRepository.findAll();
        for (NoteModel noteModel : notesModel) {
            NoteDomain noteDomain = new NoteDomain();
            mapperFacade.map(noteModel, noteDomain);
            notesDomain.add(noteDomain);
        }
        return notesDomain;
    }

    @Override
    public NoteDomain createNote(NoteDomain noteDomain) {
        logger.info("SERVICE LAYER - Creating note...");
        NoteModel noteModel = new NoteModel();
        mapperFacade.map(noteDomain, noteModel);
        notesRepository.save(noteModel);
        NoteDomain noteDomainSaved = new NoteDomain();
        mapperFacade.map(noteModel, noteDomainSaved);
        return noteDomainSaved;
    }

    @Override
    public NoteDomain updateNote(NoteDomain noteDomain, String note_id) {
        logger.info("SERVICE LAYER - Updating note...");
        noteDomain.set_id(note_id);
        NoteModel noteModel = notesRepository.findById(note_id).orElseThrow(RuntimeException::new);
        mapperFacade.map(noteDomain, noteModel);
        notesRepository.save(noteModel);
        return noteDomain;
    }

    @Override
    public void deleteNote(String note_id) {
        logger.info("SERVICE LAYER - Deleting note...");
        notesRepository.deleteById(note_id);
    }

}
