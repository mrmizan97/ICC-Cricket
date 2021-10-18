package com.mizan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event extends BaseModel {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDateTime;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "event_team",
            joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "team_id") }
    )
    private  List<Team> teams;

    @OneToMany
    @JoinTable(name = "umpires_in_event",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "umpire_id")})
    private List<User> umpireList;

    @Column(nullable = true)
    private int score;
}