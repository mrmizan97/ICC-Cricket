package com.mizan.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team extends BaseModel{
    private String name;
    @OneToOne
    private Country country;
    @OneToMany
    @JoinTable(name = "team_members",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "player_id")})
    private List<Player> playerList;
    @ManyToMany(mappedBy = "teams")
    private List<Event> events;
    @OneToOne
    private User coach;

}
