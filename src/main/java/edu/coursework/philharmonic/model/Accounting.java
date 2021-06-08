package edu.coursework.philharmonic.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Accounting 
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
@Document(collection = "accounting")
public class Accounting {
    @Id
    private String id;

    private String building;
    private String genre;
    private Organizer organizer;
    private List<Artist> artistList;
    private List<Impresario> impresarioList;
    private List<Competition> competitionList;
    private int numberOfPeople;
    private String eventDate;
    private Rooms rooms;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
