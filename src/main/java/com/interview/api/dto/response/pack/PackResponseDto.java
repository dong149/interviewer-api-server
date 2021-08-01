package com.interview.api.dto.response.pack;


import com.interview.api.entity.pack.Pack;
import com.interview.api.entity.problem.Problem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Builder
@Getter
public class PackResponseDto {


    private Long id;
    private List<Problem> problems;
    private LocalDateTime createdAt;


    public static List<PackResponseDto> of(List<Pack> packs){
        return packs.stream().map(PackResponseDto::of).collect(Collectors.toList());
    }

    public static PackResponseDto of(Pack pack){
        return PackResponseDto.builder()
                .id(pack.getId())
                .problems(pack.getProblems())
                .createdAt(pack.getCreatedAt())
                .build();
    }
}
