package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue
    @Column(name="activity_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goal_id")
    private Goal goal;

    private String title;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String content;

    private Long activityScore;

    // shareStatus
    // 향후 개발.
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;


}
