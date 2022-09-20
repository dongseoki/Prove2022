package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String phoneNumber;

    private String emailAddress;

    private String introduction;

    // profilePhotoId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File profilePhoto;

    // backgroundPhotoId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File backgroundPhoto;

    private String password;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;

}
