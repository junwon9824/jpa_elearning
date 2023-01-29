package io.sample.learn.dto;

 import io.sample.learn.entity.*;
 import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


 import javax.print.attribute.standard.Media;

@Builder
@Getter
@Setter
public class Filebuyrequest {

    private Long id;

    private String email;
    private String filetext;




}
