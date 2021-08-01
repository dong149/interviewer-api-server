package com.interview.api.repository.pack;

import com.interview.api.entity.pack.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PackJpaRepository extends JpaRepository<Pack,Long> {

    @Query("SELECT p from Pack p where p.deletedAt IS NULL")
    List<Pack> findAllExists();

    List<Pack> findAllByDeletedAtIsNull();
}
