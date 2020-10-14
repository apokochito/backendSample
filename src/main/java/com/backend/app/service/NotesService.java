package com.backend.app.service;

import com.backend.app.model.NoteModel;

import java.util.List;

public interface NotesService {

    List<NoteModel> getNotes();

    NoteModel createNote(NoteModel note);

    NoteModel updateNote(NoteModel note, String note_id);

    void deleteNote(String note_id);
}
