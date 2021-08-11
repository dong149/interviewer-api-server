package com.interview.api.controller.problem;


import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.response.problem.ProblemResponseDto;
import com.interview.api.entity.problem.Problem;
import com.interview.api.service.problem.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"2. Problem"})
@RequestMapping(value = "api/v1/problem")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "pack", notes = "Id로 problem 조회")
    public ResponseEntity<BaseResponseDto> getProblemById(@PathVariable Long id) {
        Problem problem = problemService.getProblemById(id);
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "id로 problem 조회 성공", ProblemResponseDto.of(problem)), HttpStatus.OK);
    }

    // TODO : CRUD


}
