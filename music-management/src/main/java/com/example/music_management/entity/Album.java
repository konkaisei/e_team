package com.example.music_management.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Album {
    private long albumId;
    private String title;
    private String artist;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private LocalDateTime createdAt;
}
