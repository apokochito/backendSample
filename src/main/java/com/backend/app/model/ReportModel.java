package com.backend.app.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "reports")
public class ReportModel {

    private String _id;
    private String username; // For the Owner
    private String day;
    private String description;
    private LocalDate date;

}
