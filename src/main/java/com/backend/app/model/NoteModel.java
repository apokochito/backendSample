package com.backend.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "notes")
public class NoteModel {

    //private String password;  needed?
    @Id
    private String _id;
    private String username; // For the Owner
    private String description;
    private LocalDate date;

}
