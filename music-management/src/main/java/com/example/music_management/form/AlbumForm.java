package com.example.music_management.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AlbumForm {
    private String title;
    private String artist;
    private LocalDate releaseDate;

}
