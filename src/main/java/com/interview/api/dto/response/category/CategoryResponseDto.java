package com.interview.api.dto.response.category;

import com.interview.api.entity.category.Category;
import lombok.*;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private Long categoryId;
    private String name;



    public static List<CategoryResponseDto> of(List<Category> categories){
        return categories.stream().map(CategoryResponseDto::of).collect(Collectors.toList());
    }


    public static CategoryResponseDto of(Category category){
        return CategoryResponseDto.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();
    }
}
