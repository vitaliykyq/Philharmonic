package edu.coursework.philharmonic.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Competition
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "competition")
public class Competition {
    @Id
    private String id;

    private String name;
    private String genre;
    private Artist laureate;
    private List<Artist> winnerList;
    private Organizer organizer;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
