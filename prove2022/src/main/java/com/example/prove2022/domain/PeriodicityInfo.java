package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PeriodicityInfo {
    @Id
    @GeneratedValue
    @Column(name="periodicity_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    TimeUnit timeUnit;

    private Long count;

    @Enumerated(EnumType.STRING)
    YesOrNo sunYn;
    @Enumerated(EnumType.STRING)
    YesOrNo monYn;
    @Enumerated(EnumType.STRING)
    YesOrNo tueYn;
    @Enumerated(EnumType.STRING)
    YesOrNo wedsYn;
    @Enumerated(EnumType.STRING)
    YesOrNo thurYn;
    @Enumerated(EnumType.STRING)
    YesOrNo friYn;
    @Enumerated(EnumType.STRING)
    YesOrNo satYn;

    private LocalDateTime createDate;
    private LocalDateTime modificationDate;
}
