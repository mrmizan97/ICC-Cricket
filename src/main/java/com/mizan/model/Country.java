package com.mizan.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country extends BaseModel {
    @NotNull
    @Size(min = 3)
    private String name;

    @Column(unique = true)
    private String countryCode;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "director_id", nullable = true)
    private User director;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "country_player",
            joinColumns = {@JoinColumn(name = "country_id",nullable = true)},
            inverseJoinColumns = {@JoinColumn(name = "player_id", unique = false,nullable = true)})
    private List<Player> playerList;

}