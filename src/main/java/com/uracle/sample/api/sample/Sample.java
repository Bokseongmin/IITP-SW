package com.uracle.sample.api.sample;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class Sample {
    private Integer seq;
    private String id;
    private String username;
    private String password;
    private String company;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
