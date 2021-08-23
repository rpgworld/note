package com.midas.note.repository;

import com.midas.note.domain.Member;
import com.midas.note.domain.Note;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteRepositoryTest {

    @Autowired NoteRepository noteRepository;
    @Autowired MemberRepository memberRepository;

    @AfterEach
    public void cleanup() {
        noteRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        String username = "memberA";
        String email = "midas@naver.com";

        Member member = new Member();
        memberRepository.save(member.builder()
                        .username(username)
                        .email(email)
                .build());

        Note note = new Note();
        noteRepository.save(note.builder()
                        .title(title)
                        .content(content)
                        .member(member)
                .build());

        // when
        List<Note> noteList = noteRepository.findAll();

        // then
        Note findNote = noteList.get(0);
        assertThat(findNote.getTitle()).isEqualTo(title);
        assertThat(findNote.getContent()).isEqualTo(content);
    }
}