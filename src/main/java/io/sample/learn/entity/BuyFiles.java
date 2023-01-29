package io.sample.learn.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter

@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BuyFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private File file;


    public BuyFiles(Member member, File file)
    {
        this.member=member;
        this.file=file;

    }


}
