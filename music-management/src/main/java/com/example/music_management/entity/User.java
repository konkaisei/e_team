package com.example.music_management.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
    private long userId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
}
