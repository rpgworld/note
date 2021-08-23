package com.midas.note.service;

import com.midas.note.domain.Note;
import com.midas.note.repository.NoteRepository;
import com.midas.note.web.dto.NoteResponseDto;
import com.midas.note.web.dto.NoteSaveRequestDto;
import com.midas.note.web.dto.NoteUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @Transactional
    public Long save(NoteSaveRequestDto requestDto) {
        return noteRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoteUpdateRequestDto requestDto) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 존재하지 않습니다. id: " + id));
        note.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 존재하지 않습니다. id: " + id));
        noteRepository.delete(note);
        return id;
    }

    public NoteResponseDto findById(Long id) {
        Note entity = noteRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 존재하지 않습니다. id: " + id));
        return new NoteResponseDto(entity);
    }
}
