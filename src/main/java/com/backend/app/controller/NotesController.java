package com.backend.app.controller;

import com.backend.app.domain.NoteDomain;
import com.backend.app.service.NotesService;
import com.backend.app.service.ReportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/notes-section")
public class NotesController {

    private NotesService notesService;
    private static Logger logger = LogManager.getLogger();

    public NotesController(NotesService notesService, ReportsService reportsService) {
        this.notesService = notesService;
    }

    @GetMapping(value = "/notes")
    @ResponseBody
    public ResponseEntity<Object> getNotes() {
        logger.info("CONTROLLER LAYER - Getting notes...");
        return new ResponseEntity<>(notesService.getNotes(), HttpStatus.OK);
    }

    @PostMapping(value = "/note", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Object> createNote(@RequestBody @Valid NoteDomain note) {
        logger.info("CONTROLLER LAYER - Creating note...");
        return new ResponseEntity<>(notesService.createNote(note), HttpStatus.CREATED);
    }

    @PutMapping(value = "/note/{note_id}", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Object> updateNote(@RequestBody @Valid NoteDomain note, @PathVariable String note_id) {
        logger.info("CONTROLLER LAYER - Updating note...");
        return new ResponseEntity<>(notesService.updateNote(note, note_id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/note/{note_id}")
    public String deleteNote(@PathVariable String note_id) {
        logger.info("CONTROLLER LAYER - Deleting note...");
        notesService.deleteNote(note_id);
        return "Note deleted.";
    }

}
