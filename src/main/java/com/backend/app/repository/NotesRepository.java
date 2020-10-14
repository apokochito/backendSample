package com.backend.app.repository;

import com.backend.app.model.NoteModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<NoteModel, String> {
}
