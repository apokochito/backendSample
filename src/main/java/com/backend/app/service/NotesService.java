package com.backend.app.service;

import com.backend.app.domain.NoteDomain;
import com.backend.app.model.NoteModel;

import java.util.List;

public interface NotesService {

    List<NoteDomain> getNotes();

    NoteDomain createNote(NoteDomain note);

    NoteDomain updateNote(NoteDomain note, String note_id);

    void deleteNote(String note_id);
}
