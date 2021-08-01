package com.interview.api.dto.response.pack;


import com.interview.api.dto.response.problem.ProblemResponseDto;
import com.interview.api.entity.category.Category;
import com.interview.api.entity.pack.Pack;
import com.interview.api.entity.problem.Problem;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PackResponseDto {


    private Long id;
    private List<ProblemResponseDto> problems;
    private LocalDateTime createdAt;
    private Long categoryId;
    private String categoryName;



    public static List<PackResponseDto> of(List<Pack> packs){
        return packs.stream().map(PackResponseDto::of).collect(Collectors.toList());
    }

    public static PackResponseDto of(Pack pack){
        return PackResponseDto.builder()
                .id(pack.getId())
                .problems(ProblemResponseDto.of(pack.getProblems()))
                .createdAt(pack.getCreatedAt())
                .build();
    }

    public static PackResponseDto of(Pack pack, Category category){
        return PackResponseDto.builder()
                .id(pack.getId())
                .problems(ProblemResponseDto.of(pack.getProblems()))
                .createdAt(pack.getCreatedAt())
                .categoryId(category.getCategoryId())
                .categoryName(category.getName())
                .build();
    }

}
