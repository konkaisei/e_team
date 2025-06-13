package com.example.music_management.entity;

import lombok.Data;

@Data
public class IE {
    private long ieId;
    private int type;
    private int amount;
    private String category;
    private long userId;
}
