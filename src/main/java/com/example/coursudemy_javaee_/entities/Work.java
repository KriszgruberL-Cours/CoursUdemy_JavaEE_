package com.example.coursudemy_javaee_.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {

    private Long id;
    private String title;
    private String gender;
    private int release;
    private String summary;
    private Artist mainArtist;

    public Work(String title) {
        this.title = title;
    }

}
