package com.example.prove2022.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class File {
    @Id @GeneratedValue
    @Column(name="file_id")
    private Long id;
    private String fileName;
    private String extensionName;
    private String path;
    private Long capacity;
    private Long width;
    private Long height;
    private LocalDateTime createDate;
    private LocalDateTime modificationDate;

//    @OneToOne(mappedBy = "profilePhoto", fetch = FetchType.LAZY)
//    private Member member;
}
