package com.midas.note.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoteUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public NoteUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
