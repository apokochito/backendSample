package com.backend.app.controller;

import com.backend.app.model.NoteModel;
import com.backend.app.service.NotesService;
import com.backend.app.service.ReportsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/notes-section")
public class NotesController {

    private NotesService notesService;
    private static Logger logger = LoggerFactory.getLogger("jsonLogger");

    public NotesController(NotesService notesService, ReportsService reportsService) {
        this.notesService = notesService;
    }

    @GetMapping(value = "/notes")
    public List<NoteModel> getNotes() {
        logger.info("CONTROLLER LAYER - Getting notes...");
        return notesService.getNotes();
    }

    @PostMapping(value = "/note")
    public NoteModel createNote(@Valid NoteModel note) {
        logger.info("CONTROLLER LAYER - Creating note...");
        return notesService.createNote(note);
    }

    @PutMapping(value = "/note")
    public NoteModel updateNote(@Valid NoteModel note, String note_id) {
        logger.info("CONTROLLER LAYER - Updating note...");
        return notesService.updateNote(note, note_id);
    }

    @DeleteMapping(value= "/note")
    public void deleteNote(String note_id){
        logger.info("CONTROLLER LAYER - Deleting note...");
        notesService.deleteNote(note_id);
    }

}
