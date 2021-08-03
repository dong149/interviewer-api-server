package com.interview.api.repository.link;

import com.interview.api.entity.link.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkJpaRepository extends JpaRepository<Link,Long> {

    @Query("SELECT l from Link l where l.deletedAt IS NULL")
    List<Link> findAllByDeletedAtIsNull();

//    @Query("SELECT l.id from link l where l.problemId = ?1 and l.url = ?2")
//    boolean isExistUrlInProblem(Long problemId, String url);

}
