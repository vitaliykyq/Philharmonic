package edu.coursework.philharmonic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rooms")
public class Rooms {
    @Id
    private String id;

    private String blockName;
    private String head;

    private PalaceOfCulture palaceOfCulture;
    private ConcertVenue concertVenue;
    private Theater theater;
    private Cinema cinema;
    private Tribune tribune;

    private Date createdAt;
    private Date modifiedAt;
    private String description;

}
