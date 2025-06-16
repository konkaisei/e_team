package com.example.music_management.entity;

import lombok.Data;

@Data
public class IE {
    private Long ieId;
    private int type;
    private int amount;
    private String category;
    private long userId;

    public Long getIeId(){
        return ieId;
    }

    public void setIeId(Long ieId){
        this.ieId = ieId;
    }
}
