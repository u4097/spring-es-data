package com.myapp.elastic.model;

import lombok.Data;

@Data
public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }
}
