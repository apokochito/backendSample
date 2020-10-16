package com.backend.app.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportDomain {

    private String _id;
    private String username; // For the Owner
    private String day;
    private String description;
    private LocalDate date;

}
