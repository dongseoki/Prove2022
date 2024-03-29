package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue
    @Column(name="tag_id")
    private Long id;

    private LocalDateTime createDate;
}
