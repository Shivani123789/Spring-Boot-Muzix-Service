package com.stackroute.muzixservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class TrackDetails {
    @Id
    int trackId;
    String trackName;
    String trackComment;


    public TrackDetails(int trackId, String trackName, String trackComment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackComment = trackComment;

    }


}
