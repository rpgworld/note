package com.midas.note.web;

import com.midas.note.domain.Member;
import com.midas.note.domain.Note;
import com.midas.note.repository.MemberRepository;
import com.midas.note.repository.NoteRepository;
import com.midas.note.web.dto.NoteSaveRequestDto;
import com.midas.note.web.dto.NoteUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NoteApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private TestRestTemplate restTemplate;

    @Autowired private NoteRepository noteRepository;

    @Autowired private MemberRepository memberRepository;

    @AfterEach
    public void tearDown() throws Exception {
        noteRepository.deleteAll();
    }

    @Test
    public void Note_등록된다() throws Exception {
        // given
        String title = "title";
        String content = "content";

        String username = "dooly";
        String email = "hoit@naver.com";

        Member member = new Member();
        memberRepository.save(member.builder()
                        .username(username)
                        .email(email)
                .build());

        NoteSaveRequestDto requestDto = NoteSaveRequestDto.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();

        String url = "http://localhost:" + port + "/api/v1/note";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Note> all = noteRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void Note_수정된다() throws Exception {
        // given
        String title = "title";
        String content = "content";

        String username = "dooly";
        String email = "hoit@naver.com";

        Member member = new Member();
        memberRepository.save(member.builder()
                .username(username)
                .email(email)
                .build());

        Note saveNotes = noteRepository.save(Note.builder()
                .title(title)
                .content(content)
                .member(member)
                .build());

        Long updateId = saveNotes.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        NoteUpdateRequestDto requestDto = NoteUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/note/" + updateId;

        HttpEntity<NoteUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Note> all = noteRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}