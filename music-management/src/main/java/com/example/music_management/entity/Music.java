package com.example.music_management.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Music {
    private long musicId;
    private String title;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime duration;
    private long albumId;
    private LocalDateTime createdAt;
}
