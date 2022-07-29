package br.com.stamp.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Stamp {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime stampMoment = LocalDateTime.now();
}
