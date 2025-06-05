package com.example.music_management.exception.handler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.music_management.exception.MusicNotFoundException;

@ControllerAdvice
public class MusicExceptionHandler {
    @ExceptionHandler(MusicNotFoundException.class)
    public String handleMusicNotFoundException(MusicNotFoundException e, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("error", "対象の楽曲が見つかりませんでした ");
    return "redirect:/albums/" + e.getAlbumId();
    }
}
