package io.sample.learn.dto;

 import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Filesaverequest {

    private Long id;

    private String text;

    private String description;

    private String filepath;

}
