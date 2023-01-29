package io.sample.learn.repository;

import io.sample.learn.entity.File;
import io.sample.learn.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional

public interface FileRepository extends JpaRepository<File,Long> {

     File  findBytext(String text);

}
