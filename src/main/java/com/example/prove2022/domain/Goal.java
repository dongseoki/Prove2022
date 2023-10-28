package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Goal {
    @Id
    @GeneratedValue
    @Column(name="goal_id")
    private Long id;

    // private parent_id 관계 단순화를 위해 제거.
    // 추후 필요시 작업 진행..

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    private String title;

    @Enumerated(EnumType.STRING)
    private GoalKind kind;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodicity_id")
    private PeriodicityInfo periodicityInfo;

    private String content;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Long progressRate;

    private String color;

    // private String shareStatus.
    // 향후 작업.

    private LocalDateTime createDate;
    private LocalDateTime modificationDate;


}
