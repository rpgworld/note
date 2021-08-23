package com.midas.note.web.dto;

import com.midas.note.domain.Member;
import com.midas.note.domain.Note;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoteSaveRequestDto {
    private String title;
    private String content;
    private Member member;

    @Builder
    public NoteSaveRequestDto(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Note toEntity() {
        return Note.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
