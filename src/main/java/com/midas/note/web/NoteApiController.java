package com.midas.note.web;

import com.midas.note.service.NoteService;
import com.midas.note.web.dto.NoteResponseDto;
import com.midas.note.web.dto.NoteSaveRequestDto;
import com.midas.note.web.dto.NoteUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NoteApiController {

    private final NoteService noteService;

    @PostMapping("/api/v1/note")
    public Long save(@RequestBody NoteSaveRequestDto requestDto) {
        return noteService.save(requestDto);
    }

    @PutMapping("/api/v1/note/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoteUpdateRequestDto requestDto) {
        return noteService.update(id, requestDto);
    }

//    @DeleteMapping("/api/v1/note/{id}")
//    public Long delete()

    @GetMapping("/api/v1/note/{id}")
    public NoteResponseDto findById(@PathVariable Long id) {
        return noteService.findById(id);
    }
}
