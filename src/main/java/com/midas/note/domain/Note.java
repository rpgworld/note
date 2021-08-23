package com.midas.note.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Note {

    @Id @GeneratedValue
    @Column(name = "note_id")
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자

//    @CreationTimestamp
//    private LocalDateTime createdate;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedate;

    @Builder
    public Note(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    //== 비지니스 로직 ==//
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
