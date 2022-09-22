package com.example.prove2022.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

public class GoalTag {
    @Id
    @GeneratedValue
    @Column(name="goal_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private LocalDateTime createDate;
}
