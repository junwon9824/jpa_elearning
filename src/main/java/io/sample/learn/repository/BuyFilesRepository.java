package io.sample.learn.repository;

import io.sample.learn.entity.BuyFiles;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional

public interface BuyFilesRepository extends JpaRepository<BuyFiles,Long> {


}
