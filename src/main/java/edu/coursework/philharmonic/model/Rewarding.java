package edu.coursework.philharmonic.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Rewarding
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
@Document(collection = "rewarding")
public class Rewarding {
    @Id
    private String id;

    private List<Artist> artistList;
    private String genre;
    private double rating;
    private String prize;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
