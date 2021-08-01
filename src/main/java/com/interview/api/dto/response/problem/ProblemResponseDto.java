package com.interview.api.dto.response.problem;


import com.interview.api.dto.response.link.LinkResponseDto;
import com.interview.api.entity.problem.Problem;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemResponseDto {

    private String content;
    private String answer;
    private List<LinkResponseDto> links;

    public static List<ProblemResponseDto> of(List<Problem> problems){
        return problems.stream()
                .map(ProblemResponseDto::of)
                .collect(Collectors.toList());
    }


    public static ProblemResponseDto of(Problem problem){
        return ProblemResponseDto.builder()
                .answer(problem.getAnswer())
                .content(problem.getContent())
                .links(LinkResponseDto.of(problem.getLinks()))
                .build();
    }
}
