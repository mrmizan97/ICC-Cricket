package com.mizan.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "series")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Series extends BaseModel{

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @OneToMany
    @JoinTable(name = "events_in_series",
            joinColumns = {@JoinColumn(name = "series_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> eventList;

    @OneToMany
    @JoinTable(name = "teams",
            joinColumns = {@JoinColumn(name = "series_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")})
    private List<Team> teams;
}
