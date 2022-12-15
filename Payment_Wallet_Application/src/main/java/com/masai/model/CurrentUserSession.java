package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique =  true)
    private Integer userId;

    private String uuid;

    private LocalDateTime localDateTime;

    public CurrentUserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
        this.userId = userId;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }
}
