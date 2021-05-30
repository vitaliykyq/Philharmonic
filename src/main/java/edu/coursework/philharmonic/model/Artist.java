package edu.coursework.philharmonic.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Artist
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
@Document(collection = "artist")
public class Artist {
    @Id
    private String id;

    private String firstName;
    private String secondName;
    private int age;
    private int experience;
    private List<String> genreList;
    private List<Impresario> impresarioList;
    private String number;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
