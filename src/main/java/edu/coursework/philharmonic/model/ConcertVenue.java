package edu.coursework.philharmonic.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ConcertVenue
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "concertVenue")
public class ConcertVenue {
    @Id
    private String id;

    private String name;
    private double stageArea;
    private int hallCapacity ;
    private double area;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
