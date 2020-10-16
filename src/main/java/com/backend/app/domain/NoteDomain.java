package com.backend.app.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NoteDomain {

    private String _id;
    private String username; // For the Owner
    private String description;
    private LocalDate date;

}
