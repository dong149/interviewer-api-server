package com.interview.api.service.problem;


import com.interview.api.entity.problem.Problem;
import com.interview.api.exception.problem.ProblemNotFoundException;
import com.interview.api.repository.problem.ProblemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemJpaRepository problemJpaRepository;


    @Transactional(readOnly = true)
    public Problem getProblemById(Long id) {
        return problemJpaRepository.findById(id).orElseThrow(() -> {
            throw new ProblemNotFoundException();
        });
    }
}
