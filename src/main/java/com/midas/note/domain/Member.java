package com.midas.note.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;

    private String email;

//    private LocalDateTime createdate;

    @OneToMany(mappedBy = "member")
    private List<Note> notes = new ArrayList<>();

    @Builder
    public Member(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
