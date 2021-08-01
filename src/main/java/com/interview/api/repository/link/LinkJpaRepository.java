package com.interview.api.repository.link;

import com.interview.api.entity.link.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkJpaRepository extends JpaRepository<Link,Long> {
}
