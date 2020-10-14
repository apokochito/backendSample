package com.backend.app.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
public class ReportModel {

    private String id_;
    private String username; // For the Owner
    private String day;
    private String description;
    private String date;

}
