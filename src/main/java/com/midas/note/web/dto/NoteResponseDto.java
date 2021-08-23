package com.midas.note.web.dto;

import com.midas.note.domain.Note;
import lombok.Getter;

@Getter
public class NoteResponseDto {

    private Long id;
    private String title;
    private String content;
    private String username;

    public NoteResponseDto(Note entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.username = entity.getMember().getUsername();
    }
}
