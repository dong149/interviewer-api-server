package com.interview.api.repository.problem;

import com.interview.api.entity.problem.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemJpaRepository extends JpaRepository<Problem,Long> {
}
