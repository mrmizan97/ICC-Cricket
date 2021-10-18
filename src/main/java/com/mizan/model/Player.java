package com.mizan.model;
import com.mizan.enums.PlayerExpertise;
import com.mizan.enums.PlayerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player extends BaseModel{
    private PlayerStatus playerStatus;
    private PlayerExpertise expertise;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userInfo;

}